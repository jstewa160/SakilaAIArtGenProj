package APIComponents.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnore
    Set<Category> filmCategory;


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
    public Film(String filmTitle, String filmDesc, String filmRating){
        this.filmTitle = filmTitle;
        this.filmDesc = filmDesc;
        this.filmRating = filmRating;
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

    public Set<Category> getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(Set<Category> filmCategory) {
        this.filmCategory = filmCategory;
    }

}
