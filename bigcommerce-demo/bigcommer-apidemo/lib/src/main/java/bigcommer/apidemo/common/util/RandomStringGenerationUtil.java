package bigcommer.apidemo.common.util;

import java.util.Random;

public class RandomStringGenerationUtil {
    public static String generateASCIIString(int length) {
    	Random random = new Random();
    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}
