package com.nezttech.kanban;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author NezTTech
 * @version 1.0
 * @since   2021-12-01
*/
public class ServletInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KanbanApplication.class);
	}

}
