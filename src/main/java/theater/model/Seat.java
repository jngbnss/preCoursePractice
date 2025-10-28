package theater.model;

public class Seat {
    private final String id;
    private boolean reserved;

    public Seat(String id) {
        this.id = id;
        this.reserved = false;
    }

    public String getId() {
        return id;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve(){reserved = true;}
    public void cancel(){reserved = false;}

    @Override
    public String toString() {
        return reserved?"[X]":"[O]";
    }
}
