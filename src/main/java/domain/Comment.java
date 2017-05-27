package domain;

public class Comment {

	private int id;
	private String nick;
	private String content;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getNick(){
		return nick;
	}
	
	public void setNick(String nick){
		this.nick = nick;
	}
}
