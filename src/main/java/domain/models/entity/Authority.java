package domain.models.entity;

import domain.enums.Role;

import javax.persistence.*;
import java.util.HashSet;

/**
 * Created by slavpetroff on 7/17/16.
 */

/**
 * Created by PetyoPetrov on 22.06.2016 г..
 */
@Entity
@Table(name = "authority")
public class Authority {

    private String name;

    private long id;

    private java.util.Set<User> users = new HashSet<>(0);

    public Authority() {

    }

    public Authority(Role role) {
        this.setName(String.valueOf(role));
    }

    @Id
    @Column(name = "authority_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    public java.util.Set<User> getUsers() {
        return users;
    }

    public void setUsers(java.util.Set<User> users) {
        this.users = users;
    }
}
