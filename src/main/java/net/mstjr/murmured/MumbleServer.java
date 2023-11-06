package net.mstjr.murmured;

import net.mstjr.murmur.exceptions.invalid.InvalidSecretException;
import net.mstjr.murmur.exceptions.server.ServerBootedException;
import net.mstjr.murmur.logging.LogEntry;
import net.mstjr.murmur.proxy.server.channel.ACL;
import net.mstjr.murmur.proxy.server.channel.Channel;
import net.mstjr.murmur.proxy.server.entities.Ban;
import net.mstjr.murmur.proxy.server.entities.Group;
import net.mstjr.murmur.proxy.server.entities.Tree;
import net.mstjr.murmur.proxy.server.users.User;
import net.mstjr.murmur.proxy.server.users.UserInfo;
import net.mstjr.murmur.prx.MetaPrx;
import net.mstjr.murmur.prx.ServerPrx;
import net.mstjr.murmured.api.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MumbleServer implements IMumbleServer {
    private IVirtualServerKeeper keeper;
    private VirtualServerEntity entity;

    private ServerPrx server;
    private MetaPrx proxy;
    private MurmurProxy murmurProxy;
    private String murmurVersion;

    private final int MAX_BANDWIDTH = 320;


    public MetaPrx getProxy() {
        return proxy;
    }

    public ServerPrx getServer() {
        return server;
    }

    public MumbleServer(ServerPrx server, MurmurProxy murmurProxy) {
        this.murmurProxy = murmurProxy;
        proxy = murmurProxy.getMeta();
        this.server = server;

        entity = new VirtualServerEntity();
        entity.address = murmurProxy.getHost();
        murmurVersion = murmurProxy.getVersion();

        keeper = new VirtualServerKeeper(this);
    }

    @Override
    public IVirtualServerKeeper getKeeper() {
        return keeper;
    }

    @Override
    public VirtualServerEntity getEntity() {
        return entity;
    }

    @Override
    public boolean isRunning() {
        try {
            return server.isRunning();
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public int getOnline() {
        try {
            return server.getUsers().size();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int getUptime() {
        try {
            return server.getUptime();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean start() {
        try {
            if (!server.isRunning()) {
                server.start();
                setConf("boot", "true");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean stop() {
        try {
            if (server.isRunning()) {
                server.stop();
                setConf("boot", "false");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean restart() {
        try {
            if (server.isRunning()) {
                server.stop();
                server.start();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public void sendMessage(int sessionId, String text) {
        try {
            server.sendMessage(sessionId, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageChannel(int channelId, String text, boolean tree) {
        try {
            server.sendMessageChannel(channelId, tree, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSuperuserPassword(String password) {
        try {
            server.setSuperuserPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLog(int lines, boolean format) {
        LogEntry[] log = new LogEntry[0];

        try {
            log = server.getLog(0, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder logText = new StringBuilder();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (LogEntry logEntry : log) {
            if (format) {
                logText.append(dateFormat.format(new Date(logEntry.timestamp * 1000L)));
                logText.append(" ");
                logText.append(logEntry.txt);
                logText.append("\n");
            } else {
                logText.append(logEntry.txt);
            }
        }

        return logText.toString();
    }


    @Override
    public int getId() {
        try {
            if (entity.id == 0) {
                entity.id = server.id();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity.id;
    }

    @Override
    public int getPort() {
        String portString = getConf("port", false);
        int port = -1;
        if (portString == null || portString.isEmpty()) {
            try {
                port = Integer.parseInt(proxy.getDefaultConf().get("port")) + getId() - 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            port = Integer.parseInt(portString);
        }
        return port;
    }

    @Override
    public void setPort(int port) {
        entity.port = port;
        setConf("port", String.valueOf(port));
    }

    @Override
    public int getSlots() {
        return Integer.parseInt(getConf("users"));
    }

    @Override
    public void setSlots(int slots) {
        setConf("users", String.valueOf(slots));
    }

    @Override
    public String getWelcomeMessage() {
        return getConf("welcometext");
    }

    @Override
    public void setWelcomeMessage(String welcomeMessage) {
        setConf("welcometext", welcomeMessage);
    }

    @Override
    public String getName() {
        return getConf("registername");
    }

    @Override
    public void setName(String name) {
        setConf("registername", name);
    }

    @Override
    public String getPassword() {
        return getConf("password");
    }

    @Override
    public void setPassword(String password) {
        setConf("password", password);
    }

    @Override
    public boolean doesAllowHtml() {
        return Boolean.parseBoolean(getConf("allowhtml"));
    }

    @Override
    public void setAllowHtml(boolean allowHtml) {
        setConf("allowhtml", String.valueOf(allowHtml));
    }

    @Override
    public int getDefaultChannel() {
        return Integer.parseInt(getConf("defaultchannel"));
    }

    @Override
    public void setDefaultChannel(int defaultChannel) {
        setConf("defaultchannel", String.valueOf(defaultChannel));
    }

    @Override
    public int getBandwidth() {
        int value = Integer.parseInt(getConf("bandwidth")) / 1000;
        if (value > MAX_BANDWIDTH) {
            return MAX_BANDWIDTH;
        }
        return MAX_BANDWIDTH;
    }

    @Override
    public void setBandwidth(int bandwidth) {

        if (bandwidth > MAX_BANDWIDTH) {
            bandwidth = MAX_BANDWIDTH;
        }
        setConf("bandwidth", String.valueOf(bandwidth * 1000));
    }

    @Override
    public int getTimeout() {
        return Integer.parseInt(getConf("timeout"));
    }

    @Override
    public void setTimeout(int timeout) {
        setConf("timeout", String.valueOf(timeout));
    }

    @Override
    public int getMaxUsersPerChannel() {
        String maxUsersPerChannelString = getConf("usersperchannel"); //FIXME : it always null (why?)
        if (maxUsersPerChannelString == null) return 0;

        return Integer.parseInt(maxUsersPerChannelString);
    }

    @Override
    public void setMaxUsersPerChannel(int maxUsersPerChannel) {
        setConf("usersperchannel", String.valueOf(maxUsersPerChannel));
    }

    @Override
    public int getMaxTextMessageLength() {
        return Integer.parseInt(getConf("textmessagelength"));
    }

    @Override
    public void setMaxTextMessageLength(int maxTextMessageLength) {
        setConf("textmessagelength", String.valueOf(maxTextMessageLength));
    }

    @Override
    public String getChannelNameRegex() {
        return getConf("channelname");
    }

    @Override
    public void setChannelNameRegex(String channelNameRegex) {
        setConf("channelname", channelNameRegex);
    }

    @Override
    public String getUserNameRegex() {
        return getConf("username");
    }

    @Override
    public void setUserNameRegex(String userNameRegex) {
        setConf("username", userNameRegex);
    }

    @Override
    public boolean doesRememberChannel() {
        return Boolean.parseBoolean(getConf("rememberchannel"));
    }

    @Override
    public void setRememberChannel(boolean rememberChannel) {
        setConf("rememberchannel", String.valueOf(rememberChannel));
    }

    @Override
    public boolean doesCertificateRequired() {
        return Boolean.parseBoolean(getConf("certrequired"));
    }

    @Override
    public void setCertificateRequired(boolean certificateRequired) {
        setConf("certrequired", String.valueOf(certificateRequired));
    }

    @Override
    public String getCertificate() {
        return getConf("certificate");
    }

    @Override
    public void setCertificate(String certificate) {
        setConf("certificate", certificate);
    }

    @Override
    public String getCertificateKey() {
        return getConf("key");
    }

    @Override
    public void setCertificateKey(String certificateKey) {
        setConf("key", certificateKey);
    }

    @Override
    public String getRegisterHostname() {
        return getConf("registerhostname");
    }

    @Override
    public void setRegisterHostname(String registerHostname) {
        setConf("registerhostname", registerHostname);
    }

    @Override
    public String getRegisterUrl() {
        return getConf("registerurl");
    }

    @Override
    public void setRegisterUrl(String registerUrl) {
        setConf("registerurl", registerUrl);
    }

    @Override
    public String getRegisterPassword() {
        return getConf("registerpassword");
    }

    @Override
    public void setRegisterPassword(String registerPassword) {
        setConf("registerpassword", registerPassword);
    }

    private boolean isNewConfig;

    @Override
    public Map<String, String> getAllConf(boolean getDefault, boolean cache) {
        if (!cache || isNewConfig) {
            isNewConfig = false;

            entity.config.clear();

            try {
                server.getAllConf().forEach((k, v) -> {
                    if (k.equals("port")) entity.port = Integer.parseInt(v);

                    entity.config.put(k, v);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (getDefault) {
                murmurProxy.getDefaultConf().forEach((k, v) -> {
                    if (!entity.config.containsKey(k)) entity.config.put(k, v);
                });

            }

        }
        return entity.config;
    }

    @Override
    public String getConf(String key, boolean getDefault, boolean cache) {
        if (!cache || !entity.config.containsKey(key)) {
            String value = null;

            try {
                value = server.getConf(key);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (value == null || value.isEmpty()) {
                // return default config value if exist
                if (getDefault)
                    if (murmurProxy.getDefaultConf().containsKey(key)) value = murmurProxy.getDefaultConf().get(key);

                if (value == null || value.isEmpty()) return null;
            }


            // update cache
            if (entity.config.containsKey(key)) entity.config.replace(key, value);
            else entity.config.put(key, value);
        }

        if (entity.config.containsKey(key)) return entity.config.get(key);

        return null;
    }


    @Override
    public void setConf(String key, String value) {
        try {
            server.setConf(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (entity.config.containsKey(key)) entity.config.replace(key, value);
        else entity.config.put(key, value);
    }

    private boolean isNewChannels = true;

    @Override
    public Map<Integer, VirtualServerEntity.Channel> getAllChannels(boolean getTemporary, boolean getAcl, boolean getInherited, boolean cache) {
        if (!cache || isNewChannels) {
            isNewChannels = false;

            // clear
            entity.channels.clear();
            try {
                for (Map.Entry<Integer, Channel> entry : server.getChannels().entrySet()) {
                    int key = entry.getKey();
                    Channel value = entry.getValue();

                    // ignore temporary channels
                    if (value.temporary && !getTemporary) continue;

                    net.mstjr.murmured.api.VirtualServerEntity.Channel channel = getChannel(value);

                    entity.channels.put(key, channel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity.channels;
    }


    @Override
    public int addChannel(String name, int parentId) {
        int cid = 0;

        // only one root channel is available (it has parent id = -1 and can't be removed or added)
        if (parentId > -1) {
            // add channel
            try {
                cid = server.addChannel(name, parentId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // add in cache if not exist
        if (!entity.channels.containsKey(cid)) {
            VirtualServerEntity.Channel channel = new VirtualServerEntity.Channel();
            channel.id = cid;
            channel.name = name;
            channel.parentId = parentId;

            entity.channels.put(cid, channel);
        }

        return cid;
    }

    @Override
    public void updateChannelState(net.mstjr.murmured.api.VirtualServerEntity.Channel channel, boolean setAcl) {
        // set channel info
        Channel state = new Channel(channel.id, channel.name, channel.parentId, channel.links, channel.description, false, channel.position);
        try {
            server.setChannelState(state);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (setAcl) {
            // set groups
            Group[] groups = new Group[channel.groups.size()];
            for (int i = 0; i < channel.groups.size(); i++) {
                VirtualServerEntity.Channel.Group g = channel.groups.get(i);
                groups[i] = new Group(g.name, g.inherited, g.inherit, g.inheritable, g.add, g.remove, g.members);
            }
            // set acls
            ACL[] acls = new ACL[channel.acls.size()];
            for (int i = 0; i < channel.acls.size(); i++) {
                VirtualServerEntity.Channel.Acl a = channel.acls.get(i);
                acls[i] = new ACL(a.applyHere, a.applySubs, a.inherited, a.userId, a.group, a.allow, a.deny);
            }
            try {
                server.setACL(channel.id, acls, groups, channel.inheritAcl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (entity.channels.containsKey(channel.id)) entity.channels.replace(channel.id, channel);
        else entity.channels.put(channel.id, channel);
    }

    @Override
    public void removeChannel(int channelId) {
        try {
            server.removeChannel(channelId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        entity.channels.remove(channelId);
    }

    private boolean _isNewUsers = true;
    private boolean _isNewOnlineUsers = true;

    @Override
    public Map<Integer, net.mstjr.murmured.api.VirtualServerEntity.OnlineUser> getOnlineUsers(boolean cache) {
        // update cache
        if (!cache || _isNewOnlineUsers) {
            _isNewOnlineUsers = false;

            // clear
            entity.onlineUsers.clear();

            // non-registered users have id = -1
            // so we use simple increment as id
            AtomicInteger i = new AtomicInteger();

            try {
                server.getUsers().forEach((k, v) -> {
                    net.mstjr.murmured.api.VirtualServerEntity.OnlineUser user = getOnlineUser(v);
                    entity.onlineUsers.put(i.get(), user);
                    i.getAndIncrement();
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity.onlineUsers;
    }

    @Override
    public VirtualServerEntity.OnlineUser getOnlineUser(User u) {
        VirtualServerEntity.OnlineUser user = new VirtualServerEntity.OnlineUser();
        user.id = u.userid;
        user.channelId = u.channel;
        user.name = u.name;
        user.address = u.address;
        user.bytesPerSec = u.bytespersec;
        user.comment = u.comment;
        user.context = u.context;
        user.deaf = u.deaf;
        user.identity = u.identity;
        user.idlesecs = u.idlesecs;
        user.mute = u.mute;
        user.onlineSecs = u.onlinesecs;
        user.os = u.os;
        user.osVersion = u.osversion;
        user.prioritySpeaker = u.prioritySpeaker;
        user.recording = u.recording;
        user.release = u.release;
        user.selfDeaf = u.selfDeaf;
        user.selfMute = u.selfMute;
        user.session = u.session;
        user.supress = u.suppress;
        user.tcpOnly = u.tcponly;
        user.tcpPing = u.tcpPing;
        user.udpPing = u.udpPing;
        user.version = u.version;

        return user;
    }


    @Override
    public VirtualServerEntity.Channel getChannel(Channel c) {
        VirtualServerEntity.Channel channel = new VirtualServerEntity.Channel();
        channel.id = c.id;
        channel.name = c.name;
        channel.description = c.description;
        channel.parentId = c.parent;
        channel.links = c.links;
        channel.position = c.position;
        channel.temporary = c.temporary;
        return channel;
    }

    @Override
    public Map<Integer, net.mstjr.murmured.api.VirtualServerEntity.User> getUsers(boolean getInfo, boolean getTexture, String filter, boolean cache) {
        // update cache
        if (!cache || _isNewUsers) {
            _isNewUsers = false;

            // clear
            entity.users.clear();

            Map<Integer, String> users = new HashMap<>();

            try {
                users = server.getRegisteredUsers(filter);
            } catch (Exception e) {
                e.printStackTrace();
            }

            users.forEach((k, v) -> {
                try {
                    VirtualServerEntity.User user = getUser(k, getInfo, getTexture, cache);
                    entity.users.put(k, user);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[ERROR] bad user " + v);
                }
            });

        }
        return entity.users;
    }

    @Override
    public net.mstjr.murmured.api.VirtualServerEntity.User getUser(int userId, boolean getInfo, boolean getTexture, boolean cache) {
        if (!cache || !entity.users.containsKey(userId)) {
            // create object
            net.mstjr.murmured.api.VirtualServerEntity.User user = new net.mstjr.murmured.api.VirtualServerEntity.User();
            user.id = userId;

            try {
                if (getTexture) user.texture = server.getTexture(userId);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (getInfo) {
                    Map<UserInfo, String> userInfo = server.getRegistration(userId);
                    if (userInfo == null) return null;

                    user.info.putAll(userInfo);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // update in cache
            if (entity.users.containsKey(userId)) entity.users.replace(userId, user);
            else entity.users.put(userId, user);
        }

        return entity.users.get(userId);
    }

    @Override
    public int registerUser(net.mstjr.murmured.api.VirtualServerEntity.User user) {
        Map<UserInfo, String> newUser = new HashMap<>();
        newUser.forEach((k, v) -> {
            if (user.info.containsKey(k)) newUser.put(k, user.info.get(k));
        });

        int id = 0;
        try {
            // register user
            id = server.registerUser(newUser);
            // update id
            user.id = id;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // set user texture
            if (user.texture.length > 0) server.setTexture(id, user.texture);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // add in cache
        entity.users.put(id, user);

        return id;
    }

    @Override
    public void unregisterUser(int userId) {
        try {
            server.unregisterUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // remove from cache
        if (entity.users.containsKey(userId)) entity.users.remove(userId);
    }

    @Override
    public void updateUserInfo(net.mstjr.murmured.api.VirtualServerEntity.User user) {
        Map<UserInfo, String> newInfo = new HashMap<>();
        user.info.forEach((k, v) -> {
            if (user.info.containsKey(k)) newInfo.put((UserInfo) k, user.info.get(k));
        });


        // set user info
        try {
            server.updateRegistration(user.id, newInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // update in cache
        if (entity.users.containsKey(user.id)) entity.users.replace(user.id, user);
        else entity.users.put(user.id, user);
    }

    @Override
    public void updateUserState(net.mstjr.murmured.api.VirtualServerEntity.OnlineUser user) {
// set user state
        User state = new User(user.session, user.id, user.mute, user.deaf, user.supress,

                user.prioritySpeaker,

                user.selfMute, user.selfDeaf,

                user.recording,

                user.channelId, user.name, user.onlineSecs, user.bytesPerSec, user.version, -1, user.release, user.os, user.osVersion, user.identity, user.context, user.comment, user.address, user.tcpOnly, user.idlesecs

                , user.udpPing, user.tcpPing);

        try {
            server.setState(state);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // update in cache
        if (entity.onlineUsers.containsKey(user.id))
            entity.onlineUsers.replace(user.id, user);
        else entity.onlineUsers.put(user.id, user);
    }

    @Override
    public void kickUser(int sessionId, String reason) {
        try {
            server.kickUser(sessionId, reason);
        } catch (Exception e) {
            e.printStackTrace();
        }

        entity.onlineUsers.forEach((k, v) -> {
            if (v.session == sessionId) entity.onlineUsers.remove(k);
        });
    }

    private boolean _isNewBans = true;

    @Override
    public Map<Integer, net.mstjr.murmured.api.VirtualServerEntity.Ban> getBans(boolean cache) {
        if (!cache || _isNewBans) {
            _isNewBans = false;

            // clear
            entity.bans.clear();

            // add
            int cb = 0;
            try {
                for (Ban ban : server.getBans()) {
                    VirtualServerEntity.Ban finalBan = new VirtualServerEntity.Ban();
                    finalBan.address = ban.address;
                    finalBan.bits = ban.bits;
                    finalBan.duration = ban.duration;
                    finalBan.hash = ban.hash;
                    finalBan.name = ban.name;
                    finalBan.reason = ban.reason;
                    finalBan.start = (int) ban.start;
                    entity.bans.put(cb, finalBan);
                    cb++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entity.bans;
    }

    @Override
    public void setBans(Map<Integer, net.mstjr.murmured.api.VirtualServerEntity.Ban> bans) {
        // clear banlist
        if (bans == null) {
            // clear remote
            try {
                server.setBans(null);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // clear cache
            entity.bans.clear();

            return;
        }

        // update remote
        Ban[] _bans = new Ban[bans.size()];
        for (int i = 0; i < bans.size(); i++) {
            VirtualServerEntity.Ban b = bans.get(i);
            _bans[i] = new Ban(b.address, b.bits, b.name, b.hash, b.reason, b.start, b.duration);
        }


        try {
            server.setBans(_bans);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // clear cache
        entity.bans.clear();

        // update cache
        entity.bans = bans;
    }

    @Override
    public VirtualServerEntity.Tree getTree() {
        try {
            return getTreeItem(server.getTree());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private VirtualServerEntity.Tree[] getTree(Tree[] tree) {
        if (tree == null)
            return null;

        VirtualServerEntity.Tree[] obj = new VirtualServerEntity.Tree[tree.length];
        for (int i = 0; i < tree.length; i++) {
            obj[i] = getTreeItem(tree[i]);
        }
        return obj;
    }

    private VirtualServerEntity.Tree getTreeItem(Tree tree) {
        if (tree == null)
            return null;

        VirtualServerEntity.Tree obj = new VirtualServerEntity.Tree();
        obj.channel = getChannel(tree.channel);
        obj.children = getTree(tree.children);

        // fill users
        if (tree.users.length > 0) {
            obj.users = new VirtualServerEntity.OnlineUser[tree.users.length];
            for (int i = 0; i < tree.users.length; i++) {
                obj.users[i] = getOnlineUser(tree.users[i]);
            }
        }

        return obj;
    }


    boolean closed = false;

    @Override
    public void close() throws RuntimeException{
        if (!closed) {
            try {
                server.stop();
            } catch (InvalidSecretException e) {
                throw new RuntimeException(e);
            } catch (ServerBootedException e) {
                throw new RuntimeException(e);
            }

            closed = true;
        }
    }
}