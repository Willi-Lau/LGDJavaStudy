package Test;

import java.util.*;

public class Test {


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1","www");
        map.put("2","yyy");
        map.forEach((x,y)->{
            System.out.println(x);
            System.out.println(y);
        });

        Integer i= 128;
        Integer j = 128;
        Integer m= 127;
        Integer n = 127;
        System.out.println(i==j);
        System.out.println(m==n);




    }

}
