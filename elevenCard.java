/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class11demo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author athavang
 */
public class ArrayListDemo {

    static Random rng = new Random();

    public static void intro() {
        boolean check = false;
        String start = null;
        Scanner a = new Scanner(System.in);

        while (check == false) {
            //prints out the intro and the rules of the games
            System.out.println("Welcome to Elevens!\n");
            System.out.println("How To Play\n" + "You can earn points by doing"
                    + " two of the following steps:" + "\n1. Add any 2 face values"
                    + " of the card that add up to 11 (e.g. 8 + 3)"
                    + "\n2. You can take out 3 cards in a special combination of"
                    + " Jack - Queen - King.");

            System.out.println("\nIf any of those steps are fulfilled, the "
                    + "game will replace 2 or 3 new cards on the gamelist");

            System.out.println("\nYou will continue to play until there are NO "
                    + "2 numbers to add up to 11\nAND there are NO Jack-Queen-King"
                    + " combinations");

            System.out.println("\nKeep playing until you WIN");

            System.out.println("");
            System.out.println("Card positions go in this order as listed below:");

            //prints out the numbering order for the user
            //meant for typing in correct number placement for the game
            for (int i = 0; i < 3; i++) {
                System.out.print(i + "\t");
            }
            System.out.println("");

            for (int i = 3; i < 6; i++) {
                System.out.print(i + "\t");
            }
            System.out.println("");

            for (int i = 6; i < 9; i++) {
                System.out.print(i + "\t");
            }
            System.out.println("");

            System.out.println("\nPlease press ENTER to begin!!!!!");

            start = a.nextLine();
            if (start.equalsIgnoreCase("play"));
            check = true;
        }

    }

    /**
     *
     * @param strCard is a String representation of the card
     * @return the point associate with the strCard
     */
    public static int point(String strCard) {
        //card number on card --> converts to a number
        if (strCard.equals("2H") || strCard.equals("2D")
                || strCard.equals("2C")
                || strCard.equals("2S")) {
            return 2;
        } else if (strCard.equals("3H") || strCard.equals("3D")
                || strCard.equals("3C")
                || strCard.equals("3S")) {
            return 3;
        } else if (strCard.equals("4H") || strCard.equals("4D")
                || strCard.equals("4C")
                || strCard.equals("4S")) {
            return 4;
        } else if (strCard.equals("5H") || strCard.equals("5D")
                || strCard.equals("5C")
                || strCard.equals("5S")) {
            return 5;
        } else if (strCard.equals("6H") || strCard.equals("6D")
                || strCard.equals("6C")
                || strCard.equals("6S")) {
            return 6;
        } else if (strCard.equals("7H") || strCard.equals("7D")
                || strCard.equals("7C")
                || strCard.equals("7S")) {
            return 7;
        } else if (strCard.equals("8H") || strCard.equals("8D")
                || strCard.equals("8C")
                || strCard.equals("8S")) {
            return 8;
        } else if (strCard.equals("9H") || strCard.equals("9D")
                || strCard.equals("9C")
                || strCard.equals("9S")) {
            return 9;
        } else if (strCard.equals("10H") || strCard.equals("10D")
                || strCard.equals("10C")
                || strCard.equals("10S")) {
            return 10;
        } else if (strCard.equals("AH") || strCard.equals("AD")
                || strCard.equals("AC")
                || strCard.equals("AS")) {
            return 1;
        }

        return 0;

    }

    public static boolean is11Possible(ArrayList<String> gList) {

        for (int i = 0; i < gList.size(); i++) {
            for (int j = i + 1; j < gList.size(); j++) {
                if (point(gList.get(i)) + point(gList.get(j)) == 11) {
                    //any two cards that add up to 11 make this boolean statement true
                    return true;
                }
            }
        }

        for (int i = 0; i < gList.size(); i++) {
            for (int j = i + 1; j < gList.size(); j++) {
                for (int k = j + 1; k < gList.size(); k++) {
                    //meant for converting numbers into 3 cards
                    String s1 = gList.get(i);
                    String s2 = gList.get(j);
                    String s3 = gList.get(k);

                    //refers to different combinations of Jack, Queen, King
                    if (s1.indexOf("J") >= 0 && s2.indexOf("K") >= 0
                            && s3.indexOf("Q") >= 0) {
                        return true;
                    } else if (s1.indexOf("J") >= 0 && s2.indexOf("Q") >= 0
                            && s3.indexOf("K") >= 0) {
                        return true;
                    } else if (s1.indexOf("Q") >= 0 && s2.indexOf("J") >= 0
                            && s3.indexOf("K") >= 0) {
                        return true;
                    } else if (s1.indexOf("Q") >= 0 && s2.indexOf("K") >= 0
                            && s3.indexOf("J") >= 0) {
                        return true;
                    } else if (s1.indexOf("K") >= 0 && s2.indexOf("Q") >= 0
                            && s3.indexOf("J") >= 0) {
                        return true;
                    } else if (s1.indexOf("K") >= 0 && s2.indexOf("J") >= 0
                            && s3.indexOf("Q") >= 0) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        intro();//plays intro

        Scanner input = new Scanner(System.in);

        String[] deck = new String[52];//gives 52 possible cards
        ArrayList<String> deckList = new ArrayList<String>();//
        ArrayList<String> gameList = new ArrayList<String>();
        //we have to initialize the deck with 52 Cards
        String[] suit = {"H", "D", "C", "S"};//all the suits (4)
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "K", "Q", "J"};
        //all the numbers/faces (13)
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String card = rank[j] + suit[i];
                deckList.add(card);

            }
        }
        /*generates 52 cards for deckList
   We need to generate 9 random numbers and initialize the gameList 
        with cards picked up from the deck using those random numbers
         */

        for (int i = 0; i < 9; i++) {
            int intRandom = (int) (Math.random() * deckList.size());
            int intRandom2 = (int) (Math.random() * deckList.size());
            //go and pick a card at intRandom in the deck and put it 
            //inside the game list

            //removed the card at random index in the list
            gameList.add(deckList.get(intRandom));//
            deckList.remove(intRandom);
        }//adds 9 initial cards from deckList to gameList
        //removes 9 initial cards from deckList

        boolean isMagic = !gameList.isEmpty() && is11Possible(gameList);
        //is true when deckList is empty OR 
        //if at least two cards in gameList add up to 11

        //represents possibilities that could get a sum of 11
        int intCount = 0;//represents the number of points user will get

        while (isMagic) {
            //game will go on while boolean statement (above) is true

            for (int j = 0; j < 3; j++) {
                System.out.print(gameList.get(j) + "\t");
            }
            System.out.println("");
            //produces first 3 cards on first row

            for (int j = 3; j < 6; j++) {
                System.out.print(gameList.get(j) + "\t");
            }
            System.out.println("");
            //produces first 3 cards on second row

            for (int j = 6; j < 9; j++) {
                System.out.print(gameList.get(j) + "\t");
            }
            System.out.println("");
            //produces first 3 cards on last row

            System.out.println("Score: " + intCount);

            System.out.println("Would you like 2 or 3 cards?");
            int isNum = input.nextInt();
            //asks for either 2 or 3

            System.out.println("\nPosition starts from 0, NOT 1");

            if (gameList.size() >= 2 && isNum == 2) {
                //asks for 2 numbers if the number is 2 
                System.out.println("Please give 2 numbers from 0 to 8");
                int a = input.nextInt();//asks number placement from 0 to 8
                int b = input.nextInt();//asks number placement from 0 to 8

                while (a > 8 || b > 8) {
                    //if user types number greater than 8
                    System.out.println("Sorry. Please try again with a number"
                            + " between 0 and 8");
                    a = input.nextInt();//asks number placement from 0 to 8
                    b = input.nextInt();//asks number placement from 0 to 8
                }

                System.out.println("");

                if (point(gameList.get(a)) + point(gameList.get(b)) == 11) {

                    gameList.set(a, "");
                    gameList.set(b, "");

                    int intRandom = (int) (Math.random() * deckList.size());
                    //gets random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes random card from deckList

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //gets 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd random card from deckList

                    // if boolean statement (isMagic) is false, then the game ends
                    intCount += 1;//gives 1 point to the user
                }

            } else if (gameList.size() >= 3 && isNum == 3) {
                //asks for 3 numbers if the number is 3
                System.out.println("Please give 3 numbers from 0 to 8");
                int a = input.nextInt();
                int b = input.nextInt();
                int c = input.nextInt();

                while (a > 8 || b > 8) {
                    //if user types number greater than 8 (since those will not work)
                    System.out.println("Sorry. Please try again with a number"
                            + " between 0 and 8");
                    a = input.nextInt();//asks number placement from 0 to 8
                    b = input.nextInt();//asks number placement from 0 to 8
                    c = input.nextInt();//asks number placement from 0 to 8        
                }

                //3 numbers chosen used to find cards on gameList
                String s1 = gameList.get(a);
                String s2 = gameList.get(b);
                String s3 = gameList.get(c);

                if (s1.indexOf("J") >= 0 && s2.indexOf("K") >= 0
                        && s3.indexOf("Q") >= 0) {

                    int intRandom = (int) (Math.random() * deckList.size());
                    //generates random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes original card

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //generates 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd original card

                    int intRandom3 = (int) (Math.random() * deckList.size());
                    //generates 3rd random card

                    gameList.set(c, deckList.get(intRandom3));
                    //sets 3rd random card in the place of 3rd original card

                    deckList.remove(deckList.get(intRandom3));
                    //removes 3rd original card

                    intCount += 1;//gives 1 point to user

                } else if (s1.indexOf("J") >= 0 && s2.indexOf("Q") >= 0
                        && s3.indexOf("K") >= 0) {

                    int intRandom = (int) (Math.random() * deckList.size());
                    //generates random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes original card

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //generates 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd original card

                    int intRandom3 = (int) (Math.random() * deckList.size());
                    //generates 3rd random card

                    gameList.set(c, deckList.get(intRandom3));
                    //sets 3rd random card in the place of 3rd original card

                    deckList.remove(deckList.get(intRandom3));
                    //removes 3rd original card

                    intCount += 1;//gives 1 point to user
                } //checks whether the cards at a,b,and c have face value and different cards
                else if (s1.indexOf("Q") >= 0 && s2.indexOf("J") >= 0
                        && s3.indexOf("K") >= 0) {

                    int intRandom = (int) (Math.random() * deckList.size());
                    //generates random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes original card

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //generates 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd original card

                    int intRandom3 = (int) (Math.random() * deckList.size());
                    //generates 3rd random card

                    gameList.set(c, deckList.get(intRandom3));
                    //sets 3rd random card in the place of 3rd original card

                    deckList.remove(deckList.get(intRandom3));
                    //removes 3rd original card

                    intCount += 1;//gives 1 point to user

                } else if (s1.indexOf("Q") >= 0 && s2.indexOf("K") >= 0
                        && s3.indexOf("J") >= 0) {

                    int intRandom = (int) (Math.random() * deckList.size());
                    //generates random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes original card

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //generates 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd original card

                    int intRandom3 = (int) (Math.random() * deckList.size());
                    //generates 3rd random card

                    gameList.set(c, deckList.get(intRandom3));
                    //sets 3rd random card in the place of 3rd original card

                    deckList.remove(deckList.get(intRandom3));
                    //removes 3rd original card

                    intCount += 1;//gives 1 point to user
                } else if (s1.indexOf("K") >= 0 && s2.indexOf("Q") >= 0
                        && s3.indexOf("J") >= 0) {

                    int intRandom = (int) (Math.random() * deckList.size());
                    //generates random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes original card

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //generates 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd original card

                    int intRandom3 = (int) (Math.random() * deckList.size());
                    //generates 3rd random card

                    gameList.set(c, deckList.get(intRandom3));
                    //sets 3rd random card in the place of 3rd original card

                    deckList.remove(deckList.get(intRandom3));
                    //removes 3rd original card  

                    intCount += 1;//gives 1 point to user

                } else if (s1.indexOf("K") >= 0 && s2.indexOf("J") >= 0
                        && s3.indexOf("Q") >= 0) {

                    int intRandom = (int) (Math.random() * deckList.size());
                    //generates random card

                    gameList.set(a, deckList.get(intRandom));
                    //sets random card in the place of original card

                    deckList.remove(deckList.get(intRandom));
                    //removes original card

                    int intRandom2 = (int) (Math.random() * deckList.size());
                    //generates 2nd random card

                    gameList.set(b, deckList.get(intRandom2));
                    //sets 2nd random card in the place of 2nd original card

                    deckList.remove(deckList.get(intRandom2));
                    //removes 2nd original card

                    int intRandom3 = (int) (Math.random() * deckList.size());
                    //generates 3rd random card

                    gameList.set(c, deckList.get(intRandom3));
                    //sets 3rd random card in the place of 3rd original card

                    deckList.remove(deckList.get(intRandom3));
                    //removes 3rd original card

                    intCount += 1;//gives 1 point to user

                }

            }

            if (deckList.isEmpty()) {
                //if deckList is Empty, you WIN and the game ENDS

                System.out.println("YOU WIN!!!!");
                for (int i = 0; i < 9; i++) {
                    System.out.print(gameList.get(i) + "\t");
                }
                System.out.println("");
                /*prints out 9 remaining cards in gameList 
      (should have pairs that add up to 11)
                 */

                break;

            } else if (!is11Possible(gameList) && !deckList.isEmpty()) {
                /*if boolean method is false and deckList isn't empty, you LOSE
          and the game ENDS
                 */
                System.out.println("GAME OVER\nYOU LOSE, SYSTEM WINS");
                System.out.println("Score: " + intCount);

                for (int i = 0; i < 9; i++) {
                    System.out.print(gameList.get(i) + "\t");
                }
                //prints out the final gameList
                System.out.println("");

                break;
            }

            isMagic = !gameList.isEmpty() && is11Possible(gameList);

        }
    }

}
