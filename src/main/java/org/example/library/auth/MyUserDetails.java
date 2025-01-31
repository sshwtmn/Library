package org.example.library.auth;

import lombok.AllArgsConstructor;
import org.example.library.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] rolesStrArray = role.split(",");
        for (String roleStr : rolesStrArray) {
            authorities.add(new SimpleGrantedAuthority(roleStr));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
