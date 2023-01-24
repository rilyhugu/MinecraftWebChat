package net.studiorily.webchat.util;

import net.studiorily.webchat.WebChat;
import org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

public class PlayerIconCache implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String path = WebChat.getPlugin().getDataFolder() + "\\cache\\" + player.getUniqueId() + ".png";
        File icon = new File(path);

        if (!icon.exists()) {
            downloadIcon(player.getUniqueId());
        }
    }

    public void downloadIcon(UUID uuid) {
        try {
            URL url = new URL("https://crafatar.com/avatars/" + uuid);
            File path = new File(WebChat.getPlugin().getDataFolder() + "\\cache\\" + uuid + ".png");
            FileUtils.copyURLToFile(url, path);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
