package com.local.guide.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.guide.model.Trail;

@Repository
public interface TrailDao extends JpaRepository<Trail, Long>  {

}
