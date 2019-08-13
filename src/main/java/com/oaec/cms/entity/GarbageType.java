package com.oaec.cms.entity;

import java.sql.Timestamp;

public class GarbageType {

  private Integer garbageTypeId;
  private String name;
  private String description;
  private Integer status;
  private Timestamp createTime;

  public Integer getGarbageTypeId() {
    return garbageTypeId;
  }

  public void setGarbageTypeId(Integer garbageTypeId) {
    this.garbageTypeId = garbageTypeId;
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
    return "GarbageType{" +
            "garbageTypeId=" + garbageTypeId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            '}';
  }
}
