package com.zwstudio.lolly.web.springmvc;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zwstudio.lolly.spring.data.jpa.DictAllRepository;
import com.zwstudio.lolly.spring.data.jpa.DictionaryRepository;
import com.zwstudio.lolly.spring.data.jpa.LanguageRepository;

@Controller
@RequestMapping("/jpa/")
public class LollyControllerJpa {
	@Autowired
	protected LanguageRepository langRepository;
	@Autowired
	protected DictionaryRepository dictRepository;
	@Autowired
	protected DictAllRepository dictallRepository;
	
	private Gson gson = new Gson();

	@ModelAttribute("formBean")
	public LollyFormBean createFormBean() {
		LollyFormBean bean = new LollyFormBean();
		bean.word = "一人";
		bean.langList = langRepository.getData();
		bean.langMap = langRepository.getIdNameMap();
		return bean;
	}
	
	@RequestMapping(value="dictList", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictList(
			@RequestParam(value="langid", required=true) int langid,
			ModelMap modelMap) {
		return createJsonResponse(dictRepository.getDataByLang(langid));
	}
	
	@RequestMapping(value="dictList2", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictList2(
			@RequestParam(value="langid", required=true) int langid,
			ModelMap modelMap) {
		return createJsonResponse(
			dictRepository.getNamesByLang(langid)
		);
	}

	@RequestMapping(value="dictall2", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictall2(
			@RequestParam(value="langid", required=true) int langid,
			@RequestParam(value="dictname", required=true) String dictname,
			ModelMap modelMap) {
		return createJsonResponse(
			dictallRepository.getDataByLangDict(langid, dictname)
		);
	}
	
	@RequestMapping(value="dictList3", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictList3(
			@ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) {
		return createJsonResponse(
			dictRepository.getNamesByLang(bean.selectedLangID)
		);
	}

	@RequestMapping(value="dictall3", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictall3(
			@ModelAttribute("formBean") LollyFormBean bean,
			BindingResult bindingResult) {
		return createJsonResponse(
			dictallRepository.getDataByLangDict(bean.selectedLangID, bean.selectedDictName)
		);
	}

	private ResponseEntity<String> createJsonResponse(Object o) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    String json = gson.toJson(o);
	    System.out.println(json);
	    return new ResponseEntity<String>(json, headers, HttpStatus.CREATED);
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
