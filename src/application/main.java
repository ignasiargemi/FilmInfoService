package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Domain.Film;
import Repository.FilmDAO;

public class main {
	public static void main(String[] args) {
		System.out.println("START");
		System.out.println();
		FilmDAO filmDAO = new FilmDAO();
        System.out.println("MENU");
        System.out.println("OPTION 0: GET ALL FILMS (LIMITED TO 50)");
        System.out.println("OPTION 1: GET FILMS BY TITLE");
        System.out.println("OPTION 2: ADD FILM");
        System.out.println("OPTION 3: DELETE FILM BY ID");
        System.out.println("ANY OTHER NUMBER WILL INTERRUPT THE EXECUTION");
        System.out.print("ENTER AN OPTION: ");
        Scanner reader = new Scanner(System.in);
        int option = reader.nextInt();
		while (option >= 0 && option <= 3) {
		    if (option == 0) {
                System.out.println("PRINT ALL FILMS");
                ArrayList<Film> filmsCollection = filmDAO.getAllFilms();
                for (Film f: filmsCollection) System.out.println(f.toString());
            }
            else if (option == 1) {
                System.out.println("PRINT FILM BY TITLE");
                System.out.println("Enter a word: ");
                String name = reader.next();
                ArrayList<Film> filmsCollection = filmDAO.getFilmByTitle(name);
                if (filmsCollection != null) for (Film f: filmsCollection) System.out.println(f.toString());
                else System.out.println("This/These film(s) does NOT exist");
            }
            else if (option == 2) {
                System.out.println("ADD FILM");
                System.out.println("Add the parameters:");
                System.out.print("title: "); String title = reader.next();
                System.out.print("year: "); int year = reader.nextInt();
                System.out.print("director: "); String director = reader.next();
                System.out.print("duration: "); int duration = reader.nextInt();
                System.out.print("credits: "); String credits = reader.next();
                System.out.print("review: "); String review = reader.next();
                Film f = new Film(title,year,director,duration,credits,review);
                filmDAO.addFilm(f);
            }
            else if (option == 3){
                System.out.println("DELETE FILM BY");
                System.out.println("Enter the id of the film you want to delete");
                int id = reader.nextInt();
                filmDAO.deleteFilmByID(id);
            }
            System.out.println("REENTER AN OPTION:");
            option = reader.nextInt();
        }
        reader.close();

		System.out.println();
		System.out.println("FINAL");
	}
}
