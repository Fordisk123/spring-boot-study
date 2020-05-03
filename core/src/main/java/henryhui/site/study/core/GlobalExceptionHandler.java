package henryhui.site.study.core;


import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ExceptionHandler({Exception.class})
    public ApiResponse ResultException(Exception e){
        return new ApiResponse.Builder().error(ErrorCode.UNKNOWN_ERROR.getName() ,e.getMessage());
    }
}
