/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Sachin Duhan
 * Student Id 991701782
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[8]; // Increased array size to accommodate lucky card
        
        for (int i=0; i<magicHand.length-1; i++)
        {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13 + 1));  
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]);  
            magicHand[i] = c;
        }
        
        // Add the lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(7); // Example: Card number 7
        luckyCard.setSuit(Card.SUITS[2]); // Example: Hearts
        magicHand[magicHand.length-1] = luckyCard;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of your card (1-13)= ");
        int userValue = input.nextInt();
        System.out.print("Enter the suit of your card (0-3)= ");
        int userSuit = input.nextInt();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        boolean found = false;
        for (int i = 0; i < magicHand.length; i++) {
            if (magicHand[i].getValue() == userCard.getValue() && magicHand[i].getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card is in the magic hand.");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
    }
}
