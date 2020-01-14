import edu.princeton.cs.algs4.StdIn;

import java.io.IOException;

//Author: Rocky Xia
public class ShakespeareController {

    //Main method for running the program
    public static void main(String[] args) throws IOException {
        //Constructs the search model
        Shakespeare search = new Shakespeare();

        //Message to the user informing the function of the program
        System.out.println("Basically Google but instead only searches for occurrences of a word in Shakespeare's sonnets");

        //Calls the method to prompt user
        promptUser(search.sonnetTable);
    }

    //User interface for the program
    public static void promptUser(SonnetTable sonnetTable){
        //Declares a boolean used to track whether the user wants to exit the program
        boolean quit = false;

        //While loop for sonnet search
        while(quit != true){
            //Prompts for user input
            //VIM reference
            System.out.println("Enter a word to search for occurrences in Shakespeare's sonnets or enter \":q\" to quit: ");
            String input = StdIn.readLine().toLowerCase();
            if(input.equals(":q")){
                quit = true;
            }
            else{
                ConcordancePair pair = sonnetTable.find(input);
                if(pair != null){
                    pair.occurrences.printOccurences();
                }
                else{
                    System.out.println(input + " is not found in Shakespeare's sonnets");
                }
                System.out.println();
            }
        }
    }
}
