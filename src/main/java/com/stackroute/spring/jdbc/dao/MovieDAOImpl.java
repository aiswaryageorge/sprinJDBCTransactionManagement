package com.stackroute.spring.jdbc.dao;

import javax.sql.DataSource;

import com.stackroute.spring.jdbc.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

public class MovieDAOImpl implements MovieDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Movie movie) {
		String queryMovie = "insert into movies values(?,?,?,?)";
		String queryActor = "insert into Actor values(?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryMovie, new Object[] { movie.getMovieId(),
				movie.getMovieName(), movie.getReleaseYear(), movie.getRatings()});
		System.out.println("Inserted into movie Table Successfully");
		jdbcTemplate.update(queryActor, new Object[] { movie.getMovieId(),
				movie.getActor().getActorAge() });
		System.out.println("Inserted into Actor Table Successfully");
	}

}
