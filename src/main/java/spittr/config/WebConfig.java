package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.exceptions.TemplateAssertionException;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr")
public class WebConfig extends WebMvcConfigurerAdapter{
	 @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
	 
//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }
    
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
//    	tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/layout/tiles.xml", "/WEB-INF/**/tiles.xml"});
//    	tilesConfigurer.setCheckRefresh(true);
//    	return tilesConfigurer;
//    }
//    
//    
//    @Bean
//    public ViewResolver viewResolver() {
//    	return new TilesViewResolver();
//    }

	 @Bean
	 public TemplateResolver templateResolver() {
		 TemplateResolver templateResolver = new ServletContextTemplateResolver();
		 templateResolver.setPrefix("/WEB-INF/templates/");
		 templateResolver.setSuffix(".html");
		 templateResolver.setTemplateMode("HTML5");
		 return templateResolver;
	 }
	 
	 @Bean
	 public TemplateEngine templateEngine(TemplateResolver templateResolver) {
		 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		 templateEngine.setTemplateResolver(templateResolver);
		 return templateEngine;
	 }
	 
	 @Bean
	 public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	 }
   @Bean
   public MultipartResolver multipartResolver() {
	   return new StandardServletMultipartResolver();
   }
}
