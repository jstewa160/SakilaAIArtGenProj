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
    @Column(name = "description")
    String filmDesc;
    @Column(name = "rating")
    String filmRating;
    //Constructor
    public Film(String hereFilmTitle, String hereFilmDesc, String hereFilmRating){
        this.filmTitle = hereFilmTitle;
        this.filmDesc = hereFilmDesc;
        this.filmRating = hereFilmRating;
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

    public String getFilmDesc() {
        return filmDesc;
    }

    public void setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
    }

    public String getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }
}
