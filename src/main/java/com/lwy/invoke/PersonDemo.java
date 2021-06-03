package com.lwy.invoke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
//@EqualsAndHashCode
public class PersonDemo {
    private String name;

}
class Test{
    public static void main(String[] args) {
        Set<PersonDemo> persons = new HashSet<>();
        PersonDemo person = new PersonDemo("张三");
        persons.add(person);
        person.setName("李四");
        persons.forEach(System.out::println);
        System.out.println(persons.contains(person));
    }
}
// 下面程序中，jvm在进行过一次Minor GC后，上述代码在年轻代内存中保留的字符个数：
// public class NowCoder {
//    public static void main(String[] args) {
//         String str1="abcde";
//         String str2= str1.substring (4);
//         String str3=new String (str2);
//         String str4=new String (str2.toCharArray ());
//    }
//}