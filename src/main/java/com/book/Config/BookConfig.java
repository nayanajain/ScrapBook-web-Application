package com.book.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.book.dao.Scrapdao;
import com.book.dao.ScrapdaoImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.book"})
public class BookConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}  
	
	
	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		return messageSource;
	}
	

	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3300/scrapbook");
		dataSource.setUsername("root");
		dataSource.setPassword("aptech");
		return dataSource;
		
	}  
	
	@Bean
	JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate  jdbcTemplate=new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}

	
//	 @Bean
//		public Scrapdao getScrapDao()
//		{
//	    	
//			return new ScrapdaoImpl(getDataSource());
//		}
	 
	 @Bean
	 public DayOfWeekBasedAccessInterceptor dayOfWeekBasedAccessInterceptor()
	 {
		 return new DayOfWeekBasedAccessInterceptor();
	 }


	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		registry.addInterceptor(dayOfWeekBasedAccessInterceptor());
	}


	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/url/**")
		.addResourceLocations("/resourc/");

		registry.addResourceHandler("/urltoimg/**")
		.addResourceLocations("/resourc/imgs/");     //shorten image url
	}  
	
	
	
	
	 
	 

	
	 

}
