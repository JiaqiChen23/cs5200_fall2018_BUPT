package edu.northeastern.cs5200.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.dao.FanImpl;
import edu.northeastern.cs5200.model.Allstar;
import edu.northeastern.cs5200.model.Fan;

@RestController
public class textController {
	@Autowired
    private textRepository tController;
 

    @GetMapping("/test/fans/{FId}")
    public List<Allstar> findFansFollowedPlayers(@PathVariable("FId") int FId) 
	{
		FanImpl fanI = new FanImpl();
		Allstar a = new Allstar();
		List<Allstar> b = null;
		b.add(a);
		Fan fan = fanI.findFanById(FId);
		if(fan.getVoted()==null)
		{
			System.out.println("123131313123123123123");
			return b;
		}
		else
			return fan.getVoted();
	}
    
}
