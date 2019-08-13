package com.oaec.cms.entity;


import java.sql.Timestamp;

public class Role {

  private Integer roleId;
  private String name;
  private String description;
  private Integer status;
  private Integer departmentId;
  private Timestamp createTime;
  private String depName;

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public String getDepName() {
    return depName;
  }

  public void setDepName(String depName) {
    this.depName = depName;
  }

  @Override
  public String toString() {
    return "Role{" +
            "roleId=" + roleId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", status=" + status +
            ", departmentId=" + departmentId +
            ", createTime=" + createTime +
            ", depName='" + depName + '\'' +
            '}';
  }
}
