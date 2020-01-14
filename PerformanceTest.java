import edu.princeton.cs.algs4.StdIn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

//Author: Rocky Xia
public class PerformanceTest {

    public static HashTable hastTable;

    public static void main(String[] args) throws IOException{
        promptUser();
    }

    //Timed process of reading a file of 1000 words and return a hash table
    public static HashTable readFile(String fileName, int size) throws IOException {
        HashTable hashTable = new HashTable(size);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currentWord = reader.readLine();
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            hashTable.put(currentWord);
            currentWord = reader.readLine();
        }
        reader.close();
        long end = System.currentTimeMillis();
        double time = (end - start)/1000;
        System.out.println("File read in " + time + " seconds");
        return hashTable;
    }

    //Timed process of finding a word in the hashtable
    public static void findTime(HashTable hashTable, String[] wordList, int repetitions){
        Random rng = new Random();
        for(int i = 0; i < repetitions; i++){
            int index = rng.nextInt(wordList.length);
            long start = System.currentTimeMillis();
            String find = hashTable.find(wordList[index]);
            long end = System.currentTimeMillis();
            double time = (end-start)/1000;
            if(find != null){
                System.out.println(wordList[index] + " found in " + time + " seconds");
            }
            else{
                System.out.println(wordList[index] + " not found in " + time + " seconds");
            }
        }
    }

    public static String[] readWords(String fileName, int size) throws IOException{
        int index = 0;
        String[] wordList = new String[size];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currentWord = reader.readLine();
        for(int i = 0; i < size; i++){
            wordList[index] = currentWord;
            index++;
            currentWord = reader.readLine();
        }
        reader.close();
        return wordList;
    }

    public static void promptUser() throws IOException {
        HashTable hashTable = readFile("Words.txt", 500);
        System.out.println("Enter number of repetitions for search time analysis: ");
        int input = StdIn.readInt();
        findTime(hashTable, readWords("Words.txt", 1000), input);
    }
}
