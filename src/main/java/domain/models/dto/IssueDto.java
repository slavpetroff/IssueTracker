package domain.models.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/8/16.
 */
public class IssueDto {

    private Long id;

    private String name;

    private Set<Long> users = new HashSet<>(0);

    private Set<Long> projects = new HashSet<>(0);

    private String description;

    private Long applicationState;

    private Long localState;

    private Set<Long> types = new HashSet<>(0);

    // TODO: constructor with arguments

    public IssueDto() {
    }

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

    public Set<Long> getUsers() {
        return users;
    }

    public void setUsers(Set<Long> users) {
        this.users = users;
    }

    public Set<Long> getProjects() {
        return projects;
    }

    public void setProjects(Set<Long> project) {
        this.projects = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getTypes() {
        return types;
    }

    public void setTypes(Set<Long> types) {
        this.types = types;
    }

    public Long getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(Long applicationState) {
        this.applicationState = applicationState;
    }

    public Long getLocalState() {
        return localState;
    }

    public void setLocalState(Long localState) {
        this.localState = localState;
    }
}
