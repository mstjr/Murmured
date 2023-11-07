package net.mstjr.murmured.api;

public enum ServerContext
{
    Server(1), // Murmur.ContextServer
    Channel(2), // Murmur.ContextChannel
    User(4); // Murmur.ContextUser

    int value;

    ServerContext(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}