package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private int id;
	private String name;
	private String polishName;
	private String worldPremiere;
	private String polishPremiere;
	private String director;
	private String writer;
	private String producer;
	
	private List<Actor> actors;
	private List<Rate> rating;
	private List<Comment> comments;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPolishName(){
		return this.polishName;
	}
	
	public void setPolishName(String polishName){
		this.polishName = polishName;
	}
	
	public String getWorldPremiere(){
		return worldPremiere;
	}
	
	public void setWorldPremiere(String worldPremiere){
		this.worldPremiere = worldPremiere;
	}
	
	public String getPolishPremiere(){
		return this.polishPremiere;
	}
	
	public void setPolishPremiere(String polishPremiere){
		this.polishPremiere = polishPremiere;
	}
	
	//Dircetor
	public String getDirector(){
		return director;
	}
	
	public void setDirector(String director){
		this.director = director;
	}
	
	//Writer
	public String getWriter(){
		return writer;
	}
	
	public void setWriter(String writer){
		this.writer = writer;
	}
	
	//Producer
	public String getProducer(){
		return producer;
	}
	
	public void setProducer(String producer){
		this.producer = producer;
	}
	
	public List<Comment> getComments(){
		return comments;
	}
	
	public Comment getComment(int commentId){
		for(Comment c : this.comments){
			if(c.getId()==commentId){
				return c;
			}
		}
		return null;
	}
	
	public void setComments(List<Comment> comments){
		this.comments = comments;
	}
	
	public double getRating(){
		if(this.rating == null){
			return 0;
		}
		int sum = 0;
		for (Rate d : this.rating) sum += d.getValue();
		double average = 1.0d * sum / this.rating.size();
		return average;
	}

	public void insertNewRate(Rate rate){
		if(this.rating == null){
			this.rating = new ArrayList<Rate>();
		}
		this.rating.add(rate);
	}
	
	public List<Actor> getActors(){
		return actors;
	}
	
	public void setActors(List<Actor> actors){
		this.actors = actors;
	}
}
