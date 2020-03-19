package com.local.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.local.guide.dao.TrailDao;
import com.local.guide.model.Trail;

@Service
public class TrailService {
	
	@Autowired
	private TrailDao traildao;
	
	@Cacheable("student")
	public List<Trail> getAlltrails(){
		List<Trail> trails=traildao.findAll();
		return trails;
	}

}
