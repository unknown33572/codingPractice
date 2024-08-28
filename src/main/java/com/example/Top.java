package com.example;

public class Top {
  int x = 100;

  Top() {
    this(500);
  }

  Top(int x) {
    System.out.println("Top Constructor with x");
    this.x = x;
  }

  int getX() {
    return x;
  }
  
}
