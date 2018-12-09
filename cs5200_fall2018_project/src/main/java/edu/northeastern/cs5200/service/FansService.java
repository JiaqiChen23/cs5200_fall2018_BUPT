package edu.northeastern.cs5200.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.northeastern.cs5200.dao.FanDao;
import edu.northeastern.cs5200.dao.FanImpl;
import edu.northeastern.cs5200.model.Allstar;
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Player;

public class FansService {
		@GetMapping("/test/fans/{FId}")
		public List<Allstar> findFansFollowedPlayers(@PathVariable("FId") int FId) 
		{
			FanImpl fanI = new FanImpl();
			
			Fan fan = fanI.findFanById(FId);
			return fan.getVoted();
		}

}
