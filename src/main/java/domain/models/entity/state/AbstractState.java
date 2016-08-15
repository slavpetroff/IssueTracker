package domain.models.entity.state;

import domain.interfaces.State;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

/**
 * Created by slavpetroff on 8/13/16.
 */
@MappedSuperclass
public abstract class AbstractState implements State {

    private String name;

    private long id;

    public AbstractState() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
