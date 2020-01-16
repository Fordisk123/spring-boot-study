package henryhui.site.study.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henryhui.site.study.data.converter.UserRoleListConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user_group")
public class UserGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "linkedUserGroups")
    @JsonIgnoreProperties("linkedUserGroups")
    private Set<User> linkedUsers;

    @Column(name = "roles")
    @Convert(converter = UserRoleListConverter.class)
    private List<UserRole> roles;


}
