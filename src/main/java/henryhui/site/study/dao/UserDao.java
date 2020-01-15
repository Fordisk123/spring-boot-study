package henryhui.site.study.dao;

import henryhui.site.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
