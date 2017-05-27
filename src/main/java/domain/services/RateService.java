package domain.services;

import java.util.List;
import java.util.ArrayList;

import domain.Rate;

public class RateService {
	
	private static List<Rate> db = new ArrayList<Rate>();
	private static int currentId = 0;
	
	public Rate get(int id){
		for(Rate r : db){
			if(r.getId()==id){
				return r;
			}
		}
		return null;
	}
	
	public void add(Rate r){
		r.setId(++currentId);
		db.add(r);
	}
	
	public void delete(Rate r){
		db.remove(r);
	}
}