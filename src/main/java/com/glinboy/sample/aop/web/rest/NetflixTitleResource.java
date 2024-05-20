package com.glinboy.sample.aop.web.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glinboy.sample.aop.service.NetflixTitleService;
import com.glinboy.sample.aop.service.dto.NetflixTitleDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/titles")
@RequiredArgsConstructor
public class NetflixTitleResource {

	private final NetflixTitleService service;

	@GetMapping
	public ResponseEntity<Page<NetflixTitleDTO>> getNetflixTitles(Pageable pageable) {
		return ResponseEntity.ok(service.getNetflixTitles(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<NetflixTitleDTO> getNetflixTitleById(@PathVariable Long id) {
		return service.getNetflixTitleById(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/show/{showId}")
	public ResponseEntity<NetflixTitleDTO> getNetflixTitleByShowId(@PathVariable String showId) {
		return service.getNetflixTitleByShowId(showId).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
