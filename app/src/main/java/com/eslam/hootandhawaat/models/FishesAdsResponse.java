package com.eslam.hootandhawaat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class FishesAdsResponse implements Serializable {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    /**
     * No args constructor for use in serialization
     */
    public FishesAdsResponse() {
    }

    /**
     * @param code
     * @param lastPage
     * @param data
     * @param success
     */
    public FishesAdsResponse(Integer code, Boolean success, Integer lastPage, List<Datum> data) {
        super();
        this.code = code;
        this.success = success;
        this.lastPage = lastPage;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public static class Datum implements Serializable {

        @SerializedName("f_id")
        @Expose
        private String fId;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("f_type_id")
        @Expose
        private String fTypeId;
        @SerializedName("f_weight")
        @Expose
        private String fWeight;
        @SerializedName("f_price")
        @Expose
        private String fPrice;
        @SerializedName("f_quantity")
        @Expose
        private String fQuantity;
        @SerializedName("f_image")
        @Expose
        private String fImage;
        @SerializedName("f_delevary")
        @Expose
        private String fDelevary;
        @SerializedName("f_cooking")
        @Expose
        private String fCooking;
        @SerializedName("f_des")
        @Expose
        private String fDes;
        @SerializedName("city_id")
        @Expose
        private String cityId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("f_t_id")
        @Expose
        private String fTId;
        @SerializedName("f_name")
        @Expose
        private String fName;
        @SerializedName("c_id")
        @Expose
        private String cId;
        @SerializedName("c_username")
        @Expose
        private String cUsername;

        /**
         * No args constructor for use in serialization
         */
        public Datum() {
        }

        /**
         * @param fId
         * @param fDes
         * @param cUsername
         * @param fCooking
         * @param fTId
         * @param fPrice
         * @param fDelevary
         * @param fTypeId
         * @param cityId
         * @param fWeight
         * @param createdAt
         * @param fImage
         * @param fName
         * @param fQuantity
         * @param customerId
         * @param updatedAt
         * @param cId
         */
        public Datum(String fId, String customerId, String fTypeId, String fWeight, String fPrice, String fQuantity, String fImage, String fDelevary, String fCooking, String fDes, String cityId, String createdAt, String updatedAt, String fTId, String fName, String cId, String cUsername) {
            super();
            this.fId = fId;
            this.customerId = customerId;
            this.fTypeId = fTypeId;
            this.fWeight = fWeight;
            this.fPrice = fPrice;
            this.fQuantity = fQuantity;
            this.fImage = fImage;
            this.fDelevary = fDelevary;
            this.fCooking = fCooking;
            this.fDes = fDes;
            this.cityId = cityId;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.fTId = fTId;
            this.fName = fName;
            this.cId = cId;
            this.cUsername = cUsername;
        }

        public String getFId() {
            return fId;
        }

        public void setFId(String fId) {
            this.fId = fId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFTypeId() {
            return fTypeId;
        }

        public void setFTypeId(String fTypeId) {
            this.fTypeId = fTypeId;
        }

        public String getFWeight() {
            return fWeight;
        }

        public void setFWeight(String fWeight) {
            this.fWeight = fWeight;
        }

        public String getFPrice() {
            return fPrice;
        }

        public void setFPrice(String fPrice) {
            this.fPrice = fPrice;
        }

        public String getFQuantity() {
            return fQuantity;
        }

        public void setFQuantity(String fQuantity) {
            this.fQuantity = fQuantity;
        }

        public String getFImage() {
            return fImage;
        }

        public void setFImage(String fImage) {
            this.fImage = fImage;
        }

        public String getFDelevary() {
            return fDelevary;
        }

        public void setFDelevary(String fDelevary) {
            this.fDelevary = fDelevary;
        }

        public String getFCooking() {
            return fCooking;
        }

        public void setFCooking(String fCooking) {
            this.fCooking = fCooking;
        }

        public String getFDes() {
            return fDes;
        }

        public void setFDes(String fDes) {
            this.fDes = fDes;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
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

        public String getCId() {
            return cId;
        }

        public void setCId(String cId) {
            this.cId = cId;
        }

        public String getCUsername() {
            return cUsername;
        }

        public void setCUsername(String cUsername) {
            this.cUsername = cUsername;
        }

        @Override
        public String toString() {
            return "Datum{" +
                    "fId='" + fId + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", fTypeId='" + fTypeId + '\'' +
                    ", fWeight='" + fWeight + '\'' +
                    ", fPrice='" + fPrice + '\'' +
                    ", fQuantity='" + fQuantity + '\'' +
                    ", fImage='" + fImage + '\'' +
                    ", fDelevary='" + fDelevary + '\'' +
                    ", fCooking='" + fCooking + '\'' +
                    ", fDes='" + fDes + '\'' +
                    ", cityId='" + cityId + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", fTId='" + fTId + '\'' +
                    ", fName='" + fName + '\'' +
                    ", cId='" + cId + '\'' +
                    ", cUsername='" + cUsername + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FishesAdsResponse{" +
                "code=" + code +
                ", success=" + success +
                ", lastPage=" + lastPage +
                ", data=" + data +
                '}';
    }
}