package com.example;

public class Child extends Parent {
  private String name = "";
  private int age = 0;

  public Child() {
    // super(123);
    System.out.println("Child constructor");
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
