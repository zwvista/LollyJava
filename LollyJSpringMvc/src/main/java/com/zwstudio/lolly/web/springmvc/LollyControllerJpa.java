package com.zwstudio.lolly.web.springmvc;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.services.IDictAllService;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

@Controller
@RequestMapping("/jpa/")
public class LollyControllerJpa {
	@Autowired @Qualifier("languageRepository")
	protected ILanguageService langService;
	@Autowired @Qualifier("dictionaryRepository")
	protected IDictionaryService dictService;
	@Autowired @Qualifier("dictAllRepository")
	protected IDictAllService dictallService;
	
	@ModelAttribute("formBean")
	public LollyFormBean createFormBean() {
		LollyFormBean bean = new LollyFormBean();
		bean.word = "一人";
		bean.langList = langService.getData();
		bean.langMap = langService.getIdNameMap();
		return bean;
	}
	
	@RequestMapping(value="dictList", method=RequestMethod.GET)
	public @ResponseBody List<Dictionary> dictList(
			@RequestParam(value="langid", required=true) int langid,
			ModelMap modelMap) {
		return dictService.getDataByLang(langid);
	}
	
	@RequestMapping(value="dictall", method=RequestMethod.GET)
	public @ResponseBody List<ObjectError> dictall(
			@Valid @ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) {
		return bindingResult.getAllErrors();
	}
	
	@RequestMapping(value="dictList2", method=RequestMethod.GET)
	public @ResponseBody List<String> dictList2(
			@RequestParam(value="langid", required=true) int langid,
			ModelMap modelMap) {
		return dictService.getNamesByLang(langid);
	}

	@RequestMapping(value="dictall2", method=RequestMethod.GET)
	public @ResponseBody DictAll dictall2(
			@RequestParam(value="langid", required=true) int langid,
			@RequestParam(value="dictname", required=true) String dictname,
			ModelMap modelMap) {
		return dictallService.getDataByLangDict(langid, dictname);
	}
	
	@RequestMapping(value="dictList3", method=RequestMethod.POST)
	public @ResponseBody List<String> dictList3(
			@ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) {
		return dictService.getNamesByLang(bean.selectedLangID);
	}

	@RequestMapping(value="dictall3", method=RequestMethod.POST)
	public @ResponseBody DictAll dictall3(
			@ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) {
		return dictallService.getDataByLangDict(bean.selectedLangID, bean.selectedDictName);
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
    public ModelAndView lolly7(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
    	LollyFormBean bean = createFormBean();
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
