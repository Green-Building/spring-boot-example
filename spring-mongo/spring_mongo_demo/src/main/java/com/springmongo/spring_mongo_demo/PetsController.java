package com.springmongo.spring_mongo_demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.List;

import com.springmongo.spring_mongo_demo.models.Pets;
import com.springmongo.spring_mongo_demo.models.PetsRepository;

@RestController

public class PetsController {
	@Autowired
	private PetsRepository repository;
	
	@RequestMapping("/pets")
	public Iterable<Pets> getAllPets() {
		final String uri = "http://gturnquist-quoters.cfapps.io/api/random";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
		return repository.findAll();
	}
	
}