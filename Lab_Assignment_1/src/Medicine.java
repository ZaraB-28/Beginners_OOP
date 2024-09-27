public class Medicine {

    private String medicineID;
    private String batchNo;
    private String manufacturer;

    private Date expiryDate;
    private int quantity;

    private String name;

    private double price;

    Medicine(){

    }

    Medicine(String name, String medicineID,double price,int quantity,String manufacturer, String batchNo, Date expiryDate){
        this.name = name;
        this.medicineID = medicineID;
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "Medicine ID:'" + medicineID + '\'' +
                ", Batch No.:'" + batchNo + '\'' +
                ", Manufacturer:'" + manufacturer + '\'' +
                ", Expiry Date:" + expiryDate +
                ", Quantity:" + quantity +
                ", Name:'" + name + '\'' +
                ", Price:" + price +
                '}';
    }
}
