package net.studiorily.webchat.listener;

import net.studiorily.webchat.WebChat;
import net.studiorily.webchat.util.Base64Encoder;
import net.studiorily.webchat.util.IconGetter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;

public class ChatListener implements Listener {
    @EventHandler
    public void playerChatEvent(AsyncPlayerChatEvent event) {
        try {
            Player player = event.getPlayer();
            String path = IconGetter.getPlayerIcon(player.getUniqueId());
            String icon = Base64Encoder.iconAsBase64(path);

            String json = String.format("""
                    {"type": "message",
                     "player": "%s",
                     "icon": "%s",
                     "message": "%s"}
                    """, player.getName(), icon, event.getMessage());

            WebChat.getSocketServer().broadcast(json);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
