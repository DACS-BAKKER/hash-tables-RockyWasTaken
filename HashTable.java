//Author: Rocky Xia
public class HashTable {

    private String[] stuff;

    public HashTable(int size){
        this.stuff = new String[size];
    }

    //Putting a string into the hash table
    public void put(String word){
        int index = hash(word);
        if(stuff[index] == null){
            stuff[index] = word;
        }
        else {
            if(find(word) == null){
                while(stuff[index] != null){
                    index++;
                    if(index > stuff.length - 1){
                        index = 0;
                    }
                }
                stuff[index] = word;
            }
        }
    }

    //Find a string in the hash table
    public String find(String word){
        int index = hash(word);
        if(stuff[index] == null){
            return null;
        }
        else{
            while(stuff[index] != null && !stuff[index].equals(word)){
                index++;
                if(index > stuff.length - 1){
                    index = 0;
                }
                if(index == hash(word)){
                    return null;
                }
            }
            return stuff[index];
        }
    }

    //Hash function
    //Mod the string total by the length of the array for index
    private int hash(String str){
        return stringTotal(str) % stuff.length;
    }

    //Getting the total sum of the ascii values in a string
    private int stringTotal(String str){
        int total = 0;
        for(int i = 0; i < str.length(); i++){
            int ascii = str.charAt(i);
            total += ascii;
        }
        return total;
    }
}
