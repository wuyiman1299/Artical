/**
 * 商品数量
 * 自定义类 Articl
 * */


public class Artical {
    // 名字 单价 库存 一卖数量
    public String name;
    public double price;
    public int amount;
    public int number;

    public void print( int index ) {
        System.out.println(index +"\t" + name +"\t" + price +"\t" + amount +"\t" + number);
    }
}
