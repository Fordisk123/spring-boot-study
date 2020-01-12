package henryhui.site.study.model;


import henryhui.site.study.converter.UserRoleListConverter;
import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "user")
//public class User implements UserDetails {
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "linkedUser")
    private Set<UserGroup> userGroups;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        for (UserRole role : roles) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return loginName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
