package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import domain.services.ActorMovieService;
import domain.services.ActorService;
import domain.services.CommentService;
import domain.services.MovieService;
import domain.services.RateService;

@ApplicationPath("rest")
public class ApplicationConfig extends Application{
	static MovieService movieService = new MovieService();
	static CommentService commentService = new CommentService();
	static RateService rateService = new RateService();
	static ActorService actorService = new ActorService();
	static ActorMovieService actorMovieService = new ActorMovieService();
}
