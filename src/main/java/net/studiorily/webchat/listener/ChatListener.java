package net.studiorily.webchat.listener;

import net.studiorily.webchat.WebChat;
import net.studiorily.webchat.util.IconGetter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void playerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String icon = IconGetter.getPlayerIcon(player.getUniqueId());

        String json = String.format("""
                {"type": "message",
                 "player": "%s",
                 "icon": "%s",
                 "message": "%s"}
                """, player.getName(), icon, event.getMessage());

        WebChat.getSocketServer().broadcast(json);
    }
}
