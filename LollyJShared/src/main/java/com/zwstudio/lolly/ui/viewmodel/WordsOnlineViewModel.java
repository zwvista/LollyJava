package com.zwstudio.lolly.ui.viewmodel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jgoodies.binding.beans.Model;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

import lombok.Getter;

@SuppressWarnings("serial")
public class WordsOnlineViewModel extends Model {
	
	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired @Qualifier("dictionaryDao")
	protected IDictionaryService dictDao;
	
	protected Dictionary dict;
	@Getter
	public String word;
	@Getter
	public Language selectedLang;
	@Getter
	public Dictionary selectedDict;
	
	private Map<String, String> escapes = new HashMap<String, String>() {{
		put("<delete>", ""); put("\\t", "\t");
		put("\\r", "\r"); put("\\n", "\n");
	}};

	public void setWord(String word) {
		firePropertyChange("word", this.word, this.word = word);
	}

	public void setSelectedLang(Language selectedLang) {
		firePropertyChange("selectedLang", this.selectedLang, this.selectedLang = selectedLang);
	}

	public void setSelectedDict(Dictionary selectedDict) {
		firePropertyChange("selectedDict", this.selectedDict, this.selectedDict = selectedDict);
	}
	
	protected String getUrlByWord(String word) {
		String url = dict.getUrl();
		try {
			url = url.replace("{0}", URLEncoder.encode(word, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(url);
		return url;
	}
	
	private String doTransform(String text, String reg, String replacer) {
		for(Entry<String, String> entry : escapes.entrySet())
			replacer = replacer.replace(entry.getKey(), entry.getValue());
		text = text.replaceAll(reg, replacer);
		
		return text;
	}
	
	protected String extractFromHtml(String html, String word) throws IOException {
		String transform = dict.getTransformWin();
		String[] arr = null;
		arr = transform.split("\n");
		
		boolean debugExtract = false;
		String logFolder = "E:\\Programs\\Lolly\\LollyJava\\log\\";
		if(debugExtract) {
			Files.write(Paths.get(logFolder + "0_raw.html"), html.getBytes(), StandardOpenOption.CREATE);
			arr = Files.readAllLines(Paths.get(logFolder + "1_transform.txt")).toArray(arr);
		}
		
		Matcher m = Pattern.compile(arr[0]).matcher(html);
		if(!m.find()) return "";
		
		String text = doTransform(m.group(0), arr[0], arr[1]);
		if(debugExtract)
			Files.write(Paths.get(logFolder + "2_extracted.txt"), text.getBytes(), StandardOpenOption.CREATE);

		for(int i = 2; i < arr.length; i += 2)
			text = doTransform(text, arr[i], arr[i + 1]);
		if(debugExtract)
			Files.write(Paths.get(logFolder + "3_cooked.txt"), text.getBytes(), StandardOpenOption.CREATE);

		String template = dict.getTemplate();
		template = template.replaceAll("\\{\\d\\}", "%s");
		text = String.format(template, word, "", text);
		if(debugExtract)
			Files.write(Paths.get(logFolder + "6_result.html"), text.getBytes(), StandardOpenOption.CREATE);

		return text;
	}

}