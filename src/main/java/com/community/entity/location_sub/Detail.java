package com.community.entity.location_sub;

/**
 * Created by yyc on 2020/2/19.
 */
public class Detail {
    private String city;

    private String city_code;

    private String district;

    private String province;

    private String street;

    private String street_number;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "city='" + city + '\'' +
                ", city_code='" + city_code + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", street='" + street + '\'' +
                ", street_number='" + street_number + '\'' +
                '}';
    }
}
