package main;

import java.util.Collection;

import Domain.Film;
import Domain.FilmInfoCollection;

public class main {
	public static void main(String[] args) {
		System.out.println("START");
		System.out.println();
		FilmInfoCollection collection = new FilmInfoCollection();
		Film f1 = new Film(0,"Hehehe",1993,"Director: Pepi",180,4.0);
		Film f2 = new Film(1,"Llibre",1993,"Director: Pepi",180,5.0);
		Film f3 = new Film(2,"Llibreta",1993,"Director: Pepi",180,4.0);
		Film f4 = new Film(3,"Hehehe",1993,"Director: Pepi",180,4.0);
		Film f5 = new Film(4,"Estoig",1993,"Director: Pepi",180,4.0);
		Film f6 = new Film(5,"PC",1993,"Director: Pepi",180,4.0);
		Film f7 = new Film(6,"Rellotge",1993,"Director: Pepi",180,4.0);
		Film f8 = new Film(7,"Hehehe",1993,"Director: Pepi",180,4.0);
		Film f9 = new Film(8,"Rellotge",1993,"Director: Pepi",180,4.0);
		Film f10 = new Film(9,"Hehehe",1993,"Director: Pepi",180,4.0);
		
		/** 
		 *Use of addFilm(Film f)
		*/
		collection.addFilm(f1);
		collection.addFilm(f2);
		collection.addFilm(f3);
		collection.addFilm(f4);
		collection.addFilm(f5);
		collection.addFilm(f6);
		collection.addFilm(f7);
		collection.addFilm(f8);
		collection.addFilm(f9);
		collection.addFilm(f10);
		
		/** 
		 *Use of listFilm()
		*/
		Collection<Film> filmsCollection = collection.listFilm();
		for (Film f: filmsCollection) {
			System.out.println(f.toString());
		}
		System.out.println();
		System.out.println();
		/** 
		 *Use of searchFilm()
		*/
		filmsCollection = collection.searchFilm("Hehehe");
		for (Film f: filmsCollection) {
			System.out.println(f.toString());
		}		
		System.out.println();
		System.out.println("FINAL");
	}
}
