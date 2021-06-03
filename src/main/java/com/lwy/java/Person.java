package com.lwy.java;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
public class Person {
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(name);   //name 每变一次 hash值就变一次 所以尽量不要用可变值当作hash
    }
}
class Test{
    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        Person person = new Person("张三");
        System.out.println(person.hashCode());    //第一次hash
        persons.add(person);
        person.setName("李四");
        System.out.println(person.hashCode());     //第二次hash
        persons.forEach(System.out::println);
        System.out.println(persons.contains(person));    //这里set 的contains 用的是 hashmap 的 底层比较的是hash值想不想同 所以返回了 false
    }
}
