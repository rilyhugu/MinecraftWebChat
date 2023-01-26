package net.studiorily.webchat.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Base64Encoder {
    public static String iconAsBase64(byte[] byteArray){
        return Base64.getEncoder().encodeToString(byteArray);
    }

    public static byte[] fileAsByteArray(String path) throws IOException {
        return FileUtils.readFileToByteArray(new File(path));
    }
}
