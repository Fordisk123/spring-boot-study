package henryhui.site.study.service.operation;

import henryhui.site.study.dao.OperationDao;
import henryhui.site.study.model.OperationLogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceDbImpl implements IOperationService {

    @Autowired
    OperationDao operationDao;

    @Override
    public OperationLogModel insertLog(OperationLogModel log) {
          return operationDao.save(log);
    }
}
