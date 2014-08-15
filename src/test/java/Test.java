import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.util.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		Session ss = HibernateUtil.getSessionFactory().openSession();
		List result = ss.createCriteria(Language.class).list();
		for(Iterator it = result.iterator(); it.hasNext();) {
			Language lang = (Language) it.next();
			System.out.println(lang.getName());  
		}
		ss.close();
	}

}
