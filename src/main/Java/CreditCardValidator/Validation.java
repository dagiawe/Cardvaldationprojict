package CreditCardValidator;

/*
 *Description: This program will drive the validation class
 **projict:credit card validation
 *Date: 05/07/2021
 *@author  Dagemawi Awoke
 *@version 0.4.4
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Validation extends WritingFile {

    String Filename;
    String[] valid_cards;

    String[] invalid_numbers;

    public Validation() throws IOException {
        valid_cards = new String[0];
        invalid_numbers = new String[0];
        setFilename("C:\\Users\\dagi\\IdeaProjects\\Cardvaldationprojict\\Files\\cardNumbers.txt");
        ReadFile();
    }

    public Validation(String inputFile) throws IOException {
        valid_cards = new String[0];
        invalid_numbers = new String[0];
        setFilename(inputFile);
        ReadFile();
    }

    /**
     * @return String
     */
    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public void ReadFile() throws IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(getFilename()));
            String s;
            while ((s = in.readLine()) != null) {
                if (getValidation(s)) {
                    valid_cards = AddtoArray(valid_cards, getCardIssuer(s));
                } else {
                    invalid_numbers = AddtoArray(invalid_numbers, getCardIssuer(s));
                }
            }
            WrigthFile(valid_cards, true);
            WrigthFile(invalid_numbers, false);
        } catch (FileNotFoundException e) {
            System.out.println("File not founde");
        }
    }

    public boolean getValidation(String s) {
        long n = Long.parseLong(s);
        int i, j, sum = 0;
        long digit, lastDigit;
        int length = Long.toString(n).length();
        long[] list = new long[length];
        long[] dropLast = new long[length - 1];
        for (i = length - 1; i >= 0; i--) {
            digit = n % 10;
            list[i] = digit;
            n /= 10;
        }
        lastDigit = list[length - 1];
        for (i = 0; i < length - 1; i++)
            dropLast[i] = list[i];
        j = length - 1;
        for (i = 0; i <= j; i++, j--) {
            long temp = dropLast[j - 1];
            dropLast[j - 1] = dropLast[i];
            dropLast[i] = temp;
        }
        for (i = 0; i < length - 1; i += 2) {
            long temp = dropLast[i];
            temp *= 2;
            if (temp > 9)
                temp -= 9;
            dropLast[i] = temp;
        }
        for (i = 0; i < length - 1; i++)
            sum += dropLast[i];
        return (Math.addExact(sum, lastDigit)) % 10 == 0;
    }

    public String getCardIssuer(String cardWissuer) {
        if (cardWissuer.length() == 14) {
            if (cardWissuer.startsWith("36"))
                cardWissuer = cardWissuer.concat(" is a Diners Club-International card.");
            else
                cardWissuer = cardWissuer.concat(" is a Diners Club-Carte Blanche card.");
        }
        if (cardWissuer.startsWith("3") && cardWissuer.length() != 14) {
            if (cardWissuer.length() == 15)
                cardWissuer = cardWissuer.concat(" is a American Express card.");
            else
                cardWissuer = cardWissuer.concat(" is a JCB card.");
        }
        if (cardWissuer.startsWith("4")) {
            if (cardWissuer.startsWith("44") || cardWissuer.startsWith("45"))
                cardWissuer = cardWissuer.concat(" is a Visa card.");
            else if (cardWissuer.startsWith("48") || cardWissuer.startsWith("49"))
                cardWissuer = cardWissuer.concat(" is a Visa Electron card.");
        }
        if (cardWissuer.startsWith("5")) {
            if (cardWissuer.startsWith("51") || cardWissuer.startsWith("53"))
                cardWissuer = cardWissuer.concat(" is a Master Card.");
            else if (cardWissuer.startsWith("54") || cardWissuer.startsWith("55"))
                cardWissuer = cardWissuer.concat(" is a Diners Club-North America card.");
            else if (cardWissuer.startsWith("58"))
                cardWissuer = cardWissuer.concat(" is a Maestro card.");
        }
        if (cardWissuer.startsWith("6")) {
            if (cardWissuer.startsWith("60"))
                cardWissuer = cardWissuer.concat(" is a Discover card.");
            else if (cardWissuer.startsWith("67"))
                cardWissuer = cardWissuer.concat(" is a Laser card.");
            else
                cardWissuer = cardWissuer.concat(" is an InstaPayment card.");
        }
        return cardWissuer;
    }

    /**
     * @return String[]
     */

    public String[] AddtoArray(String[] arr, String Numcard) {
        String[] arradd = new String[arr.length + 1];
        System.arraycopy(arr, 0, arradd, 0, arr.length);
        arradd[arradd.length - 1] = Numcard;
        return arradd;
    }
}
