package Test;

import java.util.*;

public class Test {


    public static void main(String[] args) {


        A a = new B();
        B b = new B();
        a.show(b);


    }

}

class A{
    public void show(A m){
        System.out.println("a and a");
    }
}

class B extends A{

    public void show(A m){
        System.out.println("B and a");
    }
}
