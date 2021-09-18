package my.revertinputs;

import java.util.Scanner;

public class RevertString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = "", reversedWord;
        System.out.println("Input phrase");
        word += in.nextLine();
        in.close();
        reversedWord = reversString(word);
        System.out.println("Reversed Input phrase is " + reversedWord);

    }

    private static String reversString(String word) {
        System.out.println("word to revert now is = " + word);
        if (word == null || word.length() == 0) {
            return "";
        } else {
            return reversString(word.substring(1)) + word.charAt(0);
        }
    }
}
