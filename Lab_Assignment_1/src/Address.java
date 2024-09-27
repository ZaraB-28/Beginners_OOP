public class Address {

    private String street;
    private String city;
    private String postal_code;


    Address(String street, String city, String postal_code){

        this.street = street;
        this.city = city;
        this.postal_code = postal_code;

    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String toString(){

        return "Address: " + street + ", " + city + ", " + postal_code;
    }
}
