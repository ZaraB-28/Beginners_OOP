import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Ahmed Khan", "092-XXX-XXX");
        Address a1 = new Address("XYZ street","Karachi", "562-56");
        Medicine m1 = new Medicine();

        Pharmacy_Shop shop = new Pharmacy_Shop(p1,a1,1000);

        System.out.println("What Would You Like To Do Today?");

        int input;
        do {
            System.out.println("1. Search Medicine By Name");
            System.out.println("2. Search Medicine By ID");
            System.out.println("3. Add A Medicine");
            System.out.println("4. Remove A Medicine");
            System.out.println("5. Update An Existing Medicine");
            System.out.println("6. Find Expired Medicine");
            System.out.println("7. Sell A Medicine");
            System.out.println("8. Calculate Total Revenue");
            System.out.println("9. Display All Medicines");
            System.out.println("10. Exit");
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();

            switch (input){

                case 1:
                    shop.searchMedicineByName();
                    break;
                case 2:
                    shop.searchMedicineByID();
                    break;
                case 3:
                    shop.addMedicine();
                    break;
                case 4:
                    shop.removeMedicine();
                    break;
                case 5:
                    shop.updateMedicine();
                    break;
//                case 6:
//                    shop.findExpiredMedicine();
//                    break;
                case 7:
                    shop.sellMedicine();
                    break;
                case 8:
                    shop.calculateRevenue();
                    break;
                case 9:
                    shop.display();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Option Not Valid");
            }

        } while (input > 0 && input <11);


    }
}