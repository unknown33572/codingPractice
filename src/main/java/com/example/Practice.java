package com.example;

import java.util.Arrays;
import java.util.List;

public class Practice {
  public static void main(String[] args) {
    // System.out.println(sumIntegers(Arrays.asList(1, 2, null, 4, null, 16, 7)));
    // System.out.println("=====================================");
    // List<Integer> numbers = Arrays.asList(null, 12, 3, 5, 8);
    List<Integer> numbers = null;
    try {
      int sum = sumIntegers(numbers);
      System.out.println("The sum of the integers is: " + sum);
    } catch (IllegalArgumentException e) {
        System.out.println("꽝");
        System.out.println(e.getMessage());
    }
  }

  public static int sumIntegers(List<Integer> integers) {
    if (integers == null) {
      throw new IllegalArgumentException("List cannot be null");
      // System.out.println("꽝"); // 예외 발생 시 호출스택을 던지기 때문에 이후 코드는 실행되지 않음
    }

    return integers.stream().filter(i -> i != null)
                            .mapToInt(Integer::intValue)
                            .sum();
  }
}
