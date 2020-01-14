//Author: Rocky Xia
public class LocationList {

    private LocationNode first;

    public LocationList(){
        this.first = null;
    }

    public void add(Location location){
        if(first == null){
            first = new LocationNode(location);
        }
        else {
            LocationNode temp = first;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new LocationNode(location);
        }
    }

    public void printOccurences(){
        LocationNode temp = first;
        while(temp.next != null){
            System.out.println(temp.location.toString());
            temp = temp.next;
        }
        System.out.println(temp.location.toString());
    }

    private class LocationNode {
        private Location location;
        private LocationNode next;

        private LocationNode(Location location){
            this.location = location;
            this.next = null;
        }
    }
}
