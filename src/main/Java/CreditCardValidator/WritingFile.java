package CreditCardValidator;
/*
 *Description: This program will create Valid_cards.txt and invalid_cards.txt classes
 **project:credit card validation
 *Date: 05/07/2021
 *@author  Dagemawi Awoke
 *@version 0.4.5
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WritingFile {

    public void WrigthFile(String[] cards2, boolean b) throws IOException {
        PrintWriter outValid;
        PrintWriter outInvalid;
        if (b) {
            try {
                outValid = new PrintWriter(new FileWriter("C:\\Users\\dagi\\IdeaProjects\\Cardvaldationprojict\\Files\\valid_cards.txt", true));
                for (String a : cards2) {
                    outValid.write(a + "\n");
                }
                outValid.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                outInvalid = new PrintWriter(new FileWriter("C:\\Users\\dagi\\IdeaProjects\\Cardvaldationprojict\\Files\\invalid_cards.txt", true));
                for (String a : cards2) {
                    outInvalid.write(a + "\n");
                }
                outInvalid.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

