package Domain;

import java.util.ArrayList;
import java.util.Collection;

public class FilmInfoCollection implements FilmInfo {

	private Collection<Film> collection;
	
	public FilmInfoCollection() {
		this.collection = new ArrayList<Film>();
	}
	@Override
	public void addFilm(Film film) {
		this.collection.add(film);
	}

	@Override
	public Collection<Film> listFilm() {
		return this.collection;
	}

	@Override
	public Collection<Film> searchFilm(String searchFilm) {
		ArrayList<Film> output = new ArrayList<Film>();
		for (Film f: collection) {
			if (f.getName().equalsIgnoreCase(searchFilm)) output.add(f);
		}
		return output;
	}

}
