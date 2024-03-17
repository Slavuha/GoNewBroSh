package com.shpp.p2p.cs.vmazur.assignment5;

import com.shpp.cs.a.console.TextProgram;

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
    int countOfSyllables = 0;
    private int analyzeWord(String word) {


    String str = word;
    int lenghtOfWord = str.length();
    char lastChar = str.charAt(lenghtOfWord-1);


        System.out.println(lastChar);
    for (int i = 0; i<str.length(); i++){
        char ch = str.charAt(i);
        checkChar(ch);
    }
    if (lastChar=='e'){
        countOfSyllables--;
    }

    if (countOfSyllables==0){
        countOfSyllables = 1;
    }
//        ruleLastE();

        return countOfSyllables;
    }

    private void checkChar(char ch) {
        char[] arr = {'a', 'e', 'i', 'o', 'u', 'y'};
        boolean flag = false;

        for (int i = 0; i<arr.length;i++){
            if (ch == arr[i]) {
            countOfSyllables++;
            flag = true;
            }

        }

    }
}