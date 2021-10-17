package Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class T2 {



//    public static void main(String[] args) throws Exception {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入学科");
//        String s1 = scanner.nextLine();
//        int flag = 0;
//        double all = 0;
//        if(s1.equals("英语")){
//            flag = 2;
//        }
//        if(s1.equals("数学")){
//            flag = 3;
//        }
//        if(s1.equals("Java")){
//            flag = 4;
//        }
//        BufferedReader a=new BufferedReader(new FileReader("d:\\Java\\考试成绩.txt"));
//        while(true){
//            String s = a.readLine();
//            if (!(s != null)) break;
//            String[] split = s.split("\\s+");
//            if(!split[flag].equals(s1) ){
//                String cj = split[flag];
//                double v = Double.parseDouble(cj);
//                all += v;
//            }
//        }
//
//        System.out.println("平均成绩是"+all/6);
//
//        BufferedReader b=new BufferedReader(new FileReader("d:\\Java\\考试成绩.txt"));
//        while(true){
//            String s = b.readLine();
//            if (!(s != null)) break;
//            String[] split = s.split("\\s+");
//            if(!split[flag].equals(s1)){
//                String cj = split[flag];
//                double v = Double.parseDouble(cj);
//                if(v < all/6){
//                    System.out.println("此学生低于平均成绩"+split[0]+"成绩是"+split[flag]);
//                }
//            }
//        }
//
//        a.close();
//        b.close();
//
//    }




//    public static void main(String[] args) throws Exception {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入学号");
//        String s1 = scanner.nextLine();
//
//        BufferedReader a=new BufferedReader(new FileReader("d:\\Java\\考试成绩.txt"));
//        while(true){
//            String s = a.readLine();
//            if (!(s != null)) break;
//            if(s.contains(s1)){
//                System.out.println(s);
//            }
//        }
//
//    }




        static Connection connection;
        static PreparedStatement preparedStatement;
        public static void main(String[] args) throws SQLException {
                ThreadLocal local = new ThreadLocal();
                local.set(1);
//
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stuscore?characterEncoding=UTF-8","root",
//                        "root");
//                preparedStatement = connection.prepareStatement("insert into info(name,num,sex,telephone) values(?,?,?,?) ");
//                preparedStatement.setObject(1,"董世苹");
//                preparedStatement.setObject(2,"1921540205");
//                preparedStatement.setObject(3,"女");
//                preparedStatement.setObject(4,"15304180513");
//                preparedStatement.executeUpdate();
//
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            finally {
//                preparedStatement.close();
//                connection.close();
//            }
//
//            HashMap map = new HashMap();
//            map.put(1,1);



            // new a / new b /  stringbuffer / 常量池a / 常量池b / String a b
//            StringBuilder B;
//            String s = new String("a")+new String("b");
//            s.intern();
//            String b = "ab";
//            System.out.println(b == s);
//
//
//            ArrayList a = new ArrayList(8);
//            a.add(1);
//            System.out.println(a.size());
//
//            HashMap map = new HashMap(10);
//
//            map.size();
//            map.put(1,1);

            System.out.println(tableSizeFor(10));

        }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }


//
//
//        static Connection connection;
//        static PreparedStatement preparedStatement;
//        public static void main(String[] args) throws SQLException {
//
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stuscore?characterEncoding=UTF-8","root",
//                        "root");
//                preparedStatement = connection.prepareStatement("select * from info where num = ?");
//                preparedStatement.setObject(1,"1921540205");
//
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()){
//                    System.out.println("id"+resultSet.getObject("id"));
//                    System.out.println("name"+resultSet.getObject("name"));
//                    System.out.println("num"+resultSet.getObject("num"));
//                    System.out.println("sex"+resultSet.getObject("sex"));
//                    System.out.println("telephone"+resultSet.getObject("telephone"));
//                }
//                resultSet.close();
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            finally {
//
//                preparedStatement.close();
//                connection.close();
//            }
//
//        }




}
