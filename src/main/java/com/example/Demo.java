package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
  public static void main(String[] args) {
    // Parent child = new Child();
    // Child child2 = new Child();

    // child.setName("John");
    // child.setAge(10); // This will not work because child is of type Parent
    // child2.setName("Alice");
    // child2.setAge(20);
    // System.out.println(child.getName());
    // System.out.println(child2.getName());
    // System.out.println(child2.getAge());

    // for (Map.Entry<Character, Integer> entry :
    // countDuplicateCharacters("Programming").entrySet()) {
    // System.out.println(entry.getKey() + ": " + entry.getValue());
    // }

    // System.out.println(firstNonRepeatedCharacter("Pprogramming"));

    // System.out.println(reverseWords("Programming is fun"));

    // System.out.println(containsOnlyDigits("가45"));

    // System.out.println(reverseWordsTwo("Programming is fun"));

    // Pair<Integer, Integer> result = countVowelsAndConsonants("Programming is
    // fun");

    // System.out.println("Vowels: " + result.first);
    // System.out.println("Consonants: " + result.second);

    String x = joinByDelimiter('/', "JavaProgramming", "is", "fun");
    System.out.println(x);

    String y = joinByDelimiterTwo('/', "PythonProgramming", "is", "fun");
    System.out.println(y);
  }

  public static Map<Character, Integer> countDuplicateCharacters(String str) {
    Map<Character, Integer> result = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      result.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);
    }

    return result;
  }

  public static Map<Character, Long> countDuplicateCharactersTwo(String str) {
    Map<Character, Long> result = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    return result;
  }

  private static final int EXTENDED_ASCII_CODES = 256;

  public static char firstNonRepeatedCharacter(String str) {
    int[] flags = new int[EXTENDED_ASCII_CODES];
    str = str.toLowerCase();

    for (int i = 0; i < flags.length; i++) {
      flags[i] = -1;
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (flags[ch] == -1) {
        flags[ch] = i;
      } else {
        flags[ch] = -2;
      }
    }

    int position = Integer.MAX_VALUE;

    for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
      if (flags[i] >= 0) {
        position = Math.min(position, flags[i]);
      }
    }

    return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
  }

  private static final String WHITESPACE = " ";

  public static String reverseWords(String str) {
    String[] words = str.split(WHITESPACE);
    StringBuilder reversed = new StringBuilder();

    for (String word : words) {
      StringBuilder reverseWord = new StringBuilder();
      System.out.println(word);
      for (int i = word.length() - 1; i >= 0; i--) {
        reverseWord.append(word.charAt(i));
      }
      System.out.println(reverseWord);
      // reversed.append(reverseWord).append(WHITESPACE);
    }

    return reversed.toString().trim();
  }

  public static boolean containsOnlyDigits(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  private static final Pattern PATTERN = Pattern.compile(" +");

  public static String reverseWordsTwo(String str) {
    return PATTERN.splitAsStream(str)
        .map(word -> new StringBuilder(word).reverse())
        .collect(Collectors.joining(" "));
  }

  private static final Set<Character> allVowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public static Pair<Integer, Integer> countVowelsAndConsonants(String str) {
    str = str.toLowerCase();
    int vowels = 0;
    int consonants = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (allVowels.contains(ch)) {
        vowels++;
      } else if ((ch >= 'a' && ch <= 'z')) {
        consonants++;
      }
    }

    return Pair.of(vowels, consonants);
  }

  public static int countOccurrencesOfACertainCharacter(String str, char ch) {
    return str.length() - str.replace(String.valueOf(ch), "").length();
  }

  public static int countOccurrencesOfACertainCharacterTwo(String str, char ch) {
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ch) {
        count++;
      }
    }

    return count;
  }

  public static long countOccurrencesOfACertainCharacterThree(String str, char ch) {
    return str.chars().filter(c -> c == ch).count();
  }

  public static String joinByDelimiter(char delimiter, String... args) {
    StringBuilder result = new StringBuilder();

    int i = 0;
    for (i = 0; i < args.length - 1; i++) {
      result.append(args[i]).append(delimiter);
    }

    result.append(args[i]);

    return result.toString();
  }

  public static String joinByDelimiterTwo(char delimiter, String... args) {
    return Arrays.stream(args, 0, args.length).collect(Collectors.joining(String.valueOf(delimiter)));
  }

}

class Pair<U, V> {
  public final U first;
  public final V second;

  private Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }

  public static <U, V> Pair<U, V> of(U a, V b) {
    return new Pair<>(a, b);
  }
}
