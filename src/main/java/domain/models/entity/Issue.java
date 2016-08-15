package domain.models.entity;

import domain.interfaces.State;
import domain.models.entity.state.ApplicationState;
import domain.models.entity.state.LocalState;

import javax.persistence.*;

/**
 * Created by slavpetroff on 8/8/16.
 */
@Entity
@Table(name = "issue")
public class Issue {

    private Long id;

    private String name;

    private User user;

    private Project project;

    private String description;

    private ApplicationState applicationState;

    private LocalState localState;

    private State currentState;

    private Type type;

    // TODO: constructor with arguments

    public Issue() {
    }

    @javax.persistence.Id
    @Column(name = "issue_id")
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

    public void setName(String firstName) {
        this.name = firstName;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public LocalState getLocalState() {
        return localState;
    }

    public void setLocalState(LocalState localState) {
        this.localState = localState;
    }

    @Transient
    public State getCurrentState() {
        if (this.applicationState != null) {
            return this.applicationState;
        }

        return this.localState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
