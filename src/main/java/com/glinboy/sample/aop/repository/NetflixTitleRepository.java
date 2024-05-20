package com.glinboy.sample.aop.repository;

import com.glinboy.sample.aop.entity.NetflixTitle;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NetflixTitleRepository extends JpaRepository<NetflixTitle, Long> {
	
	Optional<NetflixTitle> findOneByShowId(String showId);
}
