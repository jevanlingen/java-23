package solution;

import java.io.IOException;
import java.net.URISyntaxException;

public class Exercise10_PrimitiveTypesInPatterns_S {
    public static void main() throws IOException, URISyntaxException {
        System.out.println(getHTTPCodeDesc(3));
        System.out.println(getHTTPCodeDesc(100));
        System.out.println(getHTTPCodeDesc(200));
        System.out.println(getHTTPCodeDesc(333));
        System.out.println(getHTTPCodeDesc(500));
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
}
