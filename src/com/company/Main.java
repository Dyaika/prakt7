package com.company;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    //определяет кто победит
    static public int fight(int card1, int card2){
        if (card1 > card2 && !(card1 == 9 && card2 == 0) || card1 == 0 && card2 == 9){
            return 1;
        } else if (card2 > card1 || card2 == 0 && card1 == 9){
            return 2;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> p1 = new ArrayDeque<>();
        ArrayDeque<Integer> p2 = new ArrayDeque<>();
        int botva = 106;
        int res, card1, card2;
        for (int i = 0; i < 5; i++){
            p1.add(sc.nextInt());
        }
        for (int i = 0; i < 5; i++){
            p2.add(sc.nextInt());
        }
        while (!p1.isEmpty() && !p2.isEmpty() && botva > 0){
            card1 = p1.pop();
            card2 = p2.pop();
            res = fight(card1, card2);
            switch (res){
                case 1:
                    p1.add(card1);
                    p1.add(card2);
                    break;
                case 2:
                    p2.add(card1);
                    p2.add(card2);
                    break;
                default:
                    p1.add(card1);
                    p2.add(card2);
            }
            botva--;
        }
        if (botva == 0){
            System.out.println("botva");
        } else{
            if (p1.isEmpty()){
                System.out.println("second" + " " + (106 - botva));
            } else{
                System.out.println("first" + " " + (106 - botva));
            }
        }
    }
}
