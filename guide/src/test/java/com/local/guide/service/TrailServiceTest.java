package com.local.guide.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.local.guide.model.Trail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrailServiceTest {
	
	@Autowired
	TrailService trailService;
	
	@Test
	public void getAllTrails() {
		List<Trail> trails = trailService.getAlltrails();
		Assert.assertTrue(trails.size()>0);
	}
	
	
}
