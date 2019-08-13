package com.oaec.cms.entity;


import java.sql.Timestamp;

public class Resident {

  private Integer residentId;
  private String name;
  private String telNumber;
  private String address;
  private Integer status;
  private Timestamp createTime;
  private Integer areaId;
  private String areaName;

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public Integer getResidentId() {
    return residentId;
  }

  public void setResidentId(Integer residentId) {
    this.residentId = residentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelNumber() {
    return telNumber;
  }

  public void setTelNumber(String telNumber) {
    this.telNumber = telNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  @Override
  public String toString() {
    return "Resident{" +
            "residentId=" + residentId +
            ", name='" + name + '\'' +
            ", telNumber='" + telNumber + '\'' +
            ", address='" + address + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            ", areaId=" + areaId +
            ", areaName='" + areaName + '\'' +
            '}';
  }
}
