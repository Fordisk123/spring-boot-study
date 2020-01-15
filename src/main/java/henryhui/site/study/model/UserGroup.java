package henryhui.site.study.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import henryhui.site.study.data.converter.UserRoleListConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user_group")
public class UserGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "linkedUserGroup")
    private Set<User> linkedUser;

    @Column(name = "roles")
    @Convert(converter = UserRoleListConverter.class)
    private List<UserRole> roles;


}
