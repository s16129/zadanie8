package domain.services;

import java.util.List;
import java.util.ArrayList;

import domain.Actor;
import domain.Movie;

public class MovieService {
	
	private static List<Movie> db = new ArrayList<Movie>();
	private static int currentId = 0;
	
	public List<Movie> getAll(){
		return db;
	}
	
	public Movie get(int id){
		for(Movie p : db){
			if(p.getId()==id){
				return p;
			}
		}
		return null;
	}
	
	public List<Movie> getByActor(Actor a){
		if(a == null){
			return null;
		}
		return a.getMovies();
	}
	
	public void add(Movie m){
		m.setId(++currentId);
		db.add(m);
	}
	
	public void update(Movie movie){
		for(Movie m : db){
			if(m.getId()==movie.getId()){
				m.setName(movie.getName());
				m.setPolishName(movie.getPolishName());
				m.setWorldPremiere(movie.getWorldPremiere());
				m.setPolishPremiere(movie.getPolishPremiere());
				m.setDirector(movie.getDirector());
				m.setWriter(movie.getWriter());
				m.setProducer(movie.getProducer());
			}
		}
	}
	
	public void delete(Movie m){
		db.remove(m);
	}
}
