package henryhui.site.study.dao;

import henryhui.site.study.model.OperationLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationDao extends JpaRepository<OperationLogModel, Long> {
}