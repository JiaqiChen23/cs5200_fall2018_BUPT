package edu.northeastern.cs5200;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import edu.northeastern.cs5200.dao.DeveloperImpl;
import edu.northeastern.cs5200.dao.PageImpl;
import edu.northeastern.cs5200.dao.RoleImpl;
import edu.northeastern.cs5200.dao.WebsiteImpl;
import edu.northeastern.cs5200.dao.WidgetImpl;
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Team;
import edu.northeastern.cs5200.model.Player;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		}
	}
