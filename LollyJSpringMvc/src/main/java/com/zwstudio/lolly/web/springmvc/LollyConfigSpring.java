package com.zwstudio.lolly.web.springmvc;  
  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("com.zwstudio.lolly.web.springmvc")
@EnableWebMvc
public class LollyConfigSpring implements WebMvcConfigurer {
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    // jstl bean
    @Bean
    public UrlBasedViewResolver jspViewResolver() {
    	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
    	viewResolver.setPrefix("/WEB-INF/views/");
    	viewResolver.setSuffix(".jsp");
    	viewResolver.setViewClass(JstlView.class);
    	viewResolver.setViewNames("jsp/*");
        return viewResolver;
    }
    
    // thymeleaf beans
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
    	SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    @Bean
    public ViewResolver thymeViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver() ;
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setViewNames(new String[] {"thm/*"});
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setCache(false);
        return viewResolver;
    }
    
    // freemarker beans
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
    	FreeMarkerConfigurer config = new FreeMarkerConfigurer();
    	config.setTemplateLoaderPath("/WEB-INF/views/");
    	return config;
    }
    @Bean
    public ViewResolver freemarkerViewResolver() {
    	FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
    	viewResolver.setCache(false);
    	viewResolver.setViewNames("ftl/*");
    	viewResolver.setSuffix(".html");
    	viewResolver.setContentType("text/html;charset=UTF-8");
    	return viewResolver;
    }
    
    // xslt beans
    @Bean
    public ViewResolver xsltViewResolver() {
    	XsltViewResolver viewResolver = new XsltViewResolver();
    	viewResolver.setCache(false);
    	viewResolver.setPrefix("/WEB-INF/views/");
    	viewResolver.setViewNames("xsl/*");
    	viewResolver.setSuffix(".xslt");
    	viewResolver.setSourceKey("xmlSource");
    	viewResolver.setViewClass(XsltView.class);
    	return viewResolver;
    }
}
