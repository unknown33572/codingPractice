package com.example;

import java.net.InetAddress;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Playground {
  public static void main(String[] args) {
    // Map<String, String> map = new HashMap<>();
    // map.put("postgresql", "localhost:5432");
    // map.put("mysql", "localhost:4321");

    // BiFunction<String, String, String> jdbcUrl = (k, v) -> {
    //   return "jdbc:" + k + "://" + v + "/mydb";
    // };

    // String postgresqlUrl = map.computeIfPresent("postgresql", jdbcUrl);

    // System.out.println(postgresqlUrl);
    // for (int i = 0; i <= 5; i++)  {
    //   for (int j = 0; j < i; j++)  {
    //     System.out.print("*");
    //   }
    //   System.out.println();
    // }

    int n = 5;

    for (int i = 1; i <= n; i++) {
      for (int k = 0; k < n - i; k++) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      for (int q = 1; q < i; q++) {
        System.out.print("*");
      }

      System.out.println();
    }

    for (int i = n - 1; i >= 1; i--) {
      for (int k = 0; k < n - i; k++) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      for (int q = 1; q < i; q++) {
        System.out.print("*");
      }

      System.out.println();
    }

    int x = 13 & 4;

    System.out.println(x);
}

  public static <K, V> Map<K, V> sortKeyStream(Map<K, V> map, Comparator<K> comparator) {
    return map.entrySet()
      .stream()
      .sorted(Map.Entry.comparingByKey(comparator))
      .collect(
        HashMap::new,
        (m, e) -> m.put(e.getKey(), e.getValue()),
        HashMap::putAll
      );
  }
}
