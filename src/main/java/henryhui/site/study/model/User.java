package henryhui.site.study.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import henryhui.site.study.data.converter.UserRoleListConverter;
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
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_group_link",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_group_id"))
    Set<UserGroup> linkedUserGroup;



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
