package com.oaec.cms.entity;

import java.sql.Timestamp;

public class Suggest {

  private Integer suggestId;
  private String suggest;
  private Integer status;
  private Timestamp createTime;

  public Integer getSuggestId() {
    return suggestId;
  }

  public void setSuggestId(Integer suggestId) {
    this.suggestId = suggestId;
  }

  public String getSuggest() {
    return suggest;
  }

  public void setSuggest(String suggest) {
    this.suggest = suggest;
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
    return "Suggest{" +
            "suggestId=" + suggestId +
            ", suggest='" + suggest + '\'' +
            ", status=" + status +
            ", createTime=" + createTime +
            '}';
  }
}
