package domain.models.entity.state;

import domain.models.entity.Issue;
import domain.models.entity.Project;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/13/16.
 */
@Entity
@Table(name = "local_state")
public class LocalState extends AbstractState {

    private Set<Issue> issues = new HashSet<>(0);

    private Set<Project> projects = new HashSet<>(0);

    @Override
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "localStates")
    public Set<Project> getProjects() {
        return this.projects;
    }

    @Override
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @OneToMany(mappedBy = "localState",cascade = CascadeType.ALL)
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
