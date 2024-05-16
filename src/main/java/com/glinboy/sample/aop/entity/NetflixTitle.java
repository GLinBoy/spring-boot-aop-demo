package com.glinboy.sample.aop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "netflix_title")
public record NetflixTitle(

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id,

	@Column(name = "show_id")
	String showId,

	@Column(name = "show_type")
	String type,

	String title,

	String director,

	@Column(name = "show_cast")
	String cast,

	String country,

	@Column(name = "date_added")
	String dateAdded,

	@Column(name = "release_year")
	String releaseYear,

	String rating,

	String duration,

	@Column(name = "listed_in")
	String listedIn,

	String description
) {
}
