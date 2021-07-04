package com.lwy.java;
/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/7/4 11:05
 *  String类型 Intern()方法的学习
 *              String intern() {
             *      if(常量池找到该字面量的字符串) ｛
             *          return 常量池该字面量的字符串
             *     ｝
             *     if（常量池已经记录字符串字面量相等的引用） ｛
             *         return A
             *    ｝
             *     记录 堆上第一个与该字符串字面量相等的引用
             *     return 记录的引用
 *              }
  * @Param: null
 * @return
 */
public class StringInternStudy {
    public static void main(String[] args) {
        // 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定）
        // ，则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用。
        // 说白了就是保证String s 指向的是字符串常量池中的数据 节约内存


        //没有接收返回值就是在常量池创建独对象
        //有接收返回值是指向第一次的引用



        //单独执行intern : 无论怎么比较 intern() 前面常量池里有这个字符串就是 false 没有就是true
        String i1 = new String("hello") + new String("word");   //这种不会添加到字符串常量池
        String i2 = "helloword";
        i1.intern(); //常量池中有了 相当于啥也没做
        System.out.println(i1 == i2);       //false   i1 指向堆  i2 指向 常量池

        String i3 = new String("s")+new String("b");   //这种不会添加到字符串常量池
        i3.intern();    //这一步添加到常量池  让 i3指向到常量池中
        String i4 = "sb";    //常量池中有了 指向和 i3一样了
        System.out.println(i3 == i4);     //true i3 i4 都指向常量池中

        String m1 = new String("m");
        m1.intern();    //常量池中有了 相当于啥也没做
        String m2 = "m";
        System.out.println(m1 == m2);   //false



        //再输出比较Intern 除了之前有的比如 java 剩下的都是true
        String i5 = new String("liu")+new String("weiyi");    //这种不会添加到字符串常量池
        String i6 = "liuweiyi";
        System.out.println(i5.intern() == i6);    //true  常量池里有 返回的就是 i6 所以相等
        System.out.println(i5.intern() == i5);   //false 常量池里有了 返回的是i6 不是 i5自己








    }
}
