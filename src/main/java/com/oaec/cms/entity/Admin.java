package com.oaec.cms.entity;


import java.sql.Timestamp;

public class Admin {

  private Integer adminId;
  private String name;
  private String password;
  private Integer status;
  private String realName;
  private String telNumber;
  private String email;
  private String photo;
  private Timestamp createTime;
  private String roleName;
  private Integer roleId;
  private String depName;

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getTelNumber() {
    return telNumber;
  }

  public void setTelNumber(String telNumber) {
    this.telNumber = telNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getDepName() {
    return depName;
  }

  public void setDepName(String depName) {
    this.depName = depName;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "adminId=" + adminId +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", status=" + status +
            ", realName='" + realName + '\'' +
            ", telNumber='" + telNumber + '\'' +
            ", email='" + email + '\'' +
            ", photo='" + photo + '\'' +
            ", createTime=" + createTime +
            ", roleName='" + roleName + '\'' +
            ", roleId=" + roleId +
            ", depName='" + depName + '\'' +
            '}';
  }
}
