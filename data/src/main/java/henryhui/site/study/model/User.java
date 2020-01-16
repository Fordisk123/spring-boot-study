package henryhui.site.study.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.henryhui.site.study.core.GrantedAuthority;
//import org.springframework.security.henryhui.site.study.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.henryhui.site.study.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

//public class User implements UserDetails {

@Getter
@Setter
@Entity
@Table(name = "user")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "login_name", unique = true, nullable = false)
    private String loginName;

    @NotBlank
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
    })
    @JoinTable(
            name = "user_group_link",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_group_id"))
    @JsonIgnoreProperties("linkedUsers")
    Set<UserGroup> linkedUserGroups;



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
