package net.mstjr.murmured.api;

public enum Context
{
    Server(1), // Murmur.ContextServer
    Channel(2), // Murmur.ContextChannel
    User(4); // Murmur.ContextUser

    int id;

    Context(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}