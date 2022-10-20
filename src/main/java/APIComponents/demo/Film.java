package APIComponents.demo;

import javax.persistence.*;

@Entity
@Table(name = "film")


public class Film {
    //Attributes
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmId;

    @Column(name = "title")
    String filmTitle;

    //Constructor
    public Film(String hereFilmTitle){
        this.filmTitle = hereFilmTitle;
    }

    public Film(){}

    //Methods


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }
}
