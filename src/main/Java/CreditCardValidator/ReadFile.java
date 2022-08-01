package CreditCardValidator;
/*
 *Description: This program will drive the validation class
 **projict:credit card validation
 *Date: 05/07/2021
 *@author  Dagemawi Awoke
 *@version 0.4.4
 */

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        System.out.println("Do you want to use your own file?YES OR NO :(CAPSLOCK)" + "\n" + "(if NO i will use cardNUmbers.txt)");
        Scanner key = new Scanner(System.in);
        String kb = key.nextLine();
        if (kb.equals("YES")) {
            System.out.println("Enter file name in YOUR FOLDER");
            kb = key.nextLine();
            try {
                new Validation(kb);
                System.out.println("processed cheak valid_cards.txt and invalid_cards.txt filles in your FOlDER ");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                new Validation();
                System.out.println("processed cheak valid_cards.txt and invalid_cards.txt filles in your FOlDER ");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



