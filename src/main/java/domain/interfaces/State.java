package domain.interfaces;

import domain.models.entity.Issue;
import domain.models.entity.Project;

import java.util.Set;

/**
 * Created by slavpetroff on 8/13/16.
 */
public interface State {

    String getName();

    void setName(String name);

    long getId();

    void setId(long id);

    Set<Project> getProjects();

    void setProjects(Set<Project> project);

    Set<Issue> getIssues();

    void setIssues(Set<Issue> issues);
}
