package com.myapp.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import com.myapp.MyFilter;

public class MyFilterInitializer implements WebApplicationInitializer {
	
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
    	myFilter.addMappingForUrlPatterns(null, false, "/custom/*");
    	
    }
    
}
