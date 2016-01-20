package com.zwstudio.lolly.web.springmvc;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.services.IDictAllService;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

@Controller
@RequestMapping("/{orm}/")
public class LollyController {
	@Autowired
	private ILanguageService languageDao;
	@Autowired
	private IDictionaryService dictionaryDao;
	@Autowired
	private IDictAllService dictAllDao;
	@Autowired
	private ILanguageService languageRepository;
	@Autowired
	private IDictionaryService dictionaryRepository;
	@Autowired
	private IDictAllService dictAllRepository;
	@Autowired
	private ILanguageService languageService;
	@Autowired
	private IDictionaryService dictionaryService;
	@Autowired
	private IDictAllService dictAllService;
	
	public ILanguageService getLangService(String orm) {
		return "hibernate".equals(orm) ? languageDao :
			"jpa".equals(orm) ? languageRepository :
			"mybatis".equals(orm) ? languageService :
			null;
	}
	
	public IDictionaryService getDictService(String orm) {
		return "hibernate".equals(orm) ? dictionaryDao :
			"jpa".equals(orm) ? dictionaryRepository :
			"mybatis".equals(orm) ? dictionaryService :
			null;
	}
	
	public IDictAllService getDictAllService(String orm) {
		return "hibernate".equals(orm) ? dictAllDao :
			"jpa".equals(orm) ? dictAllRepository :
			"mybatis".equals(orm) ? dictAllService :
			null;
	}
	
	@ModelAttribute("formBean")
	public LollyFormBean createFormBean(@PathVariable String orm) {
		LollyFormBean bean = new LollyFormBean();
		bean.word = "一人";
		bean.langList = getLangService(orm).getData();
		bean.langMap = getLangService(orm).getIdNameMap();
		return bean;
	}
	
	@RequestMapping(value="dictList", method=RequestMethod.GET)
	public @ResponseBody List<Dictionary> dictList(
			@PathVariable String orm,
			@RequestParam(value="langid", required=true) int langid) {
		return getDictService(orm).getDataByLang(langid);
	}
	
	@RequestMapping(value="validate", method=RequestMethod.GET)
	public ResponseEntity<Object> validate(
			@Valid @ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) throws JsonProcessingException {
		return bindingResult.hasErrors() ? 
				new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST) :
				new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@RequestMapping(value="dictList2", method=RequestMethod.GET)
	public @ResponseBody List<String> dictList2(
			@PathVariable String orm,
			@RequestParam(value="langid", required=true) int langid) {
		return getDictService(orm).getNamesByLang(langid);
	}

	@RequestMapping(value="dictall2", method=RequestMethod.GET)
	public @ResponseBody DictAll dictall2(
			@PathVariable String orm,
			@RequestParam(value="langid", required=true) int langid,
			@RequestParam(value="dictname", required=true) String dictname) {
		return getDictAllService(orm).getDataByLangDict(langid, dictname);
	}
	
	@RequestMapping(value="dictList3", method=RequestMethod.POST)
	public @ResponseBody List<String> dictList3(
			@PathVariable String orm,
			@ModelAttribute("formBean") LollyFormBean bean) {
		return getDictService(orm).getNamesByLang(bean.selectedLangID);
	}

	@RequestMapping(value="dictall3", method=RequestMethod.POST)
	public ResponseEntity<Object> dictall3(
			@PathVariable String orm,
			@Valid @ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) {
		return bindingResult.hasErrors() ?
				new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST) :
				new ResponseEntity<>(getDictAllService(orm).getDataByLangDict(bean.selectedLangID, bean.selectedDictName), HttpStatus.OK);
	}

	@RequestMapping(value="search", method=RequestMethod.POST)
	public RedirectView search(
			@PathVariable String orm,
			@Valid @ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult,
			RedirectAttributes attr, HttpSession session) {
		if(bindingResult.hasErrors()) {
		    attr.addFlashAttribute("org.springframework.validation.BindingResult.formBean", bindingResult);
		    attr.addFlashAttribute("formBean", bean);
		    return new RedirectView("error");
		} else {
			String url = getDictAllService(orm).getDataByLangDict(bean.selectedLangID, bean.selectedDictName).getUrl()
					.replace("{0}", bean.word);
			System.out.println(url);
			return new RedirectView(url);
		}
	}
	
    @RequestMapping("error")
    public String error() {
        return "jsp/error";
    }
    @RequestMapping("lolly1")
    public String lolly1() {
        return "jsp/lolly1";
    }
    @RequestMapping("lolly2")
    public String lolly2() {
        return "jsp/lolly2";
    }
    @RequestMapping("lolly3")
    public String lolly3() {
        return "jsp/lolly3";
    }
    @RequestMapping("lolly32")
    public String lolly32() {
        return "jsp/lolly32";
    }
    @RequestMapping("lolly33")
    public String lolly33() {
        return "jsp/lolly33";
    }
    @RequestMapping("lolly4")
    public String lolly4() {
        return "thm/lolly4";
    }
    @RequestMapping("lolly5")
    public String lolly5() {
        return "vm/lolly5";
    }
    @RequestMapping("lolly52")
    public String lolly52() {
        return "vm/lolly52";
    }
    @RequestMapping("lolly6")
    public String lolly6() {
        return "ftl/lolly6";
    }
    @RequestMapping("lolly62")
    public String lolly62() {
        return "ftl/lolly62";
    }
    @RequestMapping("lolly7")
    public ModelAndView lolly7(
			@PathVariable String orm,
    		HttpServletRequest request,
            HttpServletResponse response) throws IOException {
    	LollyFormBean bean = createFormBean(orm);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(baos);
		xmlEncoder.writeObject(bean);
		xmlEncoder.close();
    	String xmlStr = baos.toString();
    	System.out.println(xmlStr);
    	Source source = new StreamSource(new StringReader(xmlStr));
    	ModelAndView model = new ModelAndView("xsl/lolly7");
    	model.addObject("xmlSource", source);
        return model;
    }
}
