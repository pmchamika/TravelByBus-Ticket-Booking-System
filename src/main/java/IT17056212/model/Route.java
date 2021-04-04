package IT17056212.model;

public class Route {

    private int rId;
    private String r_no;
    private String pointA;
    private String pointB;
    private String busStops;
    private String price;
    private int add_uid;

    public int getAdd_uid() {
        return add_uid;
    }

    public void setAdd_uid(int add_uid) {
        this.add_uid = add_uid;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getR_no() {
        return r_no;
    }

    public void setR_no(String r_no) {
        this.r_no = r_no;
    }

    public String getPointA() {
        return pointA;
    }

    public void setPointA(String pointA) {
        this.pointA = pointA;
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }

    public String getBusStops() {
        return busStops;
    }

    public void setBusStops(String busStops) {
        this.busStops = busStops;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
