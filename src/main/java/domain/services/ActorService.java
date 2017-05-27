package domain.services;

import java.util.List;
import java.util.ArrayList;

import domain.Actor;

public class ActorService {
	
	private static List<Actor> db = new ArrayList<Actor>();
	private static int currentId = 0;
	
	public List<Actor> getAll(){
		return db;
	}
	
	public Actor get(int id){
		for(Actor p : db){
			if(p.getId()==id){
				return p;
			}
		}
		return null;
	}
	
	public void add(Actor a){
		a.setId(++currentId);
		db.add(a);
	}
	
	public void update(Actor actor){
		for(Actor a : db){
			if(a.getId()==actor.getId()){
				a.setName(actor.getName());
				a.setSurname(actor.getSurname());
			}
		}
	}
	
	public void delete(Actor a){
		db.remove(a);
	}
}
