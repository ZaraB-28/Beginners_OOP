public class Person {

    private String name;
    private String contact;

    Person(String name, String contact){
        this.name = name;
        this.contact = contact;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Owner's Name: " + name + "\nOwner's Contact: "+ contact;
    }
}
