package application;

import java.util.ArrayList;

import Domain.Film;
import Repository.FilmDAO;

public class main {
	public static void main(String[] args) {
		System.out.println("START");
		System.out.println();

		FilmDAO filmDAO = new FilmDAO();

		/**
		 *Use of listFilm()
		*/
		ArrayList<Film> filmsCollection = filmDAO.getAllFilms();
/*		for (Film f: filmsCollection) {
			System.out.println(f.toString());
		}*/
		System.out.println();
		System.out.println();
		/**
		 *Use of searchFilm()
		*/
		Film f = filmDAO.getFilmByID(0);
		System.out.println(f.toString());
        System.out.println();

		/**
		 *Adding a new Film()
		 */
		f = new Film("Hehe", 100, "Clean is good", 120, "Credits", "Good");
		filmDAO.addFilm(f);
        System.out.println();
		f = null;
		f = filmDAO.getFilmByID(1310);
		System.out.println(f.toString());
		System.out.println();
		filmDAO.deleteFilmByID(1310);

		System.out.println("FINAL");
	}
}
