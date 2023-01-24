package net.studiorily.webchat.util;

import net.studiorily.webchat.WebChat;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

public class IconGetter {
    public static String getPlayerIcon(UUID uuid) {
        return WebChat.getPlugin().getDataFolder() + "\\cache\\" + uuid + ".png";
    }

    public static String getWebIcon() {
        try {
            URL url = WebChat.getPlugin().getClass().getResource("\\resources\\icon\\default_web.png");
            File file = new File(Objects.requireNonNull(url).getFile());

            if (file.exists()) {
                return Base64Encoder.iconAsBase64(file.getPath());

            } else {
                return null;
            }

        } catch(Exception e) {
            return null;
        }
    }
}
