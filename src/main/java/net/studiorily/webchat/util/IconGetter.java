package net.studiorily.webchat.util;

import net.studiorily.webchat.WebChat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

public class IconGetter {
    private static final String WEB_ICON = resisterDefaultIcon("icon/default_web.png");
    private static final String MISSING_ICON = resisterDefaultIcon("icon/default_missing.png");

    private static String resisterDefaultIcon(String path) {
        try {
            InputStream is = WebChat.getPlugin().getResource(path);
            return Base64Encoder.iconAsBase64(Objects.requireNonNull(is).readAllBytes());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPlayerIcon(UUID uuid) {
        try {
            String icon = WebChat.getPlugin().getDataFolder() + "/cache/" + uuid + ".png";
            return Base64Encoder.iconAsBase64(Base64Encoder.fileAsByteArray(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getWebIcon() {
        return WEB_ICON;
    }

    public static String getMissingIcon() {
        return MISSING_ICON;
    }
}
