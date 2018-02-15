package dev.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Collegue;
import dev.repository.CollegueRepository;

@RestController
@RequestMapping("/collegues")
public class collegueController {
	@Autowired
	CollegueRepository collegueRepo;
	
	@GetMapping
	public List<Collegue> listerCollegues(){
		return collegueRepo.findAll();
		
	}

	@PostMapping
	public void creerCollegue(@RequestBody Collegue collegue) {
		//insertion du bulletin qui a été saisit par l'utilisateur
		if (collegueRepo.findByPseudo(collegue.getPseudo())==null)
		{
			collegueRepo.save(collegue);
		}
		else
		{
			System.out.println("erreur doublon");
		}

	}
	
	@PatchMapping("/{pseudo}")
	public void MajCollegue(@RequestBody Map<String, String> action, @PathVariable String pseudo) {
		Collegue col = collegueRepo.findByPseudo(pseudo);
		if (action.get("action").equals("aimer"))
		{

			col.setScore(col.getScore()+10);
			collegueRepo.save(col);
		}
		else if (action.get("action").equals("detester"))
		{
			col.setScore(col.getScore()-5);
			collegueRepo.save(col);
		}
		else
		{
			System.out.println("tu sais pas écrire mon pote");
		}
		
	}
}
