package henryhui.site.study.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ApiResponse<T>{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String errCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String errorMessage;

    Long timeStamp;

    public ApiResponse (T data){
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    public ApiResponse (String errCode , String errorMessage){
        this.errCode = errCode;
        this.errorMessage = errorMessage;
        this.timeStamp = System.currentTimeMillis();
    }

    public ApiResponse (String errCode , String errorMessage , T data){
        this.errCode = errCode;
        this.errorMessage = errorMessage;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    public static class Builder{
        public static  <T> ApiResponse success(T data){
            return new ApiResponse(data);
        }

        public static  <T> ApiResponse error(String errCode , String errorMessage) {
            return new ApiResponse(errCode , errorMessage);
        }

        public static  <T> ApiResponse error(String errCode , String errorMessage , T Data) {
            return new ApiResponse(errCode , errorMessage);
        }
    }
}
