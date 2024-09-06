package com.example.codingPractice_java.polymorphism;

public class Parent {
  public Parent() {
    System.out.println("Parent constructor");
  }
  public Parent(int x) {
    System.out.println("Parent constructor with x" + x);
  }

  public void setName(String name) {
    System.out.println("Parent setName");
  }

  public String getName() {
    return "Parent getName";
  }
}
