package net.mstjr.murmured.api;

import java.util.HashMap;
import java.util.Map;

public class VirtualServerEntity {

    public int id;
    public String address;
    public int port;

    public Map<String, String> config = new HashMap<String, String>();
    public Map<Integer, User> users = new HashMap<Integer, User>();
    public Map<Integer, Channel> channels = new HashMap<Integer, Channel>();
    public Map<Integer, Ban> bans = new HashMap<Integer, Ban>();
    public Map<Integer, OnlineUser> onlineUsers = new HashMap<Integer, OnlineUser>();


    public static class User {

        public int id;
        public byte[] texture;

        public Map<Object, String> info = new HashMap<>();

    }


    public static enum UserInfo {
        UserName,
        UserEmail,
        UserComment,
        UserHash,
        UserPassword,
        UserLastActive
    }

    public static class OnlineUser {
        public int id;
        public int channelId;
        public String name;
        public byte[] address;
        public int bytesPerSec;
        public String comment;
        public String context;
        public boolean deaf;
        public String identity;
        public int idlesecs;
        public boolean mute;
        public int onlineSecs;
        public String os;
        public String osVersion;
        public boolean prioritySpeaker;
        public boolean recording;
        public String release;
        public boolean selfDeaf;
        public boolean selfMute;
        public int session;
        public boolean supress;
        public float tcpPing;
        public boolean tcpOnly;
        public float udpPing;
        public int version;

        public void move(IMumbleServer server, int newChannelId) {
            this.channelId = newChannelId;
            server.updateUserState(this);
        }

        public void setMute(IMumbleServer server, boolean mute) {
            this.mute = mute;
            server.updateUserState(this);
        }

        public void setDeafen(IMumbleServer server, boolean deaf) {
            this.deaf = deaf;
            server.updateUserState(this);
        }

    }


    public static class Channel {
        public int id;
        public String name;
        public int parentId;
        public boolean inheritAcl = true;

        public String description;
        public int position;
        public boolean temporary = false;

        public int[] links;

        public HashMap<Integer, Group> groups = new HashMap<Integer, Group>();
        public HashMap<Integer, Acl> acls = new HashMap<Integer, Acl>();

        public static class Group {
            public String name;
            public boolean inherit;
            public boolean inheritable;
            public boolean inherited;

            public int[] members;
            public int[] add;
            public int[] remove;
        }

        public static class Acl {
            public int allow;
            public boolean applySubs;
            public boolean applyHere;
            public int deny;
            public String group;
            public boolean inherited;
            public int userId;
        }

        public void move(IMumbleServer server, int newParentId) {
            this.parentId = newParentId;
            server.updateChannelState(this);
        }

        public void setName(IMumbleServer server, String newName) {
            this.name = newName;
            server.updateChannelState(this);
        }
    }

    public static class Tree {
        public Channel channel;
        public Tree[] children;
        public OnlineUser[] users;
    }

    public static class Ban {
        public byte[] address;
        public int bits;
        public int duration;
        public String hash;
        public String name;
        public String reason;
        public int start;
    }

    public static abstract class LogEntry {
        public int timestamp;
        public String text;
    }
}
