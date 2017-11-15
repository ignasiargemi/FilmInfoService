package Domain;

public class Film {
	
	private int ID;
	private String title;
	private int year;
	private String credits;
	private int duration; //In Minutes
	private double review;
	
	public Film(int iD, String title, int year, String credits, int duration, double review) {
		ID = iD;
		this.title = title;
		this.year = year;
		this.credits = credits;
		this.duration = duration;
		this.review = review;
	}
	
	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	
	public String getName() {return title;}
	public void setName(String name) {this.title = name;}
	
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	
	public String getCredits() {return credits;}
	public void setCredits(String credits) {this.credits = credits;}
	
	public int getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration;}
	
	public double getReview() {return review;}
	public void setReview(double review) {this.review = review;}

	@Override
	public String toString() {
		return "Film [ID=" + ID + ", title=" + title + ", year=" + year + ", credits=" + credits + ", duration="
				+ duration + ", review=" + review + "]";
	}
}
