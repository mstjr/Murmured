package net.mstjr.murmured.api;

/**
 * @implNote This interface is not working yet.
 */
public interface IVirtualServerKeeper {

    boolean backup(String filename);
    String backupToXml();

    boolean restore(String filename);
    boolean restoreFromXml(String xml);
    boolean restore(VirtualServerEntity entity);


    String saveToXml(VirtualServerEntity entity);
    boolean saveToFile(String filename, VirtualServerEntity entity);
    VirtualServerEntity loadFromXml(String sxml);
    VirtualServerEntity loadFromFile(String filename);
}