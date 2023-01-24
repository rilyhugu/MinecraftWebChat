package net.studiorily.webchat.util;

import net.studiorily.webchat.WebChat;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

public class IconGetter {
    public static String getPlayerIcon(UUID uuid) {
        return WebChat.getPlugin().getDataFolder() + "/cache/" + uuid + ".png";
    }

    public static String getWebIcon() {
        try {
            InputStream url = WebChat.getPlugin().getResource("icon/default_web.png");
            Bukkit.getLogger().info(url.getPath());
            File file = new File(url.getFile());
            if (file.exists()) {
                return Base64Encoder.iconAsBase64(file);

            } else {
                return null;
            }

        } catch(Exception e) {
            return null;
        }
    }
}
