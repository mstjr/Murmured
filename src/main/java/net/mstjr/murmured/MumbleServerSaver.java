package net.mstjr.murmured;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.mstjr.murmured.api.IMumbleServerSaver;
import net.mstjr.murmured.api.*;

import java.io.*;

public class MumbleServerSaver implements IMumbleServerSaver {

    private static final Gson GSON = new GsonBuilder().create();

    private IMumbleServer server;

    public MumbleServerSaver(MumbleServer virtualServer) {
        this.server = virtualServer;
    }

    @Override
    public boolean backup(String filename) {
        VirtualServerEntity entity = backupEntity();
        if (entity == null) {
            return false;
        }

        String json = GSON.toJson(entity);
        return saveToFile(filename, entity);
    }

    @Override
    public String backupToJson() {
        return null;
    }

    @Override
    public boolean restore(String filename) {
        //TODO: Implement
        return false;
    }

    @Override
    public boolean restoreFromJson(String json) {
        //TODO: Implement
        return false;
    }

    @Override
    public boolean restore(VirtualServerEntity entity) {
        //TODO: Implement
        return false;
    }

    @Override
    public String saveToJson(VirtualServerEntity entity) {
        return GSON.toJson(entity, VirtualServerEntity.class);
    }

    @Override
    public boolean saveToFile(String filename, VirtualServerEntity entity) {
        File file = new File(filename);
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(GSON.toJson(entity));
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public VirtualServerEntity loadFromjson(String json) {
        return GSON.fromJson(json, VirtualServerEntity.class);
    }

    @Override
    public VirtualServerEntity loadFromFile(String filename) {
        File file = new File(filename);
        if(!file.exists()) {
            return null;
        }

        StringBuilder json = new StringBuilder();
        try(FileReader reader = new FileReader(file); BufferedReader bf = new BufferedReader(reader)){
            while (bf.ready()) {
                json.append(bf.readLine());
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        return loadFromjson(json.toString());
    }

    private VirtualServerEntity backupEntity() {
        if (!server.isRunning()) {
            return null;
        }

        server.getAllConf(false , false);
        server.getUsers(true, true, null, false);
        server.getAllChannels(false, true, false, false);
        server.getBans(false);

        return server.getEntity();
    }
}
