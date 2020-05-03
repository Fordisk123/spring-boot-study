package henryhui.site.study.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "user")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @NotBlank(message = "Login name can't be empty")
    @Column(name = "login_name", unique = true, nullable = false)
    private String loginName;

    @NotBlank(message = "Password can't be empty")
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
    },fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_group_link",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_group_id"))
    @JsonIgnoreProperties("linkedUsers")
    Set<UserGroup> linkedUserGroups;

}
