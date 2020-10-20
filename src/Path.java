public class Path {
    private String destination;
    private int length = -1;

    public String getDestination() {
        return destination;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Path(String destination, int length) {
        this.destination = destination;
        this.setLength(length);
    }
    
}
