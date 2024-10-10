package com.example.codingPractice_java.polymorphism;

public class Top {
  int x = 100;

  public Top() {
    this(500);
  }

  public Top(int x) {
    System.out.println("Top Constructor with x");
    this.x = x;
    System.out.println("x = " + x);
  }

  public int getX() {
    return x;
  } 
}
