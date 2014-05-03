package PickLargestStone;

import java.io.Console;
import java.util.Random;

/**
 * Run in console:
 * 
 * javac PickLargestStone/PickLargestStone.java
 * 
 * java PickLargestStone.PickLargestStone
 */
public class PickLargestStone {

    public static final int TOTAL_STONE_NUM = 4;
    public static final int ALLOWED_PICK_NUM = 3;

    /**
     * @param args
     */
    public static void main(String[] args) {

        // ---------------------------------
        // Generate random stones array

        Random myRan = new Random();

        int randomMean = Math.abs(myRan.nextInt()) % 1000;
        int randomStd = Math.abs(myRan.nextInt()) % 120;

        int[] stones = new int[TOTAL_STONE_NUM];
        for (int i = 0; i < TOTAL_STONE_NUM; i++) {
            double seed = Math.abs(myRan.nextGaussian()) % 100;
            stones[i] = (int) Math.floor(seed * randomStd + randomMean);
        }

        // ---------------------------------
        Console console = System.console();

        int pickCount = 0;
        int count = 0;
        int biggestStone = 0;
        while (count < TOTAL_STONE_NUM) {
            System.out.print((count + 1) + "  Stone size : " + stones[count] + "                  ");
            String sWhatever = console.readLine("Pick it? (y/n)");

            if (sWhatever.equals("y")) {
                System.out.println("You picked stone: " + stones[count]);
                pickCount++;
                biggestStone = stones[count];
            }
            count++;
            if (pickCount == ALLOWED_PICK_NUM) {
                break;
            }
        }

        System.out.println();
        System.out.println("You largest stone is " + biggestStone);
    }
}
