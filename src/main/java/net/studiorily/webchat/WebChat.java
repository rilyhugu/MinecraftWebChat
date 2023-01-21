package net.studiorily.webchat;

import net.studiorily.webchat.listener.ChatListener;
import net.studiorily.webchat.util.PlayerIconCache;
import net.studiorily.webchat.websocket.ChatServer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public final class WebChat extends JavaPlugin {
    private static WebSocketServer server;
    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        String host = "localhost";
        int port = 29000;

        server = new ChatServer(new InetSocketAddress(host, port));

        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                server.run();
            }
        });
        serverThread.start();

        Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerIconCache(), this);
    }

    @Override
    public void onDisable() {
    }

    public static WebSocketServer getSocketServer() {
        return server;
    }

    public static Plugin getPlugin() {
        return instance;
    }
}
