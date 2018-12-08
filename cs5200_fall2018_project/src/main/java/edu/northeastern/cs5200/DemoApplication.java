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
import edu.northeastern.cs5200.model.Fans;
import edu.northeastern.cs5200.model.HeadingWidget;
import edu.northeastern.cs5200.model.Team;
import edu.northeastern.cs5200.model.Role;
import edu.northeastern.cs5200.model.Website;
import edu.northeastern.cs5200.model.Widget;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
			Date t = new Date(System.currentTimeMillis());
			Fans d = new Fans(2,"werv","ewrtwer","asdv","asd","wawcd",t,"pinv");
			Website w = new Website(d,2,"ihoha","wonc",t,t,60000);
			DeveloperImpl DD = new DeveloperImpl();
			WebsiteImpl WI = new WebsiteImpl();
			WI.createWebsiteForDeveloper(2, w);
			
			Team pg = new Team(0, null, null, t, t, 0);
			PageImpl PI = new PageImpl();
			PI.createPageForWebsite(2, pg);
			Widget wid = new HeadingWidget(0, null, 0, 0, null, null, null, 0, null, 0);
			WidgetImpl WII = new WidgetImpl();
			WII.createWidgetForPage(1, wid);
			RoleImpl.getInstance().assignWebsiteRole(2, 2, Role.editor.ordinal());
//			DD.createDeveloper(d);
//			DD.findDeveloperById(2);
//			DD.createDeveloper(d);
//			for(Website wa:WI.findWebsitesForDeveloper(2))
//				System.out.println(wa.getName());
		}
	}
