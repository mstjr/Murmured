# Murmur Ice Wrapper for Java

This is a Java wrapper for the Mumble server using the Ice middleware.

## Obtaining

You can obtain the Murmur Ice Wrapper for Java in two ways:

- **Download Jar File**: You can download the JAR file directly from the repository.
- **Maven Local Downloader**: If you are using Maven, you can add the wrapper as a dependency in your project.

## Usage Example

Here is an example of how to use the Murmur Ice Wrapper for Java in your code:

```java
try (MumbleProxy proxy = new MumbleProxy()) {
    proxy.connect("127.0.0.1", 6502, "secret");

    int users = 0;
    for (IMumbleServer value : proxy.getAllServers().values()) {
        users += value.getOnlineUsers().size();
    }

    System.out.println("Users: " + users);
} catch (InvalidSecretException e) {
    System.out.println("Wrong secret");
}
```

Make sure to replace **`"127.0.0.1"`**, **`6502`**, and **`"secret"`** with the actual server address, port, and secret.

##Documentation

For more information and detailed documentation, please visit our [wiki](https://github.com/mstjr/Murmured/wiki)https://github.com/mstjr/Murmured/wiki
