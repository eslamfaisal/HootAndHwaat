package com.eslam.hootandhawaat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FishesTypeResponse implements Serializable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("types")
    @Expose
    private List<Type> types = null;


    /**
     * No args constructor for use in serialization
     */
    public FishesTypeResponse() {
    }

    /**
     * @param types
     * @param code
     */
    public FishesTypeResponse(Integer code, List<Type> types) {
        super();
        this.code = code;
        this.types = types;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public static class Type implements Serializable {

        @SerializedName("f_t_id")
        @Expose
        private String fTId;
        @SerializedName("f_name")
        @Expose
        private String fName;

        /**
         * No args constructor for use in serialization
         */
        public Type() {
        }

        /**
         * @param fName
         * @param fTId
         */
        public Type(String fTId, String fName) {
            super();
            this.fTId = fTId;
            this.fName = fName;
        }

        public String getFTId() {
            return fTId;
        }

        public void setFTId(String fTId) {
            this.fTId = fTId;
        }

        public String getFName() {
            return fName;
        }

        public void setFName(String fName) {
            this.fName = fName;
        }

        @Override
        public String toString() {
            return "Type{" +
                    "fTId='" + fTId + '\'' +
                    ", fName='" + fName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FishesTypeResponse{" +
                "code=" + code +
                ", types=" + types +
                '}';
    }
}
