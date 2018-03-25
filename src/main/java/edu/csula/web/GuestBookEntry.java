package main.java.edu.csula.web;

public class GuestbookEntry{

private final String username;
private final String comment;

public GuestbookEntry(int id ,String username,String comment)
{
    this.id= id;
    this.username= username;
    this.comment = comment;


}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getComment() {
		return comment;
	}
}