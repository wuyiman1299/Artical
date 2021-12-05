package com.company;
/**
 * 商品类
 * */

public class Article {

        // 名字 单价 库存 一卖数量
        public String name;
        public double price;
        public int amount;
        public int number;

        public void print( int index ) {
            System.out.println(index +"\t" + name +"\t" + price +"\t" + amount +"\t" + number);
        }

        public void setArticle(String mingzi , double danjia , int kucun, int yishou) {
            name = mingzi;
            price = danjia;
            amount = kucun;
            number = yishou;
        }
    }


