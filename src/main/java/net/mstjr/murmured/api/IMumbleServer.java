package net.mstjr.murmured.api;

import net.mstjr.murmur.proxy.server.channel.Channel;
import net.mstjr.murmur.proxy.server.users.User;

import java.io.Closeable;
import java.util.Map;

public interface IMumbleServer extends Closeable {


    IVirtualServerKeeper getKeeper();

    VirtualServerEntity getEntity();

    boolean isRunning();

    int getOnline();

    int getUptime();

    boolean start();

    boolean stop();

    boolean restart();

    void sendMessage(int sessionId, String text);

    void sendMessageChannel(int channelId, String text, boolean tree);

    default void sendMessageChannel(int channelId, String text) {
        sendMessageChannel(channelId, text, true);
    }

    void setSuperuserPassword(String password);


    String getLog(int lines, boolean format);

    default String getLog(int lines) {
        return getLog(lines, true);
    }


    int getId();

    int getPort();

    void setPort(int port);

    int getSlots();

    void setSlots(int slots);

    String getWelcomeMessage();

    void setWelcomeMessage(String welcomeMessage);

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);

    boolean doesAllowHtml();

    void setAllowHtml(boolean allowHtml);

    int getDefaultChannel();

    void setDefaultChannel(int defaultChannel);

    int getBandwidth();

    void setBandwidth(int bandwidth);

    int getTimeout();

    void setTimeout(int timeout);

    //FIXME: doesn't work
    int getMaxUsersPerChannel();

    void setMaxUsersPerChannel(int maxUsersPerChannel);

    int getMaxTextMessageLength();

    void setMaxTextMessageLength(int maxTextMessageLength);

    String getChannelNameRegex();

    void setChannelNameRegex(String channelNameRegex);

    String getUserNameRegex();

    void setUserNameRegex(String userNameRegex);

    boolean doesRememberChannel();

    void setRememberChannel(boolean rememberChannel);

    boolean doesCertificateRequired();

    void setCertificateRequired(boolean certificateRequired);

    String getCertificate();

    void setCertificate(String certificate);

    String getCertificateKey();

    void setCertificateKey(String certificateKey);

    String getRegisterHostname();

    void setRegisterHostname(String registerHostname);

    String getRegisterUrl();

    void setRegisterUrl(String registerUrl);

    String getRegisterPassword();

    void setRegisterPassword(String registerPassword);

    Map<String, String> getAllConf(boolean getDefault, boolean cache);

    default Map<String, String> getAllConf(boolean getDefault) {
        return getAllConf(getDefault, false);

    }

    default Map<String, String> getAllConf() {
        return getAllConf(true);
    }


    String getConf(String key, boolean getDefault, boolean cache);

    default String getConf(String key, boolean getDefault){
        return getConf(key, getDefault, false);
    }

    default String getConf(String key){
        return getConf(key, true);
    }

    void setConf(String key, String value);

    Map<Integer, VirtualServerEntity.Channel> getAllChannels(boolean getTemporary, boolean getAcl, boolean getInherited, boolean cache);

    default Map<Integer, VirtualServerEntity.Channel> getAllChannels(boolean getTemporary, boolean getAcl, boolean getInherited){
        return getAllChannels(getTemporary, getAcl, getInherited, false);
    }

    default Map<Integer, VirtualServerEntity.Channel> getAllChannels(boolean getTemporary, boolean getAcl){
        return getAllChannels(getTemporary, getAcl, true);
    }

    default Map<Integer, VirtualServerEntity.Channel> getAllChannels(boolean getTemporary){
        return getAllChannels(getTemporary, true);
    }

    default Map<Integer, VirtualServerEntity.Channel> getAllChannels(){
        return getAllChannels(true);
    }

    /**
     * Creates a new channel with the given name and parent channel
     * @param name the name of the new channel
     * @param parentId the parent channel id (0 for root)
     * @return the id of the new channel
     */
    int addChannel(String name, int parentId);

    void updateChannelState(VirtualServerEntity.Channel channel, boolean setAcl);

    default void updateChannelState(VirtualServerEntity.Channel channel){
        updateChannelState(channel, true);
    }

    void removeChannel(int channelId);

    Map<Integer, VirtualServerEntity.OnlineUser> getOnlineUsers(boolean cache);

    default Map<Integer, VirtualServerEntity.OnlineUser> getOnlineUsers() {
        return getOnlineUsers(false);
    }

    VirtualServerEntity.OnlineUser getOnlineUser(User u);


    VirtualServerEntity.Channel getChannel(Channel c);

    Map<Integer, VirtualServerEntity.User> getUsers(boolean getInfo, boolean getTexture, String filter, boolean cache);

    default Map<Integer, VirtualServerEntity.User> getUsers(boolean getInfo, boolean getTexture, String filter) {
        return getUsers(getInfo, getTexture, filter, false);
    }

    default Map<Integer, VirtualServerEntity.User> getUsers(boolean getInfo, boolean getTexture) {
        return getUsers(getInfo, getTexture, null);
    }

    default Map<Integer, VirtualServerEntity.User> getUsers(boolean getInfo) {
        return getUsers(getInfo, false);
    }

    default Map<Integer, VirtualServerEntity.User> getUsers() {
        return getUsers(true);
    }

    VirtualServerEntity.User getUser(int userId, boolean getInfo, boolean getTexture, boolean cache);

    default VirtualServerEntity.User getUser(int userId, boolean getInfo, boolean getTexture) {
        return getUser(userId, getInfo, getTexture, false);
    }

    default VirtualServerEntity.User getUser(int userId, boolean getInfo) {
        return getUser(userId, getInfo, false);
    }

    default VirtualServerEntity.User getUser(int userId) {
        return getUser(userId, true);
    }


    int registerUser(VirtualServerEntity.User user);


    void unregisterUser(int userId);

    void updateUserInfo(VirtualServerEntity.User user);


    void updateUserState(VirtualServerEntity.OnlineUser user);


    void kickUser(int sessionId, String reason);

    Map<Integer, VirtualServerEntity.Ban> getBans(boolean cache);

    default Map<Integer, VirtualServerEntity.Ban> getBans() {
        return getBans(false);
    }

    void setBans(Map<Integer, VirtualServerEntity.Ban> bans);


    VirtualServerEntity.Tree getTree();


}
