import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Language;


public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_context.xml");
		LanguageDao langdao = context.getBean(LanguageDao.class);
		List<Language> result = langdao.list();
		for(Language lang : result) {
			System.out.println(lang.getName());
		}
	}

}
