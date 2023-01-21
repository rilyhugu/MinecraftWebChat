package net.studiorily.webchat.websocket;

import org.bukkit.Bukkit;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class ChatServer extends WebSocketServer {

    public ChatServer(InetSocketAddress address) {
        super(address);
    }


    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!");
        broadcast( "new connection: " + handshake.getResourceDescriptor() );
        Bukkit.getLogger().info("new connection to " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        Bukkit.getLogger().info("closed " + conn.getRemoteSocketAddress() + " with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        Bukkit.broadcastMessage("§f<§bWebChat§f> " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        Bukkit.getLogger().info("an error occurred on connection " + conn.getRemoteSocketAddress()  + ":" + ex);
    }

    @Override
    public void onStart() {
        Bukkit.getLogger().info("server started successfully");
    }
}
