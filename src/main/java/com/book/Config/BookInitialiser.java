package com.book.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BookInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	
		@Override
		protected Class<?>[] getRootConfigClasses() {
			
			return null;
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			Class arr[]= {BookConfig.class};
			return arr;
		}

		@Override
		protected String[] getServletMappings() {
			String arr[]= {"/"};
			return arr;
		}

	}



