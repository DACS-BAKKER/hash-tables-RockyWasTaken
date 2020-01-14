import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//Author: Rocky Xia
public class Shakespeare {

    //Declares SonnetTable for search controller
    public static SonnetTable sonnetTable;

    //Constructor for the Shakespeare search model
    public Shakespeare() throws IOException{
        //Setup the SonnetTable
        this.sonnetTable = setup();
    }

    //Setup method for the SonnetTable used for this program
    public static SonnetTable setup() throws IOException{
        //Get a string of unique words as tokens
        String vocabulary = uniqueWords();

        //Constructs new SonnetTable of size equal to the number of unique words
        SonnetTable sonnetTable = new SonnetTable(countTokens(uniqueWords()));

        //Constructs a StringTokenizer for traversal of string of unique words
        StringTokenizer tokens = new StringTokenizer(vocabulary);

        //Traverse the list of unique words to input data into the SonnetTable
        while(tokens.hasMoreTokens()) {
            //Moves to next token
            String currentToken = tokens.nextToken();

            //Constructs a ConcordancePair for each unique word
            ConcordancePair pair = new ConcordancePair(currentToken);

            //Constructs a BufferedReader for file traversal
            BufferedReader reader = new BufferedReader(new FileReader("Sonnets.txt"));

            //Starts the while loop by having a string for the first line
            String currentLine = reader.readLine();

            //Tracking the sonnet and line number
            int sonnet = 1;
            int line = 1;

            //While loop for file traversal
            while (currentLine != null) {
                //Adds the location to the ConcordancePair if it contains the current word of interest
                if (containsToken(currentLine, currentToken)) {
                    pair.occurrences.add(new Location(sonnet, line));
                }

                //Moves the location tracker
                line++;
                if (line > 14) {
                    line = 1;
                    sonnet++;
                }

                //Move to next line
                currentLine = reader.readLine();
            }

            //Closes the file after traversal
            reader.close();

            //Adds the finished ConcordancePair to the SonnetTable
            sonnetTable.put(pair);
        }

        //Returns the finished SonnetTable
        return sonnetTable;
    }

    //Generate a string of unique words in the sonnets
    public static String uniqueWords() throws IOException {
        //Declare a string used for storage
        String result = "";

        //Constructs a BufferedReader for file traversal
        BufferedReader reader = new BufferedReader(new FileReader("Sonnets.txt"));

        //Starts the while loop by having a string for the first line
        String currentLine = reader.readLine();

        //While loop for file traversal
        while(currentLine != null){
            //Constructs a StringTokenizer for line traversal
            StringTokenizer tokens = new StringTokenizer(currentLine);

            //Traverses the current line for tokens
            while(tokens.hasMoreTokens()){
                //Moves to next token
                String currentToken = tokens.nextToken();

                //Adds the current word to the storage string if it's unique
                if(!containsToken(result, currentToken)){
                    result += currentToken + " ";
                }
            }

            //Moves to next line
            currentLine = reader.readLine();
        }

        //Closes the file after traversal
        reader.close();

        //Returns the string of unique words
        return result;
    }

    //Checks if a token is present in a string
    public static boolean containsToken(String search, String word){
        //Constructs a StringTokenizer for line traversal
        StringTokenizer tokens = new StringTokenizer(search);

        //Traverses the string for the token
        while(tokens.hasMoreTokens()){
            //Moves to next token
            String current = tokens.nextToken();

            //Returns true if word is found
            if(current.equals(word)){
                return true;
            }
        }

        //Returns false if word is not found
        return false;
    }

    //Calculate the number of tokens in a string
    public static int countTokens(String line){
        //Declares a counter for the number of tokens
        int count = 0;

        //Constructs a StringTokenizer for line traversal
        StringTokenizer tokens = new StringTokenizer(line);

        //Traverses the string for tokens
        while(tokens.hasMoreTokens()){
            //Moves to next token
            String current = tokens.nextToken();

            //Increase the count by 1
            count++;
        }

        //Returns the total number of tokens in the string
        return count;
    }
}