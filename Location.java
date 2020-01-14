//Author: Rocky Xia
public class Location{

    public int sonnet;
    public int line;

    public Location(int sonnet, int line){
        this.sonnet = sonnet;
        this.line = line;
    }

    public String toString(){
        return "Sonnet " + sonnet + " line " + line;
    }
}