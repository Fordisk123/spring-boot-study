package henryhui.site.study.service.exception;

import henryhui.site.study.core.exception.BaseException;

public class UserException extends BaseException {

    public UserException(int stateCode , String errCode , String errMsg) {
        super(stateCode , errCode ,errMsg);
    }
}
