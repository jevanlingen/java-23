import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Task 1: Rewrite `getHTTPCodeDesc` with pattern matching
// Task 2: Rewrite `calculateDiscount` with pattern matching

public class Exercise10_PrimitiveTypesInPatterns {
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
        if (code == 100) {
            return "Continue";
        }
        else if (code == 200) {
            return "OK";
        }
        else if (code == 301) {
            return "Moved permanently";
        }
        else if (code == 302) {
            return "Found";
        }
        else if (code == 400) {
            return "Bad request";
        }
        else if (code == 500) {
            return "Internal server error";
        }
        else if (code == 502) {
            return "Bad gateway";
        }
        else if (code > 100 && code < 200) {
            return "Informational";
        }
        else if (code > 200 && code < 300) {
            return "Successful";
        }
        else if (code > 302 && code < 400) {
            return "Redirection";
        }
        else if (code > 400 && code < 500) {
            return "Client error";
        }
        else if (code > 502 && code < 600) {
            return "Server error";
        }
        else {
            return "Unknown error";
        }
    }

    public static int calculateDiscount(boolean isPremiumMember, int totalAmount) {
        int discount;
        if (isPremiumMember) {
            // Calculate discount for premium members
            discount = (totalAmount * PREMIUM_DISCOUNT_PERCENTAGE) / 100;
        } else {
            // Calculate discount for regular members
            discount = (totalAmount * REGULAR_DISCOUNT_PERCENTAGE) / 100;
        }
        return discount;
    }
}
