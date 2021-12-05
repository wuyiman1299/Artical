 package com.company;

import java.util.Scanner;


public class ArticleMange {
    ArticleSet articleSet = new ArticleSet();

    // 仓库初始化，放入一些商品
    public  void initial() {
        Article xiaomi11 = new Article();
        xiaomi11.setArticle("小米11" , 1999, 30 ,0);

        Article xiaomi11Pro = new Article();
        xiaomi11Pro.setArticle("小米11Pro" , 2999, 10 ,0);

        Article xiaomiUltra = new Article();
        xiaomiUltra.setArticle("小米至尊版",3999,10, 0);


        articleSet.articles[0] = xiaomi11;
        articleSet.articles[1] = xiaomi11Pro;
        articleSet.articles[2] = xiaomiUltra;




    }


    //启动菜单
    public void startMenu() {
        boolean flag = true;
        do {

            System.out.println("*****************");
            System.out.println("1 查看商品信息");
            System.out.println("2 新增商品信息");
            System.out.println("3 删除商品信息");
            System.out.println("4 卖出商品");
            System.out.println("5 商品销售排行榜");
            System.out.println("6 退出");
            System.out.println("*****************");

            System.out.println("请输入功能编号");
            Scanner scanner = new Scanner(System.in);
            int funNo = scanner.nextInt();
            switch (funNo) {
                case 1:
                    System.out.println(" 1 查看商品信息");
                    chakan();
                    break;
                case 2:
                    System.out.println("2 新增商品");
                    add();
                    break;
                case 3:
                    System.out.println("3 删除商品");
                    delete();
                    break;
                case 4:
                    System.out.println("4 卖出商品");
                    saleDot();
                    break;
                case 5:
                    System.out.println("5 商品销售排行榜");
                    leadeBand();
                    break;
                case 6:
                    System.out.println("退出");
                    flag = false;
                    break;
                default:
                    System.out.println("输入的功能编号有误");
                    break;

            }
        }while (flag);


    }

    private void delete() {

            System.out.println("请输入要删除的商品编号");
            Scanner scanner=new Scanner(System.in);
            int bianhao=scanner.nextInt();
            boolean flag =true;
            for (int i=0; i<articleSet.articles.length;i++) {
                if (articleSet.articles[i] != null && (i + 1) == bianhao) {
                    int j = i;
                    while (articleSet.articles[j + 1] != null) {
                        //后面元素向前移动
                        articleSet.articles[j] = articleSet.articles[j + 1];
                        j++;
                    }
                    articleSet.articles[j] = null;
                    flag = true;
                    break; //后门的空数组元素没有必要执行


                } else {
                    flag = false;
                }

            }
        }


    private void add() {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("请输入商品的名称");
        String name = scanner.next();
        System.out.println("请输入价格");
        double price = scanner.nextDouble();
        System.out.println("请输入库存");
        int count = scanner.nextInt();
        System.out.println("请输入一卖的数量");
        int number = scanner.nextInt();

        Article newArticle = new Article();
        newArticle.setArticle(name,price,count,number);

        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i] == null) {
                articleSet.articles[i] = newArticle; // 把新建的对象放在数组中的第一个空位置
                break; // 后续的空位置直接跳过
            }
        }
    }



    private void chakan() {
        System.out.println("编号  \t  名字  \t 单价 \t 库存  \t  已卖 \t  ");
        for (int i=0; i<articleSet.articles.length;i++){
            if (articleSet.articles[i]!=null) {
                articleSet.articles[i].print(i+1);
            }
        }
    }

    private void leadeBand() {
        for(int i=0; i<articleSet.articles.length-1;i++){
            for(int j=0; j<articleSet.articles.length-i-1;j++){
                if(articleSet.articles[j]!=null&&articleSet.articles[j+1]!=null){//数组中不为空才能参与
                    if(articleSet.articles[j].number<articleSet.articles[j+1].number){
                        Article newTemp=articleSet.articles[j];
                        articleSet.articles[j]=articleSet.articles[j+1];
                        articleSet.articles[j+1]=newTemp;
                    }
                }
            }
        }
    }

    private void saleDot() {
        System.out.println("请输入要销售的商品名称");
        Scanner  scanner=new Scanner(System.in);
        String  mingzi=scanner.next();
        for(int i=0;i<articleSet.articles.length;i++){
            if(articleSet.articles[i]!=null&&articleSet.articles[i].name==mingzi){
                System.out.println("请输入卖出数量");
                int shuliang=scanner.nextInt();
                if(shuliang<articleSet.articles[i].amount){
                    articleSet.articles[i].amount=articleSet.articles[i].amount-shuliang;
                    articleSet.articles[i].number=articleSet.articles[i].number+shuliang;
                    System.out.println("成功售出");
                    break;
                }
            }
        }
    }

}

  

    