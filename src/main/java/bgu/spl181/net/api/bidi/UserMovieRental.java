package bgu.spl181.net.api.bidi;


import java.util.List;

public class UserMovieRental extends User{

    private String country;
    private int balance;
    private List<Integer> moviesList;

    public UserMovieRental(String userName, String password, String type , int connectionId, String country, int balance, List<Integer> moviesList) { //TODO connection id where to initiate
        super(userName, password, type , connectionId);
        this.country = country;
        this.balance = balance;
        this.moviesList = moviesList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Integer> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Integer> moviesList) {
        this.moviesList = moviesList;
    }

    protected int addBalance(int balanceToAdd){
        return balance + balanceToAdd;

    }

    public boolean isAdmin(){
        if(type.equals("admin")){
            return true;
        }else {
            return false;}
    }
}