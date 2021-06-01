package meow.pasyagitka.model;

public class Record {
    private int id;
    public String name;
    public long phoneNumber;
    public String email;

    public Record(int id, String name, long phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Record()     {    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", phonenumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }
}
