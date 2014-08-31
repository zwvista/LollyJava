import java.util.List;

import org.hibernate.Session;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.util.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		Session ss = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Language> result = ss.createCriteria(Language.class).list();
		for(Language lang : result) {
			System.out.println(lang.getName());
		}
		ss.close();
	}

}
