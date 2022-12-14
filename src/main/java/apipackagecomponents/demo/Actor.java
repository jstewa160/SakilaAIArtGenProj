package apipackagecomponents.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")



public class Actor {
    //Attributes
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;

//    @ManyToMany(mappedBy = "filmActor")
//    @JsonBackReference
//    Set<Film> actorFilm;
    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    Set<Film> actorFilm;

    @Column(name = "first_name")
    String actorFirstName;

    @Column(name = "last_name")
    String actorLastName;


    //Constructor
    public Actor(String hereFirstName, String hereLastName){
        this.actorFirstName = hereFirstName;
        this.actorLastName = hereLastName;
    }

    public Actor(){

    }

    //Methods
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorFirstName() {
        return actorFirstName;
    }

    public void setActorFirstName(String actorFirstName) {
        this.actorFirstName = actorFirstName;
    }

    public String getActorLastName() {
        return actorLastName;
    }

    public void setActorLastName(String actorLastName) {
        this.actorLastName = actorLastName;
    }
}
