package com.local.guide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.guide.model.Trail;
import com.local.guide.service.TrailService;

@RestController
public class TrailsController {
	
	@Autowired
	private TrailService trailService;
	
	@GetMapping(path = "/avalableTrails")
	List<Trail> getAlltrails(){
		List<Trail> trails=trailService.getAlltrails();
		return trails;
	}
}
