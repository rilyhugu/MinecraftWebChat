package net.studiorily.webchat.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Base64Encoder {
    public static String iconAsBase64(String path) throws IOException {
        File icon = new File(path);
        byte[] iconByte = FileUtils.readFileToByteArray(icon);
        return Base64.getEncoder().encodeToString(iconByte);
    }
}
