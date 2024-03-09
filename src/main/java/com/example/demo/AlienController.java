package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienController {

	@Autowired
	private AlienRepository alienRepository;
	
	List<Alien> aliens=new ArrayList<>();
	
	@RequestMapping("aliens")
	public List<Alien> getAliens(){
		Alien a=new Alien();
		a.setId(101);
		a.setName("Kamal");
		a.setPoints(25);
		
		Alien a1=new Alien();
		a1.setId(102);
		a1.setName("Pooja");
		a1.setPoints(35);
		aliens.add(a);
		aliens.add(a1);
		return aliens;
	}
	
	@GetMapping("jpa/aliens")
	public List<Alien> getAlien(){
		System.out.println("JPA/Aliens");
		List<Alien> aliens=(List<Alien>) alienRepository.findAll();
		return aliens;
	}
}
