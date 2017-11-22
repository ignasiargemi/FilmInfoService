package Domain;

public class Film {
	
	private int ID;
	private String title;
	private int year;
	private String director;
	private int duration; //In Minutes
	private String credits;
	private String review;
	
	public Film(int iD, String title, int year, String director, int duration, String credits, String review) {
		ID = iD;
		this.title = title;
		this.year = year;
		this.credits = credits;
		this.duration = duration;
		this.review = review;
		this.director = director;
	}
	
	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	
	public String getTitle() {return title;}
	public void setTitle(String name) {this.title = name;}
	
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	
	public String getCredits() {return credits;}
	public void setCredits(String credits) {this.credits = credits;}
	
	public int getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration;}
	
	public String getReview() {return review;}
	public void setReview(String review) {this.review = review;}

	public String getDirector() { return director; }
	public void setDirector(String director) {this.director = director;}

	@Override
	public String toString() {
		return "Film{" +
				"ID=" + ID +
				", title='" + title + '\'' +
				", year=" + year +
				", director='" + director + '\'' +
				", duration=" + duration +
				", credits='" + credits + '\'' +
				", review='" + review + '\'' +
				'}';
	}
}
