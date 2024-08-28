package com.example;

public class Down extends Top {
  int x = 4000;

  Down() {
    this(5000);
  }

  Down(int x) {
    System.out.println("Down Constructor with x");
    this.x = x;
  }
  
}
