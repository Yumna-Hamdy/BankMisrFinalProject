package com.example.finalProject.Entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name ="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;
    @Column(name="username")
    private String userName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="mobile")
    private String mobile;
    @Column(name="enabled")
    private Boolean enabled = false;

    public User(String userName, String email, String password, String mobile, Boolean enabled) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
