package leetcode.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DesignTinyUrl {
    Map<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String encoded = "https:" + "//" + "tinyurl.com/" + shorten(longUrl);
        map.put(encoded, longUrl);

        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    private String shorten(String url) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;

    }

    public static void main(String[] args) {
        DesignTinyUrl designTinyUrl = new DesignTinyUrl();
        String encoded = designTinyUrl.encode("https://www.lintcode.com/problem/215/?showListFe=true&page=1&problemTypeId=12&pageSize=50");
        System.out.println(encoded);
        System.out.println(designTinyUrl.decode(encoded));
        char[][] board = new char[3][3];
        System.out.println(board[0][0]);

    }
}
