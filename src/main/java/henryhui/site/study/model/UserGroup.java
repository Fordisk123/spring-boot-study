package henryhui.site.study.model;


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
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "user_group_link",
            joinColumns = @JoinColumn(name = "user_group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> linkedUser;

    @Column(name = "roles")
    @Convert(converter = UserRoleListConverter.class)
    private List<UserRole> roles;

}
