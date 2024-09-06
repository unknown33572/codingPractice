package com.example.codingPractice_java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CharAndString {
  public static void main(String[] args) {
    for (Map.Entry<Character, Integer> entry : countDuplicateCharactersFirst("Programming").entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    System.out.println("====================================");

    for (Map.Entry<Character, Long> entry : countDuplicateCharactersTwo("Programming").entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    System.out.println("====================================");

    System.out.println(firstNonRepeatedCharacter("Pproograammiinngx"));

    System.out.println("====================================");

    System.out.println(reverseWordsOne("Programming is fun"));
  }

  //#region 중복 문자열 세기
  public static Map<Character, Integer> countDuplicateCharactersFirst(String str) {
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
  //#endregion

  //#region 반복되지 않는 첫 번째 문자 찾기
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
  //#endregion

  //#region 단어 뒤집기
  private static final String WHITESPACE = " ";

  public static String reverseWordsOne(String str) {
    String[] words = str.split(WHITESPACE);
    StringBuilder reversed = new StringBuilder();

    for (String word : words) {
      StringBuilder reverseWord = new StringBuilder();
      // System.out.println(word);
      for (int i = word.length() - 1; i >= 0; i--) {
        reverseWord.append(word.charAt(i));
      }
      System.out.println(reverseWord);
      // reversed.append(reverseWord).append(WHITESPACE);
    }

    return reversed.toString().trim();
  }

  private static final Pattern PATTERN = Pattern.compile(" +");

  public static String reverseWordsTwo(String str) {
    return PATTERN.splitAsStream(str)
        .map(word -> new StringBuilder(word).reverse())
        .collect(Collectors.joining(" "));
  }
  //#endregion

  //#region 숫자만 포함하는지 확인
  public static boolean containsOnlyDigits(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }

    return true;
  }
  //#endregion

  //#region 모음과 자음 세기
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
  //#endregion

  //#region 문자열 중간에 다른 문자열 삽입
  public static String joinByDelimiterOne(char delimiter, String... args) {
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
  //#endregion

  //#region 문자열에서 특정 문자 개수 세기
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
  //#endregion

  //#region 문자열에서 특정 문자열 개수 세기
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
  //#endregion

  //#region anagram 확인
  // public static final int EXTENDED_ASCII_CODES = 256;

  public static boolean isAnagram(String str1, String str2) {
    int[] chCounts = new int[EXTENDED_ASCII_CODES];
    char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
    char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

    if (chStr1.length != chStr2.length) {
      return false;
    }

    for (int i = 0; i < chStr1.length; i++) {
      chCounts[chStr1[i]]++; // chStr1 인덱스에 해당하는 문자의 아스키 코드에 매핑된 인덱스에 1을 더함
      chCounts[chStr2[i]]--; // chStr2 인덱스에 해당하는 문자의 아스키 코드에 매핑된 인덱스에 1을 뺌
    }

    for (int i = 0; i < chCounts.length; i++) {
      if (chCounts[i] != 0) {
        return false;
      }
    }

    return true;
  }
  //#endregion

  //#region 문자열이 반복되는 특정부분 문자열을 가지고 있는지 확인
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
  //#endregion

  
}

class Pair<K, V> {
  public final K first;
  public final V second;

  private Pair(K first, V second) {
    this.first = first;
    this.second = second;
  }

  public static <K, V> Pair<K, V> of(K a, V b) {
    return new Pair<>(a, b);
  }

  public K getKey() {
    return first;
  }

  public V getValue() {
      return second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
}