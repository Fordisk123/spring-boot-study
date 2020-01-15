package henryhui.site.study.dao;

import henryhui.site.study.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserGroupDao extends JpaRepository<UserGroup , Long> {

    @Query(value = "SELECT ug FROM UserGroup ug WHERE ug.id IN(:ids)")
    List<UserGroup> findIn(@Param("ids") List<Long> ids);

}
