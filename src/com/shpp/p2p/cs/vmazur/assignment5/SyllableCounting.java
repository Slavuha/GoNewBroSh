package com.shpp.p2p.cs.vmazur.assignment5;

import com.shpp.cs.a.console.TextProgram;
//Program take input word and return result - count of syllables in word
public class SyllableCounting extends TextProgram {


    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesInWord(word));
            countOfSyllables = 0;
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesInWord(String word) {
        return analyzeWord(word);
    }
    //I added counter to calculate
    int countOfSyllables = 0;

    /**
     * Method analyze word according to requirements of a task.
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int analyzeWord(String word) {

        String str = word;
        int lenghtOfWord = str.length();
        char lastChar = str.charAt(lenghtOfWord - 1);


        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (checkChar(ch) && !flag) {
                countOfSyllables++;
                flag = true;
            } else if (!checkChar(ch)) {
                flag = false;
            }

        }
        if (lastChar == 'e') { //Here I implement rule of last e
            countOfSyllables--;
        }

        if (countOfSyllables < 1 ) {//Here rule if count lower than 1
            countOfSyllables = 1;
        }
        return countOfSyllables;
    }
    /**
     * Method analyze char.
     * @param ch our char from previous method
     */
    private boolean checkChar(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y';
    }

    //Here I added a boolean flag to regulate counter
    boolean flag = true;

}
