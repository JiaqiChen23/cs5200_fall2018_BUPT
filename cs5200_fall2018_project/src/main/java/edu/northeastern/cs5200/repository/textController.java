package edu.northeastern.cs5200.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.dao.FanImpl;
import edu.northeastern.cs5200.dao.PersonImpl;
import edu.northeastern.cs5200.dao.SponsorImpl;
import edu.northeastern.cs5200.model.Allstar;
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Person;
import edu.northeastern.cs5200.model.Sponsor;
import edu.northeastern.cs5200.model.Team;

@RestController
public class textController {
	@Autowired
    private textRepository tController;
 

    @GetMapping("/test/fans/{FId}")
    public List<Allstar> findFansFollowedPlayers(@PathVariable("FId") int FId) 
	{
		FanImpl fanI = new FanImpl();
		Allstar a = new Allstar();
		Team team = new Team();
		List<Allstar> b = new ArrayList<Allstar>();
		b.add(a);
		Fan fan = fanI.findFanById(FId);
		Date date = new Date(1789,2,3);
		Sponsor sponsor = new Sponsor(1, "abc", "idt", 
				"idj", "ijsd", "ojosj@ds", date, team);
		SponsorImpl spim = new SponsorImpl();
		spim.createSponsor(sponsor);
		if(fan.getVoted()==null)
		{
			return b;
		}
		else
			return fan.getVoted();
	}
    @GetMapping("/api/user/getAllUsers")
    public List<Person> findallPerson() 
    {
    	PersonImpl PIMPL = new PersonImpl();
    	return PIMPL.findAllPerson();
    }
    
    
}
