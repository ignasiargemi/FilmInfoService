package Repository;

import Domain.Film;
import java.sql.*;
import java.util.ArrayList;


public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;

	public FilmDAO() {}

	/**
	 * This function opens the connection to the MySQL DB
	 */
	private void openConnection(){
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }
		try{
		    conn = DriverManager.getConnection
	        ("jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/puigi?user=puigi&password=Blefrowy6");
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	
	/**
	 * This function closes the connection to the MySQL DB
	 */
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Assistant function to transform the retrieved data into Film Java Objects
	 */
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
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	/**
	 * Function to get All the films in an ArrayList
	 */
	public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	   	try{
		    String selectSQL = "select * from films_proj limit 50";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
	}
	
	/**
	 * This function returns an arraylist of the films searched with a certain filter
	 */
	public ArrayList<Film> getFilmByTitle(String name){
		ArrayList<Film> allFilms = new ArrayList<Film>();
		try{
			openConnection();
			String selectSQL = "select * from films_proj where title like \"%" + name + "%\"";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			while(rs1.next()){
				oneFilm = getNextFilm(rs1);
				allFilms.add(oneFilm);
			}

			stmt.close();
			closeConnection();
		} catch(SQLException se) { System.out.println(se); }

		return allFilms;
	}

	/**
	 * This function returns a Film object with a certain ID introduced by the USER
	 */
	public Film getFilmByID(int id){
		oneFilm=null;
		try{
			if (!IdExists(id)) {
				return null;
			}
            openConnection();
		    String selectSQL = "select * from films_proj where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
	}
	
	/**
	 * This assistant function checks if there's a film with the ID introduced by the user
	 */
    private boolean IdExists(int id) {
        openConnection();
        int num = 0;
        try{
            String selectSQL = "select count(*) from films_proj where id="+id;
            ResultSet rs1 = stmt.executeQuery(selectSQL);
            // Retrieve the results
            while(rs1.next()){
                num = rs1.getInt(1);
            }

            stmt.close();
            closeConnection();
        } catch(SQLException se) {
            System.out.println(se);
            return false;
        }
        if (num > 0) return true;
        else return false;
    }
    
    /**
	 * This function adds a film into the DB
	 */
    public void addFilm(Film film) {
	   try {
		   int max = getMaxId();
		   openConnection();
		   String insertSQL = "INSERT INTO films_proj VALUES (" + (max+1) + ",\""
				   + film.getTitle() + "\"," +film.getYear() + ",\"" +film.getDirector()
				   + "\"," +film.getDuration()+ ",\"" +film.getCredits()+ "\",\"" +film.getReview()+ "\")";
		   int rs1 = stmt.executeUpdate(insertSQL);
		   if (rs1 == 1) System.out.println("Given ID is "+(max+1));
		   stmt.close();
		   closeConnection();
	   } catch (SQLException se){System.out.println(se);}
    }
    
    /**
	 * This function deletes the film with the ID introduced by the user
	 */
	public void deleteFilmByID(int id) {
		openConnection();
		try {


			String deleteSQL = "DELETE FROM films_proj where id = " + id;
			int rs1 = stmt.executeUpdate(deleteSQL);
			if (rs1 == 1) System.out.println("Row deleted!");
			// Retrieve the results


			stmt.close();
			closeConnection();
		} catch (SQLException se){System.out.println(se);}
	}
	
	/**
	 * This assistant function returns the max ID in the DB
	 */
   	private int getMaxId() {
		openConnection();
		int max = 0;
		// Create select statement and execute it
		try{
			String selectSQL = "select max(id) from films_proj";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while(rs1.next()){
				max = rs1.getInt(1);
			}

			stmt.close();
			closeConnection();
			return max;
		} catch(SQLException se) { System.out.println(se); }

   		return 0;
	}
   	
   	/**
	 * This function UPDATES a film
	 */
	public void updateFilm(Film film) {
		 try {
		   openConnection();
		   String updateSQL = "UPDATE films_proj SET title = \"" + film.getTitle() + "\" where id = " + film.getId();
		   stmt.executeUpdate(updateSQL);
		   updateSQL = "UPDATE films_proj SET year = " + film.getYear() + " where id = " + film.getId();
		   stmt.executeUpdate(updateSQL);
		   updateSQL = "UPDATE films_proj SET director = \"" + film.getDirector() + "\" where id = " + film.getId();
		   stmt.executeUpdate(updateSQL);
		   updateSQL = "UPDATE films_proj SET duration = " + film.getDuration() + " where id = " + film.getId();
		   stmt.executeUpdate(updateSQL);
		   updateSQL = "UPDATE films_proj SET credits = \"" + film.getCredits() + "\" where id = " + film.getId();
		   stmt.executeUpdate(updateSQL);
		   updateSQL = "UPDATE films_proj SET review = \"" + film.getReview() + "\" where id = " + film.getId();
		   stmt.executeUpdate(updateSQL);
		   
		   stmt.close();
		   closeConnection();
		   System.out.println("Film UPDATED!");
	   } catch (SQLException se){System.out.println(se);}		
	}
   
}
