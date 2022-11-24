package org.TeamDream.NaumenShop.DB.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class User implements UserDetails {
    public Long Id;
    public String Name;
    public String Password;
    private Set<Role> roles;

    public User(){};

    public User(Long id, String name, String password) {
        Id = id;
        Name = name;
        Password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUsername(String username) {
        Name = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return Name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
