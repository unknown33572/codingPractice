package com.example.codingPractice_java;

import com.example.codingPractice_java.polymorphism.Child;
import com.example.codingPractice_java.polymorphism.Top;
import com.example.codingPractice_java.polymorphism.Down;
import com.example.codingPractice_java.polymorphism.Parent;

public class Demo {
  public static void main(String[] args) {
    
    //#region Polymorphism example
    /*
     Parent parentClassParentPolymorphism = new Parent();
     Parent parentClassChildPolymorphism = new Child(); // This is polymorphism
     Child childClassChildPolymorphism = new Child(); // Parent 클래스를 상속받고 있기 때문에 생성자를 호출할 때 Parent 클래스의 생성자가 먼저 호출됨.
   
     parentClassParentPolymorphism.setName("John"); // Parent 클래스의 setName 메소드가 호출됨.
     parentClassChildPolymorphism.setName("Bob"); // Child 클래스의 setName 메소드가 호출됨.
     parentClassChildPolymorphism.setAge(10); // This will not work because child is of type Parent
     childClassChildPolymorphism.setName("Alice"); // Child 클래스의 setName 메소드가 호출됨.
     childClassChildPolymorphism.setAge(20);
     System.out.println(parentClassParentPolymorphism.getName()); // Parent 클래스의 getName 메소드가 호출됨.
     System.out.println(parentClassChildPolymorphism.getName()); // Child 클래스의 getName 메소드가 호출됨.
     System.out.println(childClassChildPolymorphism.getName()); // Child 클래스의 getName 메소드가 호출됨.
     // System.out.println(childClassChildPolymorphism.getAge());
     */
    //#endregion
    
    // Down down = new Down();
    // System.out.println(down.getX());

    // System.out.println("====================================");

    // Top down2 = new Down();

    // System.out.println(down2.getX());

    // System.out.println("====================================");

    // Top top = new Top();
    // System.out.println(top.getX());

    // Parent pa = new Child();
    // Parent pb = new Parent();
    Child c = new Child();
    // pa.show();
    // pb.show();
    c.show();
  }
}
