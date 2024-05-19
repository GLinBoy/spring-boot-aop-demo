package com.glinboy.sample.aop.service.dto;

public record NetflixTitleDTO(
		Long id,
		String showId,
		String type,
		String title,
		String director,
		String cast,
		String country,
		String dateAdded,
		String releaseYear,
		String rating,
		String duration,
		String listedIn,
		String description) {

}
