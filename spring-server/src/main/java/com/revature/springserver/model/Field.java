package com.revature.springserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Field {
    private String name;
    private Integer width;
    private String dataType;

    public Field() {
    }

    public Field(String name, Integer width, String dataType) {
        this.name = name;
        this.width = width;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Gets the value of width and returns width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the width
     * You can use getWidth() to get the value of width
     *
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", dataType=" + dataType +
                '}';
    }
}
