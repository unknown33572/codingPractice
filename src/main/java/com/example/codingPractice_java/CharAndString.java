package com.example.codingPractice_java;

import java.util.HashMap;
import java.util.Map;

public class CharAndString {
  public static void main(String[] args) {
    for (Map.Entry<Character, Integer> entry : countDuplicateCharacters("Programming").entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
  
  public static Map<Character, Integer> countDuplicateCharacters(String str) {
    Map<Character, Integer> result = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      result.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);
    }

    return result;
  }
}
