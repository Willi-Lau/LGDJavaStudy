package com.lwy.ldh;

public class Test01 {

    public static void main(String[] args) {
        Science_book bb=new Science_book(530,0.7f);
        bb.price = (int)bb.getPrice(530,0.7f);
        bb.show_kind();
        bb.show_price();
        Literature_book ll=new Literature_book(480,0.9f);
        ll.price=(int)ll.getPrice(480,0.9f);
        ll.show_kind();
        ll.show_price();
        Literature_book.Teaching_book tt= new Literature_book.Teaching_book(300,0.7f);
        tt.price=(int)tt.getPrice(300,0.7f);
        tt.show_kind();
        tt.show_price();
    }


}

class Science_book implements Book
{
    int bookPage;
    float discount;
    double price;
    public Science_book(int bookPage,float discount)
    {
        this.bookPage=bookPage;
        this.discount=discount;
    }
    public void show_kind()
    {
        System.out.println("这个书的种类是科学类。");
    }
    public double getPrice(int bookPage,float discount)
    {
        return bookPage*0.1*discount;
    }
    public void show_price()
    {
        System.out.println("这本书的价格是："+price);
    }
}
class Literature_book implements Book
{

    int bookPage;
    float discount;
    double price;
    public Literature_book(int bookPage,float discount)
    {
        this.bookPage=bookPage;
        this.discount=discount;
    }
    public void show_kind()
    {
        System.out.println("这个书的种类是自然类。");
    }
    public double getPrice(int bookPage,float discount)
    {
        return bookPage*0.08*discount;
    }
    public void show_price()
    {
        System.out.println("这本书的价格是："+price);
    }
    static class Teaching_book implements Book
    {
        int bookPage;
        float discount;
        double price;
        public Teaching_book(int bookPage,float discount)
        {
            this.bookPage=bookPage;
            this.discount=discount;
        }
        public void show_kind()
        {
            System.out.println("这个书的种类是教材。");
        }
        public double getPrice(int bookPage,float discount)
        {
            return bookPage*0.05*discount;
        }
        public void show_price()
        {
            System.out.println("这本书的价格是："+price);
        }
    }
}