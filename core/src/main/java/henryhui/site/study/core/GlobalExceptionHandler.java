package henryhui.site.study.core;


import com.sun.deploy.net.HttpResponse;
import henryhui.site.study.core.exception.BaseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponse Result(MethodArgumentNotValidException e){
        List<String> validErrorStringList = new ArrayList();
        for (ObjectError err : e.getBindingResult().getAllErrors()){
            validErrorStringList.add(err.getDefaultMessage());
        }
        return new ApiResponse.Builder().error(ErrorCode.INPUT_ERROR.getName() , StringUtils.join(validErrorStringList , " and "));
    }

    @ExceptionHandler({BaseException.class})
    public ApiResponse ResultBaseException(BaseException e , HttpServletResponse httpServletResponse){
        httpServletResponse.setStatus(e.stateCode);
        return new ApiResponse.Builder().error(e.errCode , e.errMsg);
    }

    @ExceptionHandler({Exception.class})
    public ApiResponse ResultException(Exception e){
        return new ApiResponse.Builder().error(ErrorCode.UNKNOWN_ERROR.getName() ,e.getMessage());
    }
}
