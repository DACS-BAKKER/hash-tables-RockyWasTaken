//Author: Rocky Xia
public class ConcordancePair {

    public String key;
    public LocationList occurrences;

    public ConcordancePair(String key){
        this.key = key;
        this.occurrences = new LocationList();
    }
}
