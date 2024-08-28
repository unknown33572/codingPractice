package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Play {
  public static void main(String[] args) {
    // permuteAndPrint("", "abc");
    // System.out.println("=====================================");
    // permuteAndPrintStream("", "def");
    // System.out.println("=====================================");
    // System.out.println(isPalindrome("madzam"));
    // System.out.println("=====================================");
    // System.out.println(isPalindromeCount("madzam"));
    // System.out.println("=====================================");
    // System.out.println(removeCharacter("madzam", 'm'));
    System.out.println("=====================================");
    System.out.println(maxOccurenceCharacter("madzamm"));
    System.out.println("=====================================");
    String[] strs = { "madzammmm", "madzamz", "madzamza" };
    sortArrayByLength(strs, Sort.ASC);
    System.out.println(Arrays.toString(strs));
  }

  private static void permuteAndPrint(String prefix, String str) {
    int n = str.length();
    if (n == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        permuteAndPrint(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
      }
    }
  }

  private static void permuteAndPrintStream(String prefix, String str) {
    int n = str.length();

    if (n == 0) {
      System.out.println(prefix + " ");
    } else {
      IntStream.range(0, n).parallel()
          .forEach((i -> permuteAndPrint(prefix + str.charAt(i),
              str.substring(0, i) + str.substring(i + 1, n))));
    }
  }

  private static boolean isPalindrome(String str) {
    // return str.equals(new StringBuilder(str).reverse().toString());
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  private static int isPalindromeCount(String str) {
    int count = 0;
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (str.charAt(left) == str.charAt(right)) {
        count++;
      }
      left++;
      right--;
    }

    return count;
  }

  private static String removeDuplicates(String str) {
    // return str.chars().distinct().collect(StringBuilder::new,
    // StringBuilder::appendCodePoint, StringBuilder::append)
    // .toString();

    char[] chArray = str.toCharArray();
    StringBuilder sb = new StringBuilder();

    for (char ch : chArray) {
      if (sb.indexOf(String.valueOf(ch)) == -1) {
        sb.append(ch);
      }
    }
  }

  private static String removeCharacter(String str, char ch) {
    return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
  }

  private static String removeCharacterTwo(String str, char ch) {
    StringBuilder sb = new StringBuilder();
    char[] chArray = str.toCharArray();

    for (char c : chArray) {
      if (c != ch) {
        sb.append(c);
      }
    }

    return sb.toString();
  }

  private static Pair<Character, Integer> maxOccurenceCharacter(String str) {
    Map<Character, Integer> map = new HashMap<>();
    char[] chStr = str.toCharArray();

    for (int i = 0; i < chStr.length; i++) {
      char currCh = chStr[i];

      if (!Character.isWhitespace(currCh)) {
        Integer noCh = map.get(currCh);

        if (noCh == null) {
          map.put(currCh, 1);
        } else {
          map.put(currCh, ++noCh);
        }
      }
    }

    int maxCount = Collections.max(map.values());
    char maxChar = Character.MIN_VALUE;

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxCount) {
        maxChar = entry.getKey();
      }
    }

    Pair<Character, Integer> pair = Pair.of(maxChar, maxCount);
    return pair;
  }

  public static void sortArrayByLength(String[] strs, Sort direction) {
    if (direction.equals(Sort.ASC)) {
      Arrays.sort(strs, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
    } else {
      Arrays.sort(strs, (String s1, String s2) -> (-1) * Integer.compare(s2.length(), s1.length()));
    }
  }

  public static String[] sortArrayByLengthTwo(String[] strs, Sort direction) {
    if (direction.equals(Sort.ASC)) {
      return Arrays.stream(strs).sorted(Comparator.comparingInt(String::length))
                                .toArray(String[]::new);
    } else {
      return Arrays.stream(strs).sorted(Comparator.comparingInt(String::length).reversed())
                                .toArray(String[]::new);
    }
  }

  public static boolean contains(String text, String subText) {
    return text.indexOf(subText) != -1;
  }

  public static int countOccurrContains(String text, String subText) {
    int count = 0;
    int index = 0;

    while ((index = text.indexOf(subText, index)) != -1) {
      count++;
      index += subText.length();
    }

    return count;
  }
}
