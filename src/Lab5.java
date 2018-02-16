/**
 * CSIT 150 Lab 5
 * Purpose: to read a file of strings and test if the strings are palindromes using a recursive method and an
 * iterative method.  Number of palindromes is also kept track of and printed.
 *
 * author: Jared Zwiener
 * date: 2/15/18
 * credit: worked with Hunter Smith
 */

import java.io.*;
import java.util.Scanner;
public class Lab5 {

    /**
     * Main method for reading file and testing for palindromes
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{

        System.out.println("Recursive test \nPalindromes are:");
        checkPalindromesRecursively();
        System.out.println();

        System.out.println("Iterative test \nPalindromes are:");
        checkPalindromesIteratively();
    }

    /**
     * check for and print out Palindromes iteratively, keep and print palindrome count
     * @throws FileNotFoundException
     */
    public static void checkPalindromesIteratively() throws FileNotFoundException {
        File file = new File("palindrometest.txt");
        Scanner fileScan = new Scanner(file);
        String wordToTest;
        int countIterative = 0;

        while (fileScan.hasNextLine()) {
            wordToTest = fileScan.nextLine();
            if (palindromeIterative(wordToTest)) {
                System.out.println(wordToTest);
                countIterative++;
            }
        }
            System.out.println("Number of Palindromes are: " + countIterative);
    }

    /**
     * check for and print out Palindromes recursively, keep and print palindrome count
     * @throws FileNotFoundException
     */
    public static void checkPalindromesRecursively() throws FileNotFoundException{
        File file = new File ("palindrometest.txt");
        Scanner fileScan = new Scanner(file);
        String wordToTest;
        int countRecursive = 0;

        while (fileScan.hasNextLine()) {
            wordToTest = fileScan.nextLine();
            if(palindrome(wordToTest)) {
                System.out.println(wordToTest);
                countRecursive++;
            }
        }
        System.out.println("Number of Palindromes are: " + countRecursive);
    }

    /**
     * recursive test to see if the word is a palindrome
     * @param word
     * @return boolean - true or false
     */
    public static boolean palindrome(String word){
        boolean test = false;
        if (word.length()==0 || word.length() == 1)
            test = true;
        else if (word.charAt(0) == word.charAt(word.length()-1))
            return palindrome(word.substring(1, word.length()-1));
        return test;
    }

    /**
     * iterative test to see if the word is a palindrome
     * @param word
     * @return boolean - true or false
     */
    public static boolean palindromeIterative(String word){
        boolean test = true;
        int start = 0, finish = word.length()-1;
        while(start<finish) {
            if (word.charAt(start) != word.charAt(finish))
                test = false;
            start++;
            finish--;
        }
        return test;
    }
}
