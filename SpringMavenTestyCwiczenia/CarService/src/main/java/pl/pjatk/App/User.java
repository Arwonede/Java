package pl.pjatk.App;

public class User {
    private  String accid;

    public User(String accid) {
        this.accid = accid;
    }
    public void setAccid(String accid) {
        this.accid = accid;
    }
    public String getAccid() {
        return accid;
    }

    @Override
    public String toString() {
        return "User{" +
                "accid='" + accid + '\'' +
                '}';
    }
}
