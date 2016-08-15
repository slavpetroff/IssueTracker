package domain.models.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by slavpetroff on 7/19/16.
 */
public class UserDto {

    private Long id;

    private java.util.Set<Long> roles = new HashSet<>(0);

    private Long role = 1l;

    private String username;

    private String password;

    private Set<Long> issues = new HashSet<>(0);

    private Set<Long> projects = new HashSet<>(0);

    private Set<Long> managedProjects = new HashSet<>(0);

    public UserDto(String username, String password, List<GrantedAuthority>... authorities) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public UserDto() {
    }

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

    public java.util.Set<Long> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Long> authorities) {
        this.roles = authorities;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Set<Long> getIssues() {
        return issues;
    }

    public void setIssues(Set<Long> issues) {
        this.issues = issues;
    }

    public Set<Long> getProjects() {
        return projects;
    }

    public void setProjects(Set<Long> projects) {
        this.projects = projects;
    }

    public Set<Long> getManagedProjects() {
        return managedProjects;
    }

    public void setManagedProjects(Set<Long> managedProjects) {
        this.managedProjects = managedProjects;
    }
}
