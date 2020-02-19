package com.community.entity.location_sub;

/**
 * Created by yyc on 2020/2/19.
 */
public class Content {
    private String address;

    private Detail address_detail;

    private Point point;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Detail getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(Detail address_detail) {
        this.address_detail = address_detail;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Content{" +
                "address='" + address + '\'' +
                ", address_detail=" + address_detail +
                ", point=" + point +
                '}';
    }
}
