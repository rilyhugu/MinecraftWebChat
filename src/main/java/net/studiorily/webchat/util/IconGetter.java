package net.studiorily.webchat.util;

import net.studiorily.webchat.WebChat;

import java.io.IOException;
import java.util.UUID;

public class IconGetter {
    public static String getPlayerIcon(UUID uuid) {
        return WebChat.getPlugin().getDataFolder() + "\\cache\\" + uuid + ".png";
    }

    public static String getWebIcon() {
        String path = "/icon/default_web.png";

    }
}
