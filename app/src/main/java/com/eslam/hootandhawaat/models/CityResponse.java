package com.eslam.hootandhawaat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CityResponse implements Serializable {

    @SerializedName("c_id")
    @Expose
    private String cId;

    @SerializedName("c_name")
    @Expose
    private String cName;

    /**
     * No args constructor for use in serialization
     */
    public CityResponse() {
    }

    /**
     * @param cName
     * @param cId
     */
    public CityResponse(String cId, String cName) {
        super();
        this.cId = cId;
        this.cName = cName;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "CityResponse{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                '}';
    }
}