package com.glinboy.sample.aop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "netflix_title")
public class NetflixTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "show_id", length = 5)
	private String showId;

	@Column(name = "show_type", length = 7)
	private String type;

	@Column(name = "title", length = 104)
	private String title;

	@Column(name = "director", length = 208)
	private String director;

	@Column(name = "show_cast", length = 771)
	private String cast;

	@Column(name = "country", length = 123)
	private String country;

	@Column(name = "date_added", length = 19)
	private String dateAdded;

	@Column(name = "release_year", length = 4)
	private String releaseYear;

	@Column(name = "rating", length = 8)
	private String rating;

	@Column(name = "duration", length = 10)
	private String duration;

	@Column(name = "listed_in", length = 79)
	private String listedIn;

	@Column(name = "description", length = 248)
	private String description;
}
