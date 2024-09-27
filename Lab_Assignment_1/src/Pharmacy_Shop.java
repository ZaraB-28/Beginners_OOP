import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pharmacy_Shop {

    private Person owner;
    private Address address;
    private int medicineCount;
    private Medicine[] medicines = new Medicine[100];
    private Medicine meds;

     {
        medicines[0] = new Medicine("Paracetamol","M001",50.0,100,"PharmaCorp","B123",new Date(15,8,2025));
        medicines[1] = new Medicine("Ibuprofen","M002",75.0,80,"HealthMed","B124",new Date(10,12,2024));
        medicines[2] = new Medicine("Amoxcillin","M003",120.0,50,"BioPharma","B125",new Date(20,5,2026));
        medicines[3] = new Medicine("Ciprofloxacin","M004",150.0,60,"MedLife","B126",new Date(30,11,2025));
        medicines[4] = new Medicine("Metformin","M005",90.0,70,"GlucoCare","B127",new Date(25,7,2024));
        medicines[5] = new Medicine("Aspirin","M006",40.0,150,"PainRelief","B128",new Date(5,3,2025));
        medicines[6] = new Medicine("Lisinopril","M007",110.0,90,"CardioHealth","B129",new Date(18,9,2026));
        medicines[7] = new Medicine("Atorvastatin","M008",130.0,40,"CholestrolCare","B130",new Date(12,1,2025));
        medicines[8] = new Medicine("Omeprazole","M009",85.0,110,"DigestWell","B131",new Date(22,6,2024));
        medicines[9] = new Medicine("Losartan","M010",95.0,65,"BloodPressurePlus","B132",new Date(14,2,2026));

    }

    Pharmacy_Shop(Person owner, Address address, int medicineCount){
        this.owner = owner;
        this.address = address;
        this.medicineCount = medicineCount;
    }



    public void searchMedicineByID(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Medicine ID: ");
        String id = sc.next();
        for(int i = 0; i < medicines.length; i++){
            if (Objects.equals(medicines[i].getMedicineID(),id))
                System.out.println(id + " Available.");
            else
                System.out.println("Medicine Not Available.");
        }
    }

    public void searchMedicineByName(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Medicine Name: ");
        String name = sc.next();
        for(int i = 0; i < medicines.length; i++){
            if (Objects.equals(medicines[i].getName(),name))
                System.out.println(name + " Available.");
            else
                System.out.println("Medicine Not Available.");
        }
    }

    public void removeMedicine(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Medicine Name: ");
        String name = sc.next();
        for(int i = 0; i < medicines.length; i++){
            if (Objects.equals(medicines[i].getName(),name)) {
                System.out.println(sc.next() + " Removed.");

            }
            else
                System.out.println("Medicine Not Available.");
        }
    }

    public void addMedicine(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Medicine Name: ");
        String name = sc.next();

        System.out.println(name + " Added.");

    }

    public void sellMedicine(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Medicine Name: ");
        String name = sc.next();
        for(int i = 0; i < medicines.length; i++){
            if (Objects.equals(medicines[i].getName(),name)) {
                System.out.println(name + " Available.");
                System.out.println("Thank You For Your Purchase!");
                medicines[i].setQuantity(medicines[i].getQuantity()-1);
            }
            else
                System.out.println("Medicine Not Available.");
        }
    }

//    public void findExpiredMedicine(){
//
//        for(int i = 0; i < medicines.length; i++){
//            if (medicines[i].getExpiryDate() ) {
//
//                System.out.println(medicines[i] + " Expired.");
//            }
//
//        }
//    }

    public void updateMedicine(){

    }

    public void calculateRevenue(){
        sellMedicine();
        double revenue = 0;
        for (int i = 0; i < medicines.length; i++) {
            revenue +=medicines[i].getPrice();
        }

    }
    public void display(){

        System.out.println(meds);
    }

}
