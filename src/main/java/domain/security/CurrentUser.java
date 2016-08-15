package domain.security;


import domain.models.entity.Authority;
import domain.models.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CurrentUser extends domain.models.entity.User implements UserDetails {

    private User user;

    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>(0);

    public CurrentUser(User user) {
        this.user = user;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(
                user.getRoles().
                        stream().
                        map(Authority::getName).
                        toArray(String[]::new));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.getPassword() != null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user.getId() != null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user.getPassword() != null;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getId() != null;
    }
}