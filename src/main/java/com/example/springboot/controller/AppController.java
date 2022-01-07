package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.App;
import com.example.springboot.repository.AppsRepository;

@RestController
@RequestMapping("/api")
public class AppController {

	@Autowired
	AppsRepository aRepo;
	
	@GetMapping("/apps")
	public ResponseEntity<List<App>> readApps () {
		return new ResponseEntity<List<App>>(aRepo.findAll(), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/apps")
	public ResponseEntity<App> createApp (@RequestBody App app) {
		return new ResponseEntity<App>(aRepo.save(app), HttpStatus.CREATED);
	}
	
	@GetMapping("/apps/{id}")
	public ResponseEntity<App> readApp (@PathVariable Long id) {
		return new ResponseEntity<App>(aRepo.findById(id).get(), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/apps/{id}")
	public ResponseEntity<HttpStatus> deleteApp (@PathVariable Long id) {
		aRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/apps")
	public ResponseEntity<App> updateApp (@RequestBody App app) {
		return new ResponseEntity<App>(aRepo.save(app), HttpStatus.OK);
	}
	
}



