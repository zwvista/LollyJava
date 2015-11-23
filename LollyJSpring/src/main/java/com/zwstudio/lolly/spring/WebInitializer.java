package com.zwstudio.lolly.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.zwstudio.lolly.util.LollyConfigHibernate;
import com.zwstudio.lolly.util.LollyConfigMyBatis;
import com.zwstudio.lolly.util.LollyConfigSpringDataJpa;

public class WebInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {     
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(LollyConfigHibernate.class, LollyConfigSpringDataJpa.class, LollyConfigMyBatis.class, LollyConfigSpring.class);
        ctx.setServletContext(servletContext);
        
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
