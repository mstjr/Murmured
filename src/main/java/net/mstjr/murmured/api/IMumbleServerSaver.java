package net.mstjr.murmured.api;

/**
 * @implNote This interface is not working yet.
 */
public interface IMumbleServerSaver {

    boolean backup(String filename);
    String backupToJson();

    boolean restore(String filename);
    boolean restoreFromJson(String xml);
    boolean restore(VirtualServerEntity entity);


    String saveToJson(VirtualServerEntity entity);
    boolean saveToFile(String filename, VirtualServerEntity entity);
    VirtualServerEntity loadFromjson(String sxml);
    VirtualServerEntity loadFromFile(String filename);
}