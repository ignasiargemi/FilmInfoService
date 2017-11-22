package Repository;

import Domain.Film;

import java.sql.*;
import java.util.ArrayList;


public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;

	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
		    conn = DriverManager.getConnection
	        ("jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/puigi?user=puigi&password=Blefrowy6");
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getInt("duration"),
					rs.getString("credits"),
					rs.getString("review")
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films_proj";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public Film getFilmByID(int id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films_proj where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }

   public void addFilm(Film film) {
	   openConnection();
	   try {


		   String selectSQL = "INSERT INTO films_proj VALUES (" + film.getID() + ",\""
				   + film.getTitle() + "\"," +film.getYear() + ",\"" +film.getDirector()
				   + "\"," +film.getDuration()+ ",\"" +film.getCredits()+ "\",\"" +film.getReview()+ "\")";
		   //System.out.println(selectSQL);
		   int rs1 = stmt.executeUpdate(selectSQL);
		   // Retrieve the results


		   stmt.close();
		   closeConnection();
	   } catch (SQLException se){System.out.println(se);}
   }
   
   
   
   
}