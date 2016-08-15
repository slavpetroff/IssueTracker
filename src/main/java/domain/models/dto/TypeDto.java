package domain.models.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/8/16.
 */
public class TypeDto {

    private String name;

    private long id;

    private Set<Long> projects = new HashSet<>(0);

    private Set<Long> issues = new HashSet<>(0);

//    public TypeDto(Long... projects) {
//        // TODO: extract to method/class. Duplication in State.class
//        this.projects.addAll(Arrays.asList(projects));
//        this.issues.addAll(Arrays.stream(projects)
//                .flatMap(p -> p.getIssues()
//                        .stream())
//                .collect(Collectors.toSet()));
//    }

    public TypeDto() {
    }

    public TypeDto(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Long> getProjects() {
        return projects;
    }

    public void setProjects(Set<Long> project) {
        this.projects = project;
    }

    public Set<Long> getIssues() {
        return issues;
    }

    public void setIssues(Set<Long> issues) {
        this.issues = issues;
    }
}
