package com.zwstudio.lolly.ui.viewmodel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.jgoodies.binding.beans.Model;
import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.DictAllId;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;

public class LollyViewModel extends Model {
	@Autowired
	protected LanguageDao langDao;
	@Autowired
	protected DictionaryDao dictDao;
	@Autowired
	protected DictAllDao dictallDao;
	
	protected DictAll dict;
	public String word;
	public Language selectedLang;
	public Dictionary selectedDict;
	
	private Map<String, String> escapes = new HashMap<String, String>() {{
		put("<delete>", ""); put("\\t", "\t");
		put("\\r", "\r"); put("\\n", "\n");
	}};

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		firePropertyChange("word", this.word, this.word = word);
	}

	public Language getSelectedLang() {
		return selectedLang;
	}

	public void setSelectedLang(Language selectedLang) {
		firePropertyChange("selectedLang", this.selectedLang, this.selectedLang = selectedLang);
	}

	public Dictionary getSelectedDict() {
		return selectedDict;
	}

	public void setSelectedDict(Dictionary selectedDict) {
		firePropertyChange("selectedDict", this.selectedDict, this.selectedDict = selectedDict);
	}

	protected void updateDict(DictionaryId id2) {
		dict = dictallDao.getDataByLangDict(id2.getLangid(), id2.getDictname());
	}
	
	protected String getUrlByWord(String word) {
		String url = dict.getUrl().replace("{0}", "%s");
		try {
			url = String.format(url, URLEncoder.encode(word, "UTF-8"));
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
