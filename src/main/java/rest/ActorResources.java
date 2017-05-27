package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.services.ActorService;
import domain.services.MovieService;
import domain.Actor;
import domain.Movie;

import java.util.ArrayList;
import java.util.List;

@Path("/actors")
public class ActorResources {
	private MovieService mdb = ApplicationConfig.movieService;
	private ActorService adb = ApplicationConfig.actorService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getAll(){
		return adb.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Actor actor){
		adb.add(actor);
		return Response.ok(actor.getId()).build();
	}
	
	@PUT
	@Path("/{actorId}/movies/{movieId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addToMovie(@PathParam("actorId") int actorId, @PathParam("movieId") int movieId){
		Actor actor = adb.get(actorId);
		if(actor == null){
			return Response.status(404).build();
		}
		
		Movie movie = mdb.get(movieId);
		if(movie == null){
			return Response.status(404).build(); 
		}
		
		if(actor.getMovies() == null){
			actor.setMovies(new ArrayList<Movie>());
		}
		
		if(movie.getActors() == null){
			movie.setActors(new ArrayList<Actor>());
		}
		
		for(Movie m : actor.getMovies()){
			if(m.getId() == movie.getId())
				return Response.status(409).build();
		}
		 
		
		movie.getActors().add(actor);
		actor.getMovies().add(movie);
		
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Actor result = adb.get(id);
		if(result==null){
			return Response.status(404).build();
		}
		
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/{id}/movies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies(@PathParam("id") int actorId){
		Actor result = adb.get(actorId);
		if(result==null){
			return null;
		}
		if(result.getMovies()==null){
			result.setMovies(new ArrayList<Movie>());
		}
		return result.getMovies();
	}

}