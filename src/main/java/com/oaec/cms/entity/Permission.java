package com.oaec.cms.entity;


import java.sql.Timestamp;
import java.util.List;

public class Permission {

  private Integer permissionId;
  private Integer parentId;
  private String permission;
  private String url;
  private String type;
  private Integer status;
  private Timestamp createTime;
  private List<Permission> permissionList;
  private Integer roleId;

  public Integer getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Integer permissionId) {
    this.permissionId = permissionId;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public List<Permission> getPermissionList() {
    return permissionList;
  }

  public void setPermissionList(List<Permission> permissionList) {
    this.permissionList = permissionList;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "Permission{" +
            "permissionId=" + permissionId +
            ", parentId=" + parentId +
            ", permission='" + permission + '\'' +
            ", url='" + url + '\'' +
            ", type='" + type + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            ", permissionList=" + permissionList +
            ", roleId=" + roleId +
            '}';
  }
}
