package com.oaec.cms.entity;

import java.sql.Timestamp;

public class Area {

  private Integer areaId;
  private String name;
  private Integer status;
  private Timestamp createTime;

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
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

  @Override
  public String toString() {
    return "Area{" +
            "areaId=" + areaId +
            ", name='" + name + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            '}';
  }
}
