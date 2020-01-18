package henryhui.site.study.model;


public class ApiRestResponse {
    private int code;
    private String message;
    private Object data;

    public ApiRestResponse(){

    }

    public static ApiRestResponse succuess(){
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setResultCode(ApiResultCode.SUCCESS);

        return restResponse;
    }

    public static ApiRestResponse succuess(Object data){
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setResultCode(ApiResultCode.SUCCESS);
        restResponse.setData(data);

        return restResponse;
    }

    public static ApiRestResponse fail() {
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setResultCode(ApiResultCode.FAIL);

        return restResponse;
    }


    public static ApiRestResponse fail(ApiResultCode apiResultCode) {
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setResultCode(apiResultCode);

        return restResponse;
    }

    public static ApiRestResponse fail(String message) {
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setCode(ApiResultCode.FAIL.code());
        restResponse.setMessage(message);

        return restResponse;
    }

    public static ApiRestResponse fail(Integer code, String message) {
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setCode(code);
        restResponse.setMessage(message);

        return restResponse;
    }

    public static ApiRestResponse fail(ApiResultCode apiResultCode, Object data) {
        ApiRestResponse restResponse = new ApiRestResponse();
        restResponse.setResultCode(apiResultCode);
        restResponse.setData(data);

        return restResponse;
    }

    private void setResultCode(ApiResultCode apiResultCode){
        this.code = apiResultCode.code();
        this.message = apiResultCode.message();
    }

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}