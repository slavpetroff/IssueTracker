package domain.models.dto;

import domain.enums.Role;

import java.util.Set;

/**
 * Created by slavpetroff on 7/17/16.
 */
public class UserCreateForm {

    private String password;

    private String username;

    private Set<Long> authorities;

    private Role role = Role.ROLE_USER;

    public UserCreateForm() {
    }

    public UserCreateForm(String username, String password, Set<Long> authorities) {
        this.setUsername(username);
        this.setPassword(password);
        this.setAuthorities(authorities);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Long> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Long> authorities) {
        this.authorities = authorities;
    }
}
