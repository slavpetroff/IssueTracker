package domain.models.dto.state;

import domain.models.entity.Project;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by slavpetroff on 8/13/16.
 */
public class ApplicationStateDto extends AbstractStateDto {

    private Set<Project> projects = new HashSet<>(0);

    @Override
    public Set<Project> getProjects() {
        return this.projects;
    }

    @Override
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
