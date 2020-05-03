package henryhui.site.study.core.exception;

import lombok.Data;

@Data
public class BaseException extends Exception  {
    public int stateCode;
    public String errCode;
    public String errMsg;

    public BaseException(int stateCode , String errCode , String errMsg){
        this.stateCode = stateCode;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    public String getMessage(){
        return String.format("Code : %s , err : %s" , errCode , errMsg);
    }
}
