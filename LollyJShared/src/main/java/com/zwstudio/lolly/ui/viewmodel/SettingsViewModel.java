package com.zwstudio.lolly.ui.viewmodel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jgoodies.binding.beans.Model;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.domain.Textbook;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;
import com.zwstudio.lolly.services.ITextbookService;
import com.zwstudio.lolly.services.IUserSettingService;

import lombok.Getter;

@SuppressWarnings("serial")
public class SettingsViewModel extends Model {
	
	@Autowired
	private IUserSettingService usersettingDao;
	@Autowired @Qualifier("languageDao")
	private ILanguageService langDao;
	@Autowired @Qualifier("dictionaryDao")
	private IDictionaryService dictDao;
	@Autowired
	private ITextbookService textbookDao;

	@Getter
	protected String word;
	@Getter
	protected List<Language> langList = new ArrayList<>();
	@Getter
	protected List<Dictionary> dictList = new ArrayList<>();
	@Getter
	protected List<Textbook> textbookList = new ArrayList<>();
	@Getter
	protected List<Integer> unitList = new ArrayList<>();
	@Getter
	protected List<Integer> partList = new ArrayList<>();
	protected String[] partNames;
	@Getter
	protected Language selectedLang;
	@Getter
	protected Dictionary selectedDict;
	@Getter
	protected Textbook selectedTextbook;
	@Getter
	protected Integer selectedUnitFrom;
	@Getter
	protected Integer selectedUnitTo;
	@Getter
	protected Integer selectedPartFrom;
	@Getter
	protected Integer selectedPartTo;

	private Map<String, String> escapes = new HashMap<String, String>() {{
		put("<delete>", ""); put("\\t", "\t");
		put("\\r", "\r"); put("\\n", "\n");
	}};
	
	public void init() {
		langList.addAll(langDao.getData());
		int langid = usersettingDao.getData().getUslangid();
		Language lang = langList.stream().filter(o -> o.getId() == langid)
				.findFirst().orElse(langList.get(0));
		setSelectedLang(lang);
		setWord("一人");
	}

	public void setWord(String word) {
		firePropertyChange("word", this.word, this.word = word);
	}

	public void setSelectedLang(Language selectedLang) {
		if(selectedLang == null) return;
		firePropertyChange("selectedLang", this.selectedLang, this.selectedLang = selectedLang);
		int langid = selectedLang.getId();
		
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(langid));
		Dictionary dict = dictList.stream().filter(o -> o.getId() == selectedLang.getUsdictid())
				.findFirst().orElse(dictList.get(0));
		setSelectedDict(dict);

		textbookList.clear();
		textbookList.addAll(textbookDao.getDataByLang(langid));
		Textbook textbook = textbookList.stream().filter(o -> o.getId() == selectedLang.getUstextbookid())
				.findFirst().orElse(textbookList.get(0));
		setSelectedTextbook(textbook);
	}

	public void setSelectedDict(Dictionary selectedDict) {
		firePropertyChange("selectedDict", this.selectedDict, this.selectedDict = selectedDict);
	}

	public void setSelectedTextbook(Textbook selectedTextbook) {
		if(selectedTextbook == null) return;
		firePropertyChange("selectedTextbook", this.selectedTextbook, this.selectedTextbook = selectedTextbook);
		unitList.clear();
		unitList.addAll(IntStream.rangeClosed(1, selectedTextbook.getUnits())
				.boxed().collect(Collectors.toList()));
		setSelectedUnitFrom(null);
		setSelectedUnitFrom(selectedTextbook.getUsunitfrom());
		setSelectedUnitTo(null);
		setSelectedUnitTo(selectedTextbook.getUsunitto());
		partNames = selectedTextbook.getParts().split(" ");
		partList.clear();
		partList.addAll(IntStream.rangeClosed(1, partNames.length)
				.boxed().collect(Collectors.toList()));
		setSelectedPartFrom(null);
		setSelectedPartFrom(partList.get(selectedTextbook.getUspartfrom() - 1));
		setSelectedPartTo(null);
		setSelectedPartTo(partList.get(selectedTextbook.getUspartto() - 1));
	}

	public void setSelectedUnitFrom(Integer selectedUnitFrom) {
		firePropertyChange("selectedUnitFrom", this.selectedUnitFrom, this.selectedUnitFrom = selectedUnitFrom);
	}

	public void setSelectedUnitTo(Integer selectedUnitTo) {
		firePropertyChange("selectedUnitTo", this.selectedUnitTo, this.selectedUnitTo = selectedUnitTo);
	}

	public void setSelectedPartFrom(Integer selectedPartFrom) {
		firePropertyChange("selectedPartFrom", this.selectedPartFrom, this.selectedPartFrom = selectedPartFrom);
	}

	public void setSelectedPartTo(Integer selectedPartTo) {
		firePropertyChange("selectedPartTo", this.selectedPartTo, this.selectedPartTo = selectedPartTo);
	}

	protected String getUrlByWord(String word) {
		String url = getSelectedDict().getUrl();
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
		String transform = getSelectedDict().getTransformWin();
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

		String template = getSelectedDict().getTemplate();
		template = template.replaceAll("\\{\\d\\}", "%s");
		text = String.format(template, word, "", text);
		if(debugExtract)
			Files.write(Paths.get(logFolder + "6_result.html"), text.getBytes(), StandardOpenOption.CREATE);

		return text;
	}

}
