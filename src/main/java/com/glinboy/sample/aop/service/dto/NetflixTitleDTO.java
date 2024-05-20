package com.glinboy.sample.aop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetflixTitleDTO {
	private Long id;
	private String showId;
	private String type;
	private String title;
	private String director;
	private String cast;
	private String country;
	private String dateAdded;
	private String releaseYear;
	private String rating;
	private String duration;
	private String listedIn;
	private String description;
}
