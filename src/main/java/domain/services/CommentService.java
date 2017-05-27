package domain.services;

import java.util.List;
import java.util.ArrayList;

import domain.Comment;

public class CommentService {
	
	private static List<Comment> db = new ArrayList<Comment>();
	private static int currentId = 0;
	
	public Comment get(int id){
		for(Comment p : db){
			if(p.getId()==id){
				return p;
			}
		}
		return null;
	}
	
	public void add(Comment c){
		c.setId(++currentId);
		db.add(c);
	}
	
	public void delete(Comment c){
		db.remove(c);
	}
}
