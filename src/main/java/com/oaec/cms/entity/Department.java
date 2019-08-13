package com.oaec.cms.entity;


import java.sql.Timestamp;

public class Department {

  private Integer departmentId;
  private String name;
  private String description;
  private Integer status;
  private Timestamp createTime;

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
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

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Department{" +
            "departmentId=" + departmentId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            '}';
  }
}
