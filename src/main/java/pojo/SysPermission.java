package pojo;

public class SysPermission {
    private Integer permissionId;

    private String permissionName;

    private String permissionUrl;

    private Integer permissionParentId;

    private String permissionDetail;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public Integer getPermissionParentId() {
        return permissionParentId;
    }

    public void setPermissionParentId(Integer permissionParentId) {
        this.permissionParentId = permissionParentId;
    }

    public String getPermissionDetail() {
        return permissionDetail;
    }

    public void setPermissionDetail(String permissionDetail) {
        this.permissionDetail = permissionDetail == null ? null : permissionDetail.trim();
    }
}