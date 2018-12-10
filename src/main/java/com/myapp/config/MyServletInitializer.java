package com.myapp.config;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import com.myapp.*;

import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer{
	
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
    	myServlet.addMapping("/custom/**");
    	
    }
}
