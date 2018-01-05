package bgu.spl181.net.api.bidi;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


//I am snir
public class Movie {
    protected Integer id;
    protected String name;
    protected Integer price;
    protected List<String> bannedCountries;
    protected AtomicInteger availableAmount;
    protected AtomicInteger totalAmount;

    public Movie(Integer id, String name, Integer price, List<String> bannedCountries, AtomicInteger availableAmount, AtomicInteger totalAmount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bannedCountries = bannedCountries;
        this.availableAmount = availableAmount;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        String bannedCountries ="";
        for (String country : this.bannedCountries){
            bannedCountries = country + " ";
        }
        bannedCountries = bannedCountries.substring(0, bannedCountries.length() -1);
        return name + " " + availableAmount + " " + price + " " + bannedCountries ;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getBannedCountries() {
        return bannedCountries;
    }

    public void setBannedCountries(List<String> bannedCountries) {
        this.bannedCountries = bannedCountries;
    }

    public AtomicInteger getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(AtomicInteger availableAmount) {
        this.availableAmount = availableAmount;
    }

    public AtomicInteger getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(AtomicInteger totalAmount) {
        this.totalAmount = totalAmount;
    }
}
