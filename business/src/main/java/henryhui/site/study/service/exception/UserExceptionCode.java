package henryhui.site.study.service.exception;

public enum  UserExceptionCode {
    DUPLICATE_USERNAME("DUPLICATE_USERNAME"),
    PASSWORD_INCORRECT("PASSWORD_INCORRECT"),
    ENCODE_PASSWORD_ERROR("ENCODE_PASSWORD_ERROR");

    String code;

    UserExceptionCode(String code) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
