package domain.models.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by slavpetroff on 8/8/16.
 */
@Entity
@Table(name = "type")
public class Type {

    private String name;

    private long id;

    private Set<Project> projects = new HashSet<>(0);

    private Set<Issue> issues = new HashSet<>(0);

    public Type(Project... projects) {
        // TODO: extract to method/class. Duplication in State.class
        this.projects.addAll(Arrays.asList(projects));
        this.issues.addAll(Arrays.stream(projects)
                .flatMap(p -> p.getIssues()
                        .stream())
                .collect(Collectors.toSet()));
    }

    public Type() {
    }

    public Type(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> project) {
        this.projects = project;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
