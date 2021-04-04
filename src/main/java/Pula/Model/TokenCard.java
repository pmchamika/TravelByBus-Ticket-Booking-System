package Pula.Model;

public class TokenCard {

public int t_ID;
public String t_type;
public double price;
    public String expire;
    public String tokenHash;
    public String cus_uid;
    public String add_uid;
public String rID;

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public int getT_ID() {
        return t_ID;
    }

    public void setT_ID(int t_ID) {
        this.t_ID = t_ID;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public String getCus_uid() {
        return cus_uid;
    }

    public void setCus_uid(String cus_uid) {
        this.cus_uid = cus_uid;
    }

    public String getAdd_uid() {
        return add_uid;
    }

    public void setAdd_uid(String add_uid) {
        this.add_uid = add_uid;
    }




}
