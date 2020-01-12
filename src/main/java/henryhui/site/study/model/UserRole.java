package henryhui.site.study.model;

/**
 * @author Administrator
 */

public enum  UserRole {
    /**
     * Administrator 管理员
     * Normal 普通用户
     */
    Administrator("Admin"),Normal("Normal");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
