package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Subject {
  public static void main(String[] args) {
    // System.out.println(countStringInString("madmzam", "m"));
    // System.out.println("=====================================");
    // System.out.println(countStringInStringTwo("madmzam", "m"));
    // System.out.println("=====================================");
    // System.out.println(isAnagram("madams", "madam"));
    // System.out.println("=====================================");
    // String[] strs = { "abc", "abcd", "abcde", "ab" };
    // System.out.println(longestCommonPrefix(strs));
    // System.out.println("=====================================");
    // System.out.println(hasOnlySubstrings("abab"));
    // System.out.println("=====================================");
    // System.out.println(factorial(5));
    // System.out.println("=====================================");
    // List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7);
    // System.out.println(evenOddFilterIntegers(numbers, "even"));

    // Player p1 = new Player("madzam", 30);
    // Player p2 = new Player("madzam", 30);

    // String str1 = "madzam";
    // String str2 = "madzam";
    // String str3 = new String("madzam");

    // System.out.println(p1.equals(p2));
    // System.out.println(p1 == p2);

    // System.out.println(str1 == str2);
    // System.out.println(str1.equals(str2));

    // System.out.println(p1.getName() == str1);
    // System.out.println(p1.getName().equals(str2));

    // System.out.println(str1 == str3); // false
    // System.out.println(str1.equals(str3)); // true

    // Down d = new Down();
    // System.out.println(d.getX());

    int[] arr = new int[5];
    int[] arr2 = { 1, 2, 3, 4, 5 };
    int[] arr3 = new int[] { 1, 2, 3, 4, 5 };

    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr3[i]);
    }

    list2.forEach(System.out::println);
  }

  public static int countStringInString(String str, String findStr) {
    int position = 0;
    int count = 0;
    int n = findStr.length();

    while ((position = str.indexOf(findStr, position)) != -1) {
      position += n;
      count++;
    }

    return count;
  }

  public static int countStringInStringTwo(String str, String findStr) {
    int result = str.split(Pattern.quote(findStr), -1).length - 1;
    return result < 0 ? 0 : result;
  }

  public static final int EXTENDED_ASCII_CODES = 256;

  public static boolean isAnagram(String str1, String str2) {
    int[] chCounts = new int[EXTENDED_ASCII_CODES];
    char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
    char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

    if (chStr1.length != chStr2.length) {
      return false;
    }

    for (int i = 0; i < chStr1.length; i++) {
      chCounts[chStr1[i]]++;
      chCounts[chStr2[i]]--;
    }

    for (int i = 0; i < chCounts.length; i++) {
      if (chCounts[i] != 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean hasOnlySubstrings(String str) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length() / 2; i++) {
      sb.append(str.charAt(i));
      String resultStr = str.replaceAll(sb.toString(), "");
      if (resultStr.isEmpty()) {
        return true;
      }
    }

    return false;
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
      return strs[0];
    }

    int firstLen = strs[0].length();

    for (int prefixLen = 0; prefixLen < firstLen; prefixLen++) {
      char ch = strs[0].charAt(prefixLen);

      for (int i = 1; i < strs.length; i++) {
        if (prefixLen >= strs[i].length() || strs[i].charAt(prefixLen) != ch) {
          return strs[i].substring(0, prefixLen);
        }
      }
    }

    return strs[0];
  }

  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7);

  public static List<Integer> evenOddFilterIntegers(List<Integer> numbers, String filter) {
    if (numbers == null) {
      return Collections.EMPTY_LIST;
    }

    List<Integer> results = new ArrayList<>();
    switch (filter) {
      case "even":
        for (Integer number : numbers) {
          if (number != null && number % 2 == 0) {
            results.add(number);
          }
        }
        break;
      case "odd":
        for (Integer number : numbers) {
          if (number != null && number % 2 != 0) {
            results.add(number);
          }
        }
        break;
      default:
        break;
    }

    return results;
  }
}
