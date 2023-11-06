package net.mstjr.murmured;

import net.mstjr.murmured.api.IVirtualServerKeeper;
import net.mstjr.murmured.api.*;
public class VirtualServerKeeper implements IVirtualServerKeeper {
    public VirtualServerKeeper(MumbleServer virtualServer) {

    }

    @Override
    public boolean backup(String filename) {
        return false;
    }

    @Override
    public String backupToXml() {
        return null;
    }

    @Override
    public boolean restore(String filename) {
        return false;
    }

    @Override
    public boolean restoreFromXml(String xml) {
        return false;
    }

    @Override
    public boolean restore(VirtualServerEntity entity) {
        return false;
    }

    @Override
    public String saveToXml(VirtualServerEntity entity) {
        return null;
    }

    @Override
    public boolean saveToFile(String filename, VirtualServerEntity entity) {
        return false;
    }

    @Override
    public VirtualServerEntity loadFromXml(String sxml) {
        return null;
    }

    @Override
    public VirtualServerEntity loadFromFile(String filename) {
        return null;
    }

}
