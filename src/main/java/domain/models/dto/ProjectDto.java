package domain.models.dto;

import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/8/16.
 */
public class ProjectDto {

    private Long id;

    private Long projectManager;

    private String name;

    private Set<Long> types = new HashSet<>(0);

    private Set<Long> allowedStates = new HashSet<>(0);

    private Set<Long> localStates = new HashSet<>(0);

    private Set<Long> applicationStates = new HashSet<>(0);

    private Set<Long> issues = new HashSet<>(0);

    private Set<Long> users = new HashSet<>(0);

    public ProjectDto(
            String name,
            Set<Long> types,
            Set<Long> allowedStates,
            Long projectManager) {
        this.setName(name);
        this.setTypes(types);
        this.setAllowedStates(allowedStates);
        this.setProjectManager(projectManager);
    }

    public ProjectDto(
            String name,
            Long projectManager) {
        this.setName(name);
        this.setProjectManager(projectManager);
    }

    public ProjectDto() {
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

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getTypes() {
        return this.types;
    }

    public void setTypes(Set<Long> types) {
        this.types = types;
    }

    @Transient
    public Set<Long> getAllowedStates() {
        if (this.allowedStates.size() != 0) {
            Set<Long> mergedStates = this.allowedStates;
            mergedStates.addAll(this.getLocalStates());
            mergedStates.addAll(this.getApplicationStates());
            return mergedStates;
        }

        Set<Long> mergedStates = new HashSet<>();
        mergedStates.addAll(this.getApplicationStates());
        mergedStates.addAll(this.getLocalStates());

        return mergedStates;
    }

    public void setAllowedStates(Set<Long> allowedStates) {
        this.allowedStates = allowedStates;
    }

    public Set<Long> getLocalStates() {
        return localStates;
    }

    public void setLocalStates(Set<Long> localStates) {
        this.localStates = localStates;
    }

    public Set<Long> getApplicationStates() {
        return applicationStates;
    }

    public void setApplicationStates(Set<Long> applicationStates) {
        this.applicationStates = applicationStates;
    }

    public Long getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Long projectManager) {
        this.projectManager = projectManager;
    }

    public Set<Long> getIssues() {
        return issues;
    }

    public void setIssues(Set<Long> issues) {
        this.issues = issues;
    }

    public Set<Long> getUsers() {
        return users;
    }

    public void setUsers(Set<Long> users) {
        this.users = users;
    }
}
