package solution;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercise10_PrimitiveTypesInPatterns_S {
    private static final int PREMIUM_DISCOUNT_PERCENTAGE = 20;
    private static final int REGULAR_DISCOUNT_PERCENTAGE = 5;

    public static void main() throws IOException, URISyntaxException {
        System.out.println(getHTTPCodeDesc(3));
        System.out.println(getHTTPCodeDesc(100));
        System.out.println(getHTTPCodeDesc(200));
        System.out.println(getHTTPCodeDesc(333));
        System.out.println(getHTTPCodeDesc(500));
        System.out.println("------------------");
        System.out.println(calculateDiscount(true, 232));
        System.out.println(calculateDiscount(false, 232));
    }

    public static String getHTTPCodeDesc(int code) {
        return switch(code) {
            case 100 -> "Continue";
            case 200 -> "OK";
            case 301 -> "Moved Permanently";
            case 302 -> "Found";
            case 400 -> "Bad Request";
            case 500 -> "Internal Server Error";
            case 502 -> "Bad Gateway";
            case int i when i > 100 && i < 200 -> "Informational";
            case int i when i > 200 && i < 300 -> "Successful";
            case int i when i > 302 && i < 400 -> "Redirection";
            case int i when i > 400 && i < 500 -> "Client Error";
            case int i when i > 502 && i < 600 -> "Server Error";
            default                            -> "Unknown error";
        };
    }

    public static int calculateDiscount(boolean isPremiumMember, int totalAmount) {
        return switch (isPremiumMember) {
            case true -> (totalAmount * PREMIUM_DISCOUNT_PERCENTAGE) / 100;
            case false -> (totalAmount * REGULAR_DISCOUNT_PERCENTAGE) / 100;
        };
    }
}
