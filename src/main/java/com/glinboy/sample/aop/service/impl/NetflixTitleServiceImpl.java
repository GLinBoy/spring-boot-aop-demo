package com.glinboy.sample.aop.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.glinboy.sample.aop.repository.NetflixTitleRepository;
import com.glinboy.sample.aop.service.NetflixTitleService;
import com.glinboy.sample.aop.service.dto.NetflixTitleDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NetflixTitleServiceImpl implements NetflixTitleService {
	
	private final NetflixTitleRepository repository;
	private final ModelMapper mapper;

	@Override
	public Page<NetflixTitleDTO> getNetflixTitles(Pageable pageable) {
		return repository.findAll(pageable)
				.map(e -> mapper.map(e, NetflixTitleDTO.class));
	}

	@Override
	public Optional<NetflixTitleDTO> getNetflixTitleById(Long id) {
		return repository.findById(id)
				.map(e -> mapper.map(e, NetflixTitleDTO.class));
	}

	@Override
	public Optional<NetflixTitleDTO> getNetflixTitleByShowId(String showId) {
		return repository.findOneByShowId(showId)
				.map(e -> mapper.map(e, NetflixTitleDTO.class));
	}

}
