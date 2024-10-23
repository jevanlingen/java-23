package model;

import java.util.Arrays;

public enum Animal {
   SHEEP, SHEEP_DOG, WOLF;

   public static boolean match(final String s) {
      return Arrays.stream(Animal.values())
              .anyMatch(it -> ignoreSpecialChars(s.replace(" ", "")).equalsIgnoreCase(ignoreSpecialChars(it.name())));
   }

   private static String ignoreSpecialChars(final String s) {
      return s.replace("_","").replace("-", "");
   }
}
