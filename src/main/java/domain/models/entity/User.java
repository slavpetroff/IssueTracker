package domain.models.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by slavpetroff on 7/17/16.
 */
@Entity
@Table(name = "user")
public class User {

    private Long id;

    private java.util.Set<Authority> roles = new HashSet<>(0);

    private String username;

    private String password;

    private Set<Issue> issues = new HashSet<>(0);

    private Set<Project> projects = new HashSet<>(0);

    private Set<Project> managedProjects = new HashSet<>(0);

    public User(String username, String password, List<GrantedAuthority>... authorities) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User() {
    }

    @javax.persistence.Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String firstName) {
        this.username = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    public java.util.Set<Authority> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Authority> authorities) {
        this.roles = authorities;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @OneToMany(mappedBy = "projectManager", cascade = CascadeType.ALL)
    public Set<Project> getManagedProjects() {
        return managedProjects;
    }

    public void setManagedProjects(Set<Project> managedProjects) {
        this.managedProjects = managedProjects;
    }
}
