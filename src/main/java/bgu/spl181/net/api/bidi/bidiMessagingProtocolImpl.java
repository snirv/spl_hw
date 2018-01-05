package bgu.spl181.net.api.bidi;

public class bidiMessagingProtocolImpl<T> implements bidiMessagingProtocol<T> {


    @Override
    public void start(int connectionId, Connections<T> connections) {

    }

    @Override
    public void process(T message) {

    }

    /**
     * @return true if the connection should be terminated
     */
    @Override
    public boolean shouldTerminate() {
        return false;
    }
}
