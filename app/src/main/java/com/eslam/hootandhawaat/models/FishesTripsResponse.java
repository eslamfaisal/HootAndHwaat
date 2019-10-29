package com.eslam.hootandhawaat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
public class FishesTripsResponse implements Serializable {


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
    public FishesTripsResponse() {
    }

    /**
     * @param code
     * @param lastPage
     * @param data
     * @param success
     */
    public FishesTripsResponse(Integer code, Boolean success, Integer lastPage, List<Datum> data) {
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

        private final static long serialVersionUID = 4720866387608125842L;
        @SerializedName("trip_id")
        @Expose
        private String tripId;
        @SerializedName("vehicle_type")
        @Expose
        private String vehicleType;
        @SerializedName("customer_id")
        @Expose
        private String customerId;
        @SerializedName("trip_vehicle_id")
        @Expose
        private String tripVehicleId;
        @SerializedName("trip_beach_name")
        @Expose
        private String tripBeachName;
        @SerializedName("marasi_name")
        @Expose
        private String marasiName;
        @SerializedName("city_name")
        @Expose
        private String cityName;
        @SerializedName("trip_type")
        @Expose
        private String tripType;
        @SerializedName("trip_boatName")
        @Expose
        private String tripBoatName;
        @SerializedName("trip_date")
        @Expose
        private String tripDate;
        @SerializedName("trip_time")
        @Expose
        private String tripTime;
        @SerializedName("trip_start_time")
        @Expose
        private String tripStartTime;
        @SerializedName("trip_end_time")
        @Expose
        private String tripEndTime;
        @SerializedName("trip_price")
        @Expose
        private String tripPrice;
        @SerializedName("passengers")
        @Expose
        private String passengers;
        @SerializedName("customer_name")
        @Expose
        private String customerName;
        @SerializedName("trip_image")
        @Expose
        private String tripImage;
        @SerializedName("created_at")
        @Expose
        private String createdAt;

        /**
         * No args constructor for use in serialization
         */
        public Datum() {
        }

        /**
         * @param passengers
         * @param tripBoatName
         * @param tripBeachName
         * @param tripId
         * @param customerName
         * @param createdAt
         * @param tripType
         * @param cityName
         * @param tripDate
         * @param tripEndTime
         * @param tripPrice
         * @param customerId
         * @param tripVehicleId
         * @param marasiName
         * @param tripStartTime
         * @param tripImage
         * @param vehicleType
         * @param tripTime
         */
        public Datum(String tripId, String vehicleType, String customerId, String tripVehicleId, String tripBeachName, String marasiName, String cityName, String tripType, String tripBoatName, String tripDate, String tripTime, String tripStartTime, String tripEndTime, String tripPrice, String passengers, String customerName, String tripImage, String createdAt) {
            super();
            this.tripId = tripId;
            this.vehicleType = vehicleType;
            this.customerId = customerId;
            this.tripVehicleId = tripVehicleId;
            this.tripBeachName = tripBeachName;
            this.marasiName = marasiName;
            this.cityName = cityName;
            this.tripType = tripType;
            this.tripBoatName = tripBoatName;
            this.tripDate = tripDate;
            this.tripTime = tripTime;
            this.tripStartTime = tripStartTime;
            this.tripEndTime = tripEndTime;
            this.tripPrice = tripPrice;
            this.passengers = passengers;
            this.customerName = customerName;
            this.tripImage = tripImage;
            this.createdAt = createdAt;
        }

        public String getTripId() {
            return tripId;
        }

        public void setTripId(String tripId) {
            this.tripId = tripId;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getTripVehicleId() {
            return tripVehicleId;
        }

        public void setTripVehicleId(String tripVehicleId) {
            this.tripVehicleId = tripVehicleId;
        }

        public String getTripBeachName() {
            return tripBeachName;
        }

        public void setTripBeachName(String tripBeachName) {
            this.tripBeachName = tripBeachName;
        }

        public String getMarasiName() {
            return marasiName;
        }

        public void setMarasiName(String marasiName) {
            this.marasiName = marasiName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getTripType() {
            return tripType;
        }

        public void setTripType(String tripType) {
            this.tripType = tripType;
        }

        public String getTripBoatName() {
            return tripBoatName;
        }

        public void setTripBoatName(String tripBoatName) {
            this.tripBoatName = tripBoatName;
        }

        public String getTripDate() {
            return tripDate;
        }

        public void setTripDate(String tripDate) {
            this.tripDate = tripDate;
        }

        public String getTripTime() {
            return tripTime;
        }

        public void setTripTime(String tripTime) {
            this.tripTime = tripTime;
        }

        public String getTripStartTime() {
            return tripStartTime;
        }

        public void setTripStartTime(String tripStartTime) {
            this.tripStartTime = tripStartTime;
        }

        public String getTripEndTime() {
            return tripEndTime;
        }

        public void setTripEndTime(String tripEndTime) {
            this.tripEndTime = tripEndTime;
        }

        public String getTripPrice() {
            return tripPrice;
        }

        public void setTripPrice(String tripPrice) {
            this.tripPrice = tripPrice;
        }

        public String getPassengers() {
            return passengers;
        }

        public void setPassengers(String passengers) {
            this.passengers = passengers;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getTripImage() {
            return tripImage;
        }

        public void setTripImage(String tripImage) {
            this.tripImage = tripImage;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

    }

}