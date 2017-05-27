package domain.services;

import java.util.List;
import java.util.ArrayList;

import domain.Actor;
import domain.ActorMovie;
import domain.Movie;

public class ActorMovieService {
	
	private static List<ActorMovie> db = new ArrayList<ActorMovie>();
	
	public void insertPair(Actor actor, Movie movie){
		ActorMovie am = new ActorMovie();
		am.setActor(actor);
		am.setMovie(movie);
		db.add(am);
	}
	
	public List<Actor> getActorsForMovie(Movie movie){
		if(movie == null){
			return null;
		}
		
		List<Actor> filteredActors = new ArrayList<Actor>();
		for(ActorMovie am : db){
			if(am.getMovie().getId() == movie.getId()){
				filteredActors.add(am.getActor());
			}
		}
		return filteredActors;
	}
	
	public List<Movie> getMoviesForActors(Actor actor){
		if(actor == null){
			return null;
		}
		
		List<Movie> filteredMovies = new ArrayList<Movie>();
		for(ActorMovie am : db){
			if(am.getActor().getId() == actor.getId()){
				filteredMovies.add(am.getMovie());
			}
		}
		return filteredMovies;
	}
	
	public void delete(ActorMovie am){
		db.remove(am);
	}
}