package bgu.spl181.net.api.bidi;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MovieSharedData extends SharedData{

    ConcurrentHashMap<Integer,Movie> moviesMap;
    List<Movie> movieList;


    public MovieSharedData(ConcurrentHashMap<String, User> userMovieRentalMap ,ConcurrentHashMap<Integer,Movie> moviesMap) {
        super(userMovieRentalMap);
        this.moviesMap = moviesMap;
        this.movieList = new LinkedList<>();
    }

    protected boolean isLoggedIn(Integer connectionId){
        if (mapOfLoggedInUsersByConnectedIds.contains(connectionId)) {
            return true;
        }
        else {return false;}
    }

    protected boolean isAdmin(Integer connectionId){
        if(isLoggedIn(connectionId) && ((UserMovieRental)mapOfLoggedInUsersByConnectedIds.get(connectionId)).isAdmin()){
            return true;
        }else {return false;}
    }

    protected String commandRequestBalanceInfo(Integer connectionId) {
        UserMovieRental user = (UserMovieRental)mapOfLoggedInUsersByConnectedIds.get(connectionId);
        int userBalance = user.getBalance();
        return "ACK balance " + userBalance;
    }

    protected String commandRequestBalanceAdd(Integer connectionId, int amount) {
        UserMovieRental user = (UserMovieRental)mapOfLoggedInUsersByConnectedIds.get(connectionId);
        int newBalance = user.addBalance(amount);
        return  "ACK balance " + newBalance + " added " + amount;
    }


    protected String commandRequestMovieInfo(String movieName) {
        String ret = "";
        if(movieName == null){
            for (Movie movie : movieList){
                ret = movie.getName() + " ";
            }
            ret = ret.substring(0, ret.length() -1);
            return "ACK info " + ret ;
        }
        else {
            for (Movie movie : movieList){
                if(movie.getName().equals(movieName)){
                    ret = movie.toString();
                    return "ACK info " + ret ;
                }
            }
            return null;
        }
    }

    protected String commandRequestMovieRent(Integer connectionId ,String movieName) {
        Movie move;
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName)) {

            }

        }
        return null;

    }

    protected String commandRequestReturnMovie(Integer connectionId, String movieName) {
    return null;

    }


    protected String commandRequestAdminAddMovie(Integer connectionId, String movieName , int amount , int price , List<String> bannedCountry) {
        return null;


    }

    protected String commandRequestAdminRemmovie(Integer connectionId,String movieName) {
        return null;

    }

    protected String commandRequestAdminChangePrice(Integer connectionId , String movieName , int price) {
        return null;


    }

    @Override
    protected boolean isValidDataBlock(String dataBlock) {
        return false;
    }

    @Override
    protected void addUser(String username, String password) {

    }
}