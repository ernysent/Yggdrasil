package com.github.ernysent.yggdrasil;

import java.util.Scanner;

public class ProdCalc {

    public static int calcMeters(int box) {
        int metrs = box*5;
        return metrs;
    }
    static int calcBoard(int box) {
        int board = (box*5+1)/2;
        return board;
    }
    static double calcRemains(int box,int board) {
        double remains =board%2+0.4*box;
        return remains;
    }

    static double calcPaint(int box) {
        double squa = (0.5*0.4)*4+(0.4*0.4)*2;
        double dye = 0.1;
        double sumdye = squa*box*dye;
        return sumdye;
    }

    static double calcCollector(int box){
        double collector = 40;
        double collect = Math.ceil(box/collector);
        return collect;
        // Round Up
        // (Double)Math.ceil(a/100);
    }
    static double calcPainters(int box){
        double painter = 64;
        double paint = Math.ceil(box/painter);
        return  paint;
        // Round Up
        // (Double)Math.ceil(a/100);
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