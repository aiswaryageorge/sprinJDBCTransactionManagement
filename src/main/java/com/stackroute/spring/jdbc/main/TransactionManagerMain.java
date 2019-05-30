package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import com.stackroute.spring.jdbc.service.MovieManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		MovieManager movieManager = ctx.getBean("movieManager", MovieManagerImpl.class);

		Movie movie = createDummyMovie();
		movieManager.createMovie(movie);

		ctx.close();
	}

	private static Movie createDummyMovie() {
		Movie movie = new Movie();
		movie.setMovieId(9);
		movie.setMovieName("lucifer");
		Actor actor = new Actor();
		actor.setActorId(1);
		actor.setActorAge(49);
		// setting value more than 20 chars, so that SQLException occurs
		movie.setActor(actor);
		movie.setReleaseYear(2019);
		movie.setRatings(5.5f);
		return movie;
	}

}
