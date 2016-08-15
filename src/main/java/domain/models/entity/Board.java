package domain.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/15/16.
 */
@Entity
@Table(name = "board")
public class Board {

    private Long id;

    private String name;

    private Set<Project> projects = new HashSet<>(0);

    public Board() {
    }

    @javax.persistence.Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
