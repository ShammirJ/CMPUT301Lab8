package com.example.lab8;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object is compared with itself
        if (this == obj) {
            return true;
        }
        // Check if the object is null or not the same class type
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Typecast obj to City and compare fields
        City city = (City) obj;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}
