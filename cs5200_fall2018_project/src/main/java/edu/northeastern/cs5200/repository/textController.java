package edu.northeastern.cs5200.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.dao.AllstarImpl;
import edu.northeastern.cs5200.dao.BossImpl;
import edu.northeastern.cs5200.dao.DraftImpl;
import edu.northeastern.cs5200.dao.FanImpl;
import edu.northeastern.cs5200.dao.PersonImpl;
import edu.northeastern.cs5200.dao.PlayerImpl;
import edu.northeastern.cs5200.dao.ReportImpl;
import edu.northeastern.cs5200.dao.ScoutImpl;
import edu.northeastern.cs5200.dao.SponsorImpl;
import edu.northeastern.cs5200.dao.StadiumImpl;
import edu.northeastern.cs5200.dao.TeamImpl;
import edu.northeastern.cs5200.model.Allstar;
import edu.northeastern.cs5200.model.Boss;
import edu.northeastern.cs5200.model.Draft;
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Person;
import edu.northeastern.cs5200.model.Player;
import edu.northeastern.cs5200.model.Report;
import edu.northeastern.cs5200.model.Scout;
import edu.northeastern.cs5200.model.Sponsor;
import edu.northeastern.cs5200.model.Stadium;
import edu.northeastern.cs5200.model.Team;

@RestController
public class textController {
	@Autowired
    private textRepository tController;
 
	//Log in
	@GetMapping("/api/login/{username}/{password}")
    public Person getPersonByUP(@PathVariable("username") String username,
    		@PathVariable("password") String password) 
    {
		PersonImpl PIMPL = new PersonImpl();
    	return PIMPL.findPersonByUP(username,password);
	}
	
	//Admin
	@GetMapping("/api/admin/addperson/{fn}/{ln}/{un}/{pw}/{dtype}/{dob}/{email}")
    public void Createperson(@PathVariable("fn") String firstname,
    		@PathVariable("ln") String lastname,@PathVariable("un") String username,
    		@PathVariable("pw") String password,@PathVariable("dtype") String dtype,
    		@PathVariable("dob") String dob,@PathVariable("email") String email) 
    {
		Date dob1 = java.sql.Date.valueOf(dob);
		PersonImpl PIMPL = new PersonImpl();
		Person person = new Person(dtype, 0, firstname, lastname, 
				username, password, email, dob1);
		PIMPL.createPerson(person, dtype);
    	return;
	}
	@GetMapping("/api/admin/addperson/{id}/{fn}/{ln}/{un}/{pw}/{dtype}/{dob}/{email}")
    public void updatePersonById(@PathVariable("id") int id,
    		@PathVariable("fn") String firstname,
    		@PathVariable("ln") String lastname,@PathVariable("un") String username,
    		@PathVariable("pw") String password,@PathVariable("dtype") String dtype,
    		@PathVariable("dob") String dob,@PathVariable("email") String email) 
    {
		Date dob1 = java.sql.Date.valueOf(dob);
		PersonImpl PIMPL = new PersonImpl();
		Person person = new Person(dtype, id, firstname, lastname, 
				username, password, email, dob1);
		PIMPL.updatePersonById(id,person);
    	return;
	}
	@GetMapping("/api/admin/{FId}/delete")
    public void Deleteperson(@PathVariable("FId") int FId) 
    {
    	PersonImpl PIMPL = new PersonImpl();
    	PIMPL.deletePersonById(FId);
	}
	
	//fans
    @GetMapping("/api/fans/{FId}/allstarVote")
    public Collection<Allstar> findAllstarVotedbyFan(@PathVariable("FId") int FId) 
    {
    	AllstarImpl AIMPL = new AllstarImpl();
    	return AIMPL.findAllstarByFanId(FId);
	}
    @GetMapping("/api/fans/{FId}/{PId}")
    public void FanVote(@PathVariable("FId") int FId,@PathVariable("PId") int PId) 
    {
    	FanImpl FIMPL = new FanImpl();
    	PlayerImpl PIMPL = new PlayerImpl();
    	Allstar allstar = new Allstar(0,FIMPL.findFanById(FId),PIMPL.findPlayerById(PId));
    	AllstarImpl AIMPL = new AllstarImpl();
    	AIMPL.createAllstars(allstar);
	}
    @GetMapping("/api/fans/{FId}/{PId}/delete")
    public void FanFollowCancel(@PathVariable("FId") int FId,@PathVariable("PId") int PId) 
    {
    	FanImpl FIMPL = new FanImpl();
    	PlayerImpl PIMPL = new PlayerImpl();
    	Allstar allstar = new Allstar(0,FIMPL.findFanById(FId),PIMPL.findPlayerById(PId));
    	AllstarImpl AIMPL = new AllstarImpl();
    	AIMPL.deleteAllstarsByFanId(FId,PId);
	}
    @GetMapping("/api/fans/{FId}")
    public Fan findThisFan(@PathVariable("FId") int FId) 
    {
    	FanImpl FIMPL = new FanImpl();
    	return FIMPL.findFanById(FId);
	}
    @GetMapping("/api/fans/{name}/player")
    public Player findPlayer(@PathVariable("name") String Pname) 
    {
    	PlayerImpl PIMPL = new PlayerImpl();
    	return PIMPL.findPlayerByName(Pname);
	}
    @GetMapping("/api/fans/{teamid}/team")
    public Team findTeam(@PathVariable("teamid") int Tid) 
    {
    	TeamImpl TIMPL = new TeamImpl();
    	return TIMPL.findTeamById(Tid);
	}
    
    //players in all-star
    @GetMapping("/api/players/{FId}/allstarVote")
    public Collection<Allstar> findAllstarPlayerVoted(@PathVariable("FId") int FId) 
    {
    	AllstarImpl AIMPL = new AllstarImpl();
    	return AIMPL.findAllstarByPlayerId(FId);
	}
    
    //boss
    @GetMapping("/api/boss/{FId}")
    public Boss findThisBoss(@PathVariable("FId") int FId) 
    {
    	BossImpl BIMPL = new BossImpl();
    	return BIMPL.findBossById(FId);
	}
    @GetMapping("/api/Bosses/{FId}/Teams")
    public Team findTeamsByboss(@PathVariable("FId") int FId) 
    {
    	TeamImpl TIMPL = new TeamImpl();
    	return TIMPL.findTeamByBossId(FId);
	}
    @GetMapping("/api/Bosses/{FId}/Stadium")
    public Stadium findStadiumByboss(@PathVariable("FId") int FId) 
    {
    	StadiumImpl SIMPL = new StadiumImpl();
    	TeamImpl TIMPL = new TeamImpl();
    	return SIMPL.findStadiumByTeamId(TIMPL.findTeamByBossId(FId).getId());
	}
    @GetMapping("/api/Bosses/{FId}/Reports")
    public Collection<Report> findReportByboss(@PathVariable("FId") int FId) 
    {
    	ReportImpl RIMPL = new ReportImpl();
    	return RIMPL.findAllReportByBossId(FId);
	}
    @GetMapping("/api/Bosses/{FId}/Sponsor")
    public Sponsor findSponsorByboss(@PathVariable("FId") int FId) 
    {
    	SponsorImpl SIMPL = new SponsorImpl();
    	TeamImpl TIMPL = new TeamImpl();
    	return SIMPL.findSponsorByTeamId(TIMPL.findTeamByBossId(FId).getId());
	}
    
    //Scout
    @GetMapping("/api/Scout/{FId}")
    public Scout findThisScout(@PathVariable("FId") int FId) 
    {
    	ScoutImpl SIMPL = new ScoutImpl();
    	return SIMPL.findScoutById(FId);
	}
    @GetMapping("/api/Scout/Drafts/{FId}")
    public Collection<Draft> findDraftByYear(@PathVariable("FId") int FId) 
    {
    	DraftImpl DIMPL = new DraftImpl();
    	return DIMPL.findDraftsByYear(FId);
	}
    @GetMapping("/api/Scout/{FId}/Report")
    public Collection<Report> findReportByScout(@PathVariable("FId") int FId) 
    {
    	ReportImpl RIMPL = new ReportImpl();
    	return RIMPL.findAllReportByScoutId(FId);
	}
    @GetMapping("/api/Scout/{FId}/{BId}/{ReportBody}")
    public void writeReport(@PathVariable("FId") int Sid,@PathVariable("BId") int Bid,
    		@PathVariable("ReportBody") String Body) 
    {
    	ReportImpl RIMPL = new ReportImpl();
    	ScoutImpl SIMPL = new ScoutImpl();
    	BossImpl BIMPL = new BossImpl();
    	System.out.println(BIMPL.findBossById(Bid).getId());
    	if(BIMPL.findBossById(Bid)!=null)
    	{
    		Report report = new Report(0, BIMPL.findBossById(Bid), 
        			SIMPL.findScoutById(Sid), Body);
        	RIMPL.createReport(report);
        	return;
    	}
    	
	}
    
    //Sponsor
    @GetMapping("/api/sponsor/{FId}")
    public Sponsor FindThisSponsor(@PathVariable("FId") int FId) 
    {
    	SponsorImpl SIMPL = new SponsorImpl();
    	return SIMPL.findSponsorById(FId);
	}
    @GetMapping("/api/Sponsor/{FId}/Team")
    public Team findTeamBySponsor(@PathVariable("FId") int FId) 
    {
    	TeamImpl TIMPL = new TeamImpl();
    	return TIMPL.findTeamBySponsorId(FId);
	}
    @GetMapping("/api/Sponsor/{sponsorId}/{Teamid}/{amount}")
    public void SponsorATeam(@PathVariable("sponsorId") int SId,
    		@PathVariable("Teamid") int Tid, @PathVariable("amount") int amount) 
    {
    	TeamImpl TIMPL = new TeamImpl();
    	SponsorImpl SIMPL = new SponsorImpl();
    	System.out.println(SIMPL.findSponsorById(SId).getTeam().getId());
    	if(SIMPL.findSponsorById(SId).getTeam().getId()==100)
    	{
    	Sponsor sponsor = SIMPL.findSponsorById(SId);
    	sponsor.setTeam(TIMPL.findTeamById(Tid));
    	SIMPL.updateSponsorById(SId, sponsor);
    	Team team = TIMPL.findTeamById(Tid);
    	team.setSponsorAmount(amount);
    	TIMPL.updateTeamById(Tid, team);
    	return;
    	}
	}
    @GetMapping("/api/Sponsor/{Sid}/cancel")
    public void CancelSponsor(@PathVariable("Sid") int SId) 
    {
    	TeamImpl TIMPL = new TeamImpl();
    	SponsorImpl SIMPL = new SponsorImpl();
    	Team team = TIMPL.findTeamBySponsorId(SId);
    	team.setSponsorAmount(0);
    	TIMPL.updateTeamById(team.getId(), team);
    	Sponsor sponsor = SIMPL.findSponsorById(SId);
    	sponsor.setTeam(TIMPL.findTeamById(100));
    	SIMPL.updateSponsorById(SId, sponsor);
    	return;
	}
    
    
    //全选
    @GetMapping("/api/person/getAllPerson")
    public List<Person> findallPerson() 
    {
    	PersonImpl PIMPL = new PersonImpl();
    	return PIMPL.findAllPerson();
    }
    @GetMapping("/api/fans/getAllFans")
    public Collection<Fan> findallFans() 
    {
    	FanImpl FIMPL = new FanImpl();
    	return FIMPL.findAllFans();
    }
    @GetMapping("/api/players/getAllPlayers")
    public Collection<Player> findallPlayers() 
    {
    	
    	PlayerImpl PIMPL= new PlayerImpl();
    	return PIMPL.findAllPlayer();
    }
    @GetMapping("/api/bosses/getAllBosses")
    public Collection<Boss> findallBooses() 
    {
    	BossImpl BIMPL = new BossImpl();
    	return BIMPL.findAllBoss();
    }
    @GetMapping("/api/teams/getAllTeams")
    public Collection<Team> findallTeams() 
    {
    	TeamImpl TIMPL = new TeamImpl();
    	return TIMPL.findAllTeams();
    }
    @GetMapping("/api/stadiums/getAllStadiums")
    public Collection<Stadium> findallStadiums() 
    {
    	StadiumImpl SIMPL = new StadiumImpl();
    	return SIMPL.findAllStadium();
    }
    
    //import data
    @GetMapping("/api/player/create/{id}/{name}/{tid}")
    public void CreatePlayer(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("tid") int tid) 
    {
    	PlayerImpl PIMPL = new PlayerImpl();
    	TeamImpl TIMPL = new TeamImpl();
    	Player player = new Player(id,name,TIMPL.findTeamById(tid));
    	PIMPL.createPlayer(player);
    	return;
    }
    @GetMapping("/api/player/create/{id}/{name}")
    public void CreatePlayerNoId(@PathVariable("id") int id, @PathVariable("name") String name) 
    {
    	PlayerImpl PIMPL = new PlayerImpl();
    	Player player = new Player(id,name,null);
    	PIMPL.createPlayerNoTeamId(player);
    	return;
    }
    @GetMapping("/api/draft/create/{order}/{year}/{player}/{team}")
    public void CreateDraft(@PathVariable("order") int order,
    		@PathVariable("year") String year,@PathVariable("player") int Pid,@PathVariable("team") int Tid) 
    {
    	PlayerImpl PIMPL = new PlayerImpl();
    	DraftImpl DIMPL = new DraftImpl();
    	TeamImpl TIMPL = new TeamImpl();
    	
    	Draft draft = new Draft(0,PIMPL.findPlayerById(Pid),TIMPL.findTeamById(Tid), year,order);
    	DIMPL.createDraftNoid(draft);
    	return;
    }
    
    
    
    
    
}
