package pasyagitka.model;

public class Record {
    public String name;
    public long phonenumber;
    public String email;

    public Record(String name, long phonenumber, String email) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
    }
    public Record()     {    }

    public String getName() {
        return name;
    }
    public long getPhonenumber() {
        return phonenumber;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", email=" + email +
                '}';
    }
}
