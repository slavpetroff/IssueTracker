package domain.models.entity;

import domain.interfaces.State;
import domain.models.entity.state.ApplicationState;
import domain.models.entity.state.LocalState;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/8/16.
 */
@Entity
@Table(name = "project")
public class Project {

    private Long id;

    private User projectManager;

    private String name;

    private Type type;

    private Board board;

    private Set<State> allowedStates = new HashSet<>(0);

    private Set<LocalState> localStates = new HashSet<>(0);

    private Set<ApplicationState> applicationStates = new HashSet<>(0);

    private Set<Issue> issues = new HashSet<>(0);

    private Set<User> users = new HashSet<>(0);

    public Project(
            String name,
            Type type,
            Set<State> allowedStates,
            User projectManager) {
        this.setName(name);
        this.setType(type);
        this.setAllowedStates(allowedStates);
        this.setProjectManager(projectManager);
    }

    public Project(
            String name,
            User projectManager) {
        this.setName(name);
        this.setProjectManager(projectManager);
    }

    public Project() {
    }

    @javax.persistence.Id
    @Column(name = "project_id")
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

    @ManyToOne(cascade = CascadeType.ALL)
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Transient
    public Set<State> getAllowedStates() {
        if (this.allowedStates.size() != 0) {
            Set<State> mergedStates = this.allowedStates;
            mergedStates.addAll(this.getLocalStates());
            mergedStates.addAll(this.getApplicationStates());
            return mergedStates;
        }

        Set<State> mergedStates = new HashSet<>();
        mergedStates.addAll(this.getApplicationStates());
        mergedStates.addAll(this.getLocalStates());

        return mergedStates;
    }

    public void setAllowedStates(Set<State> allowedStates) {
        this.allowedStates = allowedStates;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_state_id")
    public Set<LocalState> getLocalStates() {
        return localStates;
    }

    public void setLocalStates(Set<LocalState> localStates) {
        this.localStates = localStates;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_state_id")
    public Set<ApplicationState> getApplicationStates() {
        return applicationStates;
    }

    public void setApplicationStates(Set<ApplicationState> applicationStates) {
        this.applicationStates = applicationStates;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
