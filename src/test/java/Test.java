import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.util.LollyConfig;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LollyConfig.class);
		DictAllDao dictalldao = context.getBean(DictAllDao.class);
		List<DictAll> result = dictalldao.getData();
		for(DictAll da : result) {
			System.out.println(da.getDictname());
		}
	}

}
