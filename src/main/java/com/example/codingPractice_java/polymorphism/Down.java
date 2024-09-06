package com.example.codingPractice_java.polymorphism;

public class Down extends Top {
  int x = 1000;

  public Down() {
    this(5000);
  }

  public Down(int x) {
    System.out.println("Down Constructor with x");
    this.x = x;
  }

  public int getX() {
    return x;
  }
}
