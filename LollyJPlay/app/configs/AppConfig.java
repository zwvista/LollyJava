package configs;

import org.springframework.context.annotation.ComponentScan;

import com.zwstudio.lolly.util.LollyConfigSpringDataJpa;


@ComponentScan({"controllers"})
public class AppConfig extends LollyConfigSpringDataJpa {


}