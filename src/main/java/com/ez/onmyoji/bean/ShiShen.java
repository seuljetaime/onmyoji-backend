package com.ez.onmyoji.bean;

import org.springframework.data.annotation.Id;

/**
 * 式神
 */
public class ShiShen {
  @Id
  private Integer shishenId;
  private String shishenName;
  private String shishenLevel;
  private String imgSrc;

  public Integer getShishenId() {
    return shishenId;
  }

  public void setShishenId(Integer shishenId) {
    this.shishenId = shishenId;
  }

  public String getShishenName() {
    return shishenName;
  }

  public void setShishenName(String shishenName) {
    this.shishenName = shishenName;
  }

  public String getShishenLevel() {
    return shishenLevel;
  }

  public void setShishenLevel(String shishenLevel) {
    this.shishenLevel = shishenLevel;
  }

  public String getImgSrc() {
    return imgSrc;
  }

  public void setImgSrc(String imgSrc) {
    this.imgSrc = imgSrc;
  }

}
