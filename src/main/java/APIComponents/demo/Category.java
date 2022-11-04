package APIComponents.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @ManyToMany(mappedBy = "filmCategory")
    @JsonBackReference
    Set<Film> categoryFilm;

    //Attributes
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;
    @Column(name = "name")
    String categoryName;



    public Category(int categoryId, String categoryName){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(){

    }

//    public Set<Film> getCategoryFilm() {
//        return categoryFilm;
//    }
//
//    public void setCategoryFilm(Set<Film> categoryFilm) {
//        this.categoryFilm = categoryFilm;
//    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int catId) {
        this.categoryId = catId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String catName) {
        this.categoryName = catName;
    }
}
