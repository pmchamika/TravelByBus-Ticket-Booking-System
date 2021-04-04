package Pula.Model;

public class Request_Card {

    public int rID;
    public int cus_uid;
    public String price;

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String approvalStatus;

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public int getCus_uid() {
        return cus_uid;
    }

    public void setCus_uid(int cus_uid) {
        this.cus_uid = cus_uid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }





}
