package com.glinboy.sample.aop.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.glinboy.sample.aop.service.dto.NetflixTitleDTO;

public interface NetflixTitleService {

	Page<NetflixTitleDTO> getNetflixTitles(Pageable pageable);

	Optional<NetflixTitleDTO> getNetflixTitleById(Long id);

	Optional<NetflixTitleDTO> getNetflixTitleByShowId(String showId);

}
