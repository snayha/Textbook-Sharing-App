package ria.Jun2015.textbooksharing;

public class SingleBookInfo {
	
	String myName;
	String myEmail;
	String myBookTitle;
	String myBookType;
	public SingleBookInfo(String name, String email, String bookTitle, String bookType)
	{
		myName = name;
		myEmail= email;
		myBookTitle = bookTitle;
		myBookType = bookType;
	}
	public String getName()
	{
		return myName;
	}
	public String getEmail()
	{
		return myEmail;
	}
	public String getBookTitle()
	{
		return myBookTitle;
	}
	public String getBookType()
	{
		return myBookType;
	}
	public void setMyName(String name) {
		myName = name;
	}
	public void setMyEmail(String email) {
		myEmail = email;
	}
	public void setMyBookTitle(String bookTitle) {
		myBookTitle = bookTitle;
	}
	public void setMyBookType(String bookType) {
		myBookType = bookType;
	}
}