//Author: Rocky Xia
public class SonnetTable {

    //Storage array for hash table
    private ConcordancePair[] stuff;

    //Constructor
    public SonnetTable(int size){
        this.stuff = new ConcordancePair[size];
    }

    //Putting a ConcordancePair into the hash table
    public void put(ConcordancePair pair){
        int index = hash(pair.key);
        if(stuff[index] == null){
            stuff[index] = pair;
        }
        else {
            if(find(pair.key) == null){
                while(stuff[index] != null){
                    index++;
                    if(index > stuff.length - 1){
                        index = 0;
                    }
                }
                stuff[index] = pair;
            }
        }
    }

    //Find a ConcordancePair with a key
    public ConcordancePair find(String key){
        int index = hash(key);
        if(stuff[index] == null){
            return null;
        }
        else{
            while(stuff[index] != null && !stuff[index].key.equals(key)){
                index++;
                if(index > stuff.length - 1){
                    index = 0;
                }
                if(index == hash(key)){
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
