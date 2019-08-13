package com.oaec.cms.entity;

import java.sql.Timestamp;

public class Garbage {

  private Integer garbageId;
  private String name;
  private Integer status;
  private Timestamp createTime;
  private Integer garbageTypeId;
  private String garbageTypeName;

  public Integer getGarbageId() {
    return garbageId;
  }

  public void setGarbageId(Integer garbageId) {
    this.garbageId = garbageId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public Integer getGarbageTypeId() {
    return garbageTypeId;
  }

  public void setGarbageTypeId(Integer garbageTypeId) {
    this.garbageTypeId = garbageTypeId;
  }

  public String getGarbageTypeName() {
    return garbageTypeName;
  }

  public void setGarbageTypeName(String garbageTypeName) {
    this.garbageTypeName = garbageTypeName;
  }

  @Override
  public String toString() {
    return "Garbage{" +
            "garbageId=" + garbageId +
            ", name='" + name + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            ", garbageTypeId=" + garbageTypeId +
            ", garbageTypeName='" + garbageTypeName + '\'' +
            '}';
  }
}
