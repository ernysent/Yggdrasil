package com.github.ernysent.yggdrasil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     ProdCalc prodCalc = new ProdCalc();

    start();
    Scanner scanner = new Scanner(System.in);
    int box = scanner.nextInt();
    int meters = prodCalc.calcMeters(box);
    int board = prodCalc.calcBoard(box);

    double remains = prodCalc.calcRemains(box,board);
    Section1(box,meters,board,remains);
    double sumdye = prodCalc.calcPaint(box);
    section2(sumdye);
    double collect = prodCalc.calcCollector(box);
    double paint = prodCalc.calcPainters(box);
    section3(collect,paint);
    //boxx();
    }
    static void start(){
        System.out.println("Приветик;)\nВы открыли программу для подсчёта материалов и рабочих.\nВедите сколько хотите сделать ящиков?");
    }

    static void Section1(int box,int metrs,int board, double remains){
        System.out.println("Для "+box+" ящиков нам понадобится:  \n" +
            "метров досок: "+metrs+" м.\n" +
            "количество досок: "+board+" шт.\n" +
            "остаток от досок: "+remains+" м.");
    }

    static void section2(double sumdye){
        System.out.print("количество краски: ");
        System.out.format("%.3f",sumdye);
        System.out.println(" кг.\n");
    }


    static void section3(double collect,double paint){
        System.out.format("Сборщиков: "+"%.0f",collect);
        System.out.format("\nМаляров: "+"%.0f",paint);
    }
}
//    static void boxx() {
//        Scanner scanner = new Scanner(System.in);
//        int box = scanner.nextInt();
//        int metrs = box*5;
//        int board = (box*5+1)/2;
//        double remains =board%2+0.4*box;
//
//        System.out.println("Для "+box+" ящиков нам понадобится:  \n" +
//                "метров досок: "+metrs+" м.\n" +
//                "количество досок: "+board+" шт.\n" +
//                "остаток от досок: "+remains+" м.");
//
//        double squa = (0.5*0.4)*4+(0.4*0.4)*2;
//        double dye = 0.1;
//        double sumdye = squa*box*dye;
//
//        System.out.print("количество краски: ");
//        System.out.format("%.3f",sumdye);
//        System.out.println(" кг.\n");
//    }