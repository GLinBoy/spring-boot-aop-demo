package com.glinboy.sample.aop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "netflix_title")
public record NetflixTitle(

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id,

	@Column(name = "show_id", length = 5)
	String showId,

	@Column(name = "show_type", length = 7)
	String type,

	@Column(name = "title", length = 104)
	String title,

	@Column(name = "director", length = 208)
	String director,

	@Column(name = "show_cast", length = 771)
	String cast,

	@Column(name = "country", length = 123)
	String country,

	@Column(name = "date_added", length = 19)
	String dateAdded,

	@Column(name = "release_year", length = 4)
	String releaseYear,

	@Column(name = "rating", length = 8)
	String rating,

	@Column(name = "duration", length = 10)
	String duration,

	@Column(name = "listed_in", length = 79)
	String listedIn,

	@Column(name = "description", length = 248)
	String description
) {
}
