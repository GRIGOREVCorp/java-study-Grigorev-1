package neoflexprojecttask1;

import java.util.*;

public class NeoFlexProjectTask1 {
    static HashMap<String,Integer> countWords = new HashMap<>();

    public static void main(String[] args) {
        searchWord("Hello<Dima,dima> how are you? Hello, I'am Dima dima", "Dima Hello", true);
        for (String word : countWords.keySet()) 
            System.out.println("Слово: " + word + " встречается " + 
                    countWords.get(word) + " раз");
    }
    
    private static void searchWord(String text, String words, boolean ignorCase) {
        countWords = new HashMap<String,Integer>();
        String[] wordsFromTheText = transformationInMassiv(text);
        String[] wordsFromTheWords = transformationInMassiv(words);
        int count;
        for (String wordFormWords : wordsFromTheWords) {
            count=0;
            for (String wordFormText : wordsFromTheText) {
                if (((wordFormWords.compareToIgnoreCase(wordFormText))==0)&&(ignorCase))
                    count++;
                else { if((wordFormWords.compareTo(wordFormText))==0) count++; }
            }
            countWords.put(wordFormWords,count);
        }
    }
    
    private static String[] transformationInMassiv(String text) {
        return text.replaceAll("[^A-Za-z]", " ").split(" ");
    }
}
