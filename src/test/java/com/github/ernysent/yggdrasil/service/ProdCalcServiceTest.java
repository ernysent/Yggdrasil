package com.github.ernysent.yggdrasil.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProdCalcServiceTest extends Assertions {

    @Test
    void calcMeters() {
        int box = 1;
        int metrs = ProdCalcService.calcMeters(box);
        assertEquals(5, metrs);
        System.out.println("5: "+ metrs);
    }

    @Test
    void calcBoard() {
        int box = 1;
        int board = ProdCalcService.calcBoard(box);
        assertEquals(3, board);
        System.out.println("Board 3:"+board);
    }

    @Test
    void calcRemains() {
        int box = 1;
        int board = 3;
        double remains = ProdCalcService.calcRemains(box,board);
        assertEquals(1.4, remains);
        System.out.println("1.4: "+ remains);
    }

    @Test
    void calcPaint() {
        int box = 1;
        double sumdye = ProdCalcService.calcPaint(box);
        assertEquals(1, sumdye);
        System.out.println("1: "+sumdye);
    }

    @Test
    void calcCollector() {
        int box = 81;
        double collect = ProdCalcService.calcCollector(box);
        assertEquals(3, collect);
        System.out.println("3: "+collect);
    }

    @Test
    void calcPainters() {
        int box = 129;
        double paint = ProdCalcService.calcPainters(box);
        assertEquals(3, paint);
        System.out.println("3: "+paint);
    }
}