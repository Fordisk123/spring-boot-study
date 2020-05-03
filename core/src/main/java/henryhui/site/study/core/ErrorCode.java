package henryhui.site.study.core;

public enum ErrorCode {
    UNKNOWN_ERROR("UNKNOWN_ERROR"),
    INPUT_ERROR("INPUT_ERROR");

    String code;

    ErrorCode(String code) {
        this.code = code;

    }

    public String getName() {
        return code;
    }

}
