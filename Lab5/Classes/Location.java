package Classes;

public class Location {
    private final long x;
    private final long y;
    private final int z;

    public Location(long x, long y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

}
