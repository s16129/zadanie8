package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.services.CommentService;
import domain.services.RateService;
import domain.Rate;
import domain.services.MovieService;
import domain.Actor;
import domain.Comment;
import domain.Movie;

import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MovieResources {
	private MovieService db = ApplicationConfig.movieService;
	private CommentService cdb = ApplicationConfig.commentService;
	private RateService rdb = ApplicationConfig.rateService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll(){
		return db.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Movie movie){
		db.add(movie);
		return Response.ok(movie.getId()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Movie result = db.get(id);
		if(result==null){
			return Response.status(404).build();
		}
		
		return Response.ok(result).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Movie m){
		Movie result = db.get(id);
		if(result==null)
			return Response.status(404).build();
		m.setId(id);
		db.update(m);
		return Response.ok().build();
	}
	
	@POST
	@Path("/{id}/rating")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertRating(@PathParam("id") int id, Rate r){
		Movie result = db.get(id);
		if(result==null)
			return Response.status(404).build();
		rdb.add(r);
		result.insertNewRate(r);
		db.update(result);
		return Response.ok().build();
	}
	
	@POST
	@Path("/{id}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("id") int movieId, Comment comment){
		Movie result = db.get(movieId);
		if(result==null){
			return Response.status(404).build();
		}
		if(result.getComments()==null){
			result.setComments(new ArrayList<Comment>());
		}
		cdb.add(comment);
		result.getComments().add(comment);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{movieId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getCars(@PathParam("movieId") int movieId){
		Movie result = db.get(movieId);
		if(result==null){
			return null;
		}
		if(result.getComments()==null){
			result.setComments(new ArrayList<Comment>());
		}
		return result.getComments();
	}
	
	@DELETE
	@Path("/{movieId}/comments/{commentId}")
	public Response delete(@PathParam("movieId") int movieId, @PathParam("commentId") int commentId){
		Movie result = db.get(movieId);
		if(result==null){
			return Response.status(404).build();
		}
		
		Comment comment = result.getComment(commentId);
		if(comment==null){
			return Response.status(404).build();
		}
		
		result.getComments().remove(comment);
		cdb.delete(comment);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}/actors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getActors(@PathParam("id") int movieId){
		Movie result = db.get(movieId);
		if(result==null){
			return null;
		}
		if(result.getActors()==null){
			result.setActors(new ArrayList<Actor>());
		}
		return result.getActors();
	}
	
	/*
	
	@POST
	@Path("/{id}/cars")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(@PathParam("id") int personId, Car car){
		Person result = db.get(personId);
		if(result==null){
			return Response.status(404).build();
		}
		if(result.getCars()==null){
			result.setCars(new ArrayList<Car>());
		}
		result.getCars().add(car);
		return Response.ok().build();
	}*/

}