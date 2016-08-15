package domain.models.dto.state;

import domain.interfaces.State;
import domain.models.entity.Issue;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/13/16.
 */
public abstract class AbstractStateDto implements State {

    private String name;

    private long id;

    private Set<Issue> issues = new HashSet<>(0);

    public AbstractStateDto() {
    }

//    public AbstractState(Project... projects) {
//        // TODO: extract to method/class. Duplication in Type.class
//        this.projects.addAll(Arrays.asList(projects));
//        this.issues.addAll(Arrays.stream(projects)
//                .flatMap(p -> p.getIssues()
//                        .stream())
//                .collect(Collectors.toSet()));
//    }

    public AbstractStateDto(String name) {
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

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
