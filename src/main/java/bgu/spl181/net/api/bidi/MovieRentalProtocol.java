package bgu.spl181.net.api.bidi;

public class MovieRentalProtocol extends bidiMessagingProtocolImpl {


    public MovieRentalProtocol(MovieSharedData movieSharedData) {
        super(movieSharedData);
    }


    @Override
    public void parseringRequest(String args) {
        String result;
        MovieSharedData movieSharedData= (MovieSharedData)sharedData;
        String[] msg= args.split(" ");
        if (msg.length==0){
            connections.send(connectionId,"ERROR request failed");
        } else if(!movieSharedData.isLoggedIn(connectionId)) {
            if (!msg[0].equals("balance")) {
                connections.send(connectionId, "ERROR request" + msg[0] + "failed");
            } else {
                //TODO what if msg[1] is null??????????
                connections.send(connectionId, "ERROR request" + msg[0]+" "+msg[1] + "failed"); }
        }
        else {
            String movieName="";
            for (int i=1; i<msg.length;i++){
                movieName=movieName+msg[i]+" ";
            }
            movieName.substring(0,movieName.length()-1);

            switch (msg[0]) {//assume wont be nullpointer exception
                case "balance":
                    if(msg[1].equals("info")){
                        result= movieSharedData.commandRequestBalanceInfo(connectionId);
                        connections.send(connectionId,result);
                    }
                    else if (msg[1].equals("add")){
                        result=movieSharedData.commandRequestBalanceAdd(connectionId,Integer.decode(msg[2]));
                        connections.send(connectionId,result);

                    }
                    break;
                case "info":
                    if (msg.length==1){
                        result=movieSharedData.commandRequestMovieInfo(null);
                        connections.send(connectionId,result);
                    }
                    else{

                        result=movieSharedData.commandRequestMovieInfo(movieName);
                        connections.send(connectionId,result);
                    }
                    break;
                case  "rent":
                    result=movieSharedData.commandRequestMovieRent(connectionId,movieName);
                    connections.send(connectionId,result);
                    break;
                case "return":
                    result= movieSharedData.commandRequestReturnMovie(connectionId,movieName);
                    connections.send(connectionId,result);
                    break;
                case "addmovie":
                    //TODO!!!!!!!!!!!!!!!!!!!!!
                    break;
                case "remmovie":
                    result=movieSharedData.commandRequestAdminRemmovie(connectionId,movieName);
                    connections.send(connectionId,result);
                    break;
                case "changeprice":
                    //TODO!!!!!!!!!!!!














                    }


        }


    }
}