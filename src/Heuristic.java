public class Heuristic {
    private String destination;
    private int val = -1;

    public String getDestination() {
        return destination;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Heuristic(String destination, int val) {
        this.destination = destination;
        this.val = val;
    }

}
