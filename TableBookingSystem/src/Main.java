import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String password = "TempPass";
    public static Scanner myInput = new Scanner(System.in);

    private static MahoganyTable mahoganyTableRef;
    private static OakTable oakTableRef;
    private static PineTable pineTableRef;

    private static ArrayList<Table> order = new ArrayList<>();
    private static ArrayList<Integer> invoiceCounts = new ArrayList<>();


    public static double totalPrice = 0;

    public static void main(String[] args) {
        String passInput;
        do {
            System.out.println("Welcome to Antique Furniture Kenya Limited ");
            System.out.println("");
            System.out.println("Please Input your password to continue: ");
            passInput = myInput.next();
            passInput = passInput.trim();

            if (passInput.equals(password)) {
                System.out.println("###########################################################################");
                System.out.println("###########                Welcome          ###############################");
                System.out.println("###########################################################################");
            } else {
                System.out.println("The password you entered is wrong. Please try again");
            }

        } while (!passInput.equals(password));

        tableTypeValidation();
    }
    public static void tableTypeValidation() {
        String wood;
        ArrayList<String> allowedWoodTypes = new ArrayList<>();
        allowedWoodTypes.add("oak");
        allowedWoodTypes.add("mahogany");
        allowedWoodTypes.add("pine");

        do {
            System.out.println("Please enter the wood to use [oak] [mahogany] [pine]: ");
            wood = myInput.next();
            if (!allowedWoodTypes.contains(wood.toLowerCase())) {
                System.out.println("Wood type not allowed!");
            }

        }

        while (!allowedWoodTypes.contains(wood.toLowerCase()));

        switch (wood.toLowerCase()) {
            case "oak":
                OakTable oakTableObj = new OakTable();
                oakTableRef = oakTableObj;
                System.out.println("Do you wish to create multiple tables [0: No] [>0: Yes with number ] : ");
                int countToAdd = myInput.nextInt();
                order.add(oakTableObj);
                invoiceCounts.add(countToAdd + 1);
                createMultipleInstancesOfTable(countToAdd, "oak");
                break;
            case "mahogany":
                MahoganyTable mahoganyTableObj = new MahoganyTable();
                mahoganyTableRef = mahoganyTableObj;
                System.out.println("Do you wish to create multiple tables [0: No] [>0: Yes with number ] : ");
                int countToAddMahogany = myInput.nextInt();
                order.add(mahoganyTableObj);
                invoiceCounts.add(countToAddMahogany + 1);
                createMultipleInstancesOfTable(countToAddMahogany, "mahogany");
                break;
            case "pine":
                PineTable pineTable = new PineTable();
                pineTableRef = pineTable;
                System.out.println("Do you wish to create multiple tables [0: No] [>0: Yes with number ] : ");
                int countToAddPine = myInput.nextInt();
                order.add(pineTable);
                invoiceCounts.add(countToAddPine + 1);
                createMultipleInstancesOfTable(countToAddPine, "pine");
                break;
            default:
                System.out.println("Unable to create a table!");
        }


    }


    public static void createMultipleInstancesOfTable(int count, String type) {
        ArrayList<MahoganyTable> mahoganyTables = new ArrayList<>();
        ArrayList<OakTable> oakTables = new ArrayList<>();
        ArrayList<PineTable> pineTables = new ArrayList<>();

        if (type == "mahogany") {
            if (count == 0) {
                totalPrice += mahoganyTableRef.getTablePrice();
            } else {
                double sumTotal = 0;
                sumTotal += mahoganyTableRef.getTablePrice();
                for (int i = 0; i < count; i++) {
                    MahoganyTable mahoganyTable = mahoganyTableRef;
                    mahoganyTables.add(mahoganyTable);
                    sumTotal += mahoganyTable.getTablePrice();
                }

                double discounted = 0.05 * sumTotal;
                totalPrice += sumTotal - discounted;
            }
        }
        if (type == "oak") {
            if (count == 0) {
                totalPrice += oakTableRef.getTablePrice();
            } else {
                double sumTotal = 0;
                sumTotal +=  oakTableRef.getTablePrice();
                for (int i = 0; i < count; i++) {
                    OakTable oakTable = oakTableRef;
                    oakTables.add(oakTable);
                    sumTotal += oakTable.getTablePrice();
                }
                double discounted = 0.05 * sumTotal;
                totalPrice += sumTotal - discounted;


            }
        }
        if (type == "pine") {
            if (count == 0) {
                totalPrice += pineTableRef.getTablePrice();
            } else {
                double sumTotal = 0;
                sumTotal += pineTableRef.getTablePrice();
                for (int i = 0; i < count; i++) {
                    PineTable pineTable = pineTableRef;
                    sumTotal += pineTable.getTablePrice();
                    pineTables.add(pineTable);
                }
                double discounted = 0.05 * sumTotal;
                totalPrice += sumTotal - discounted;

            }
        }


//


        int wantToAdd;
        do {
            System.out.println("Do you want to add another table type ? [0: No , 1: Yes]: ");
            wantToAdd = myInput.nextInt();

            if (wantToAdd == 1) {
                tableTypeValidation();
            } else if (wantToAdd == 0) {

                for (int i = 0; i < order.size(); i++) {
                    Table table = order.get(i);
                    table.displayTableData();
                    System.out.println("Number of Tables: " + invoiceCounts.get(i));
                    System.out.println();
                }

                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.println("Total cost: " + totalPrice);
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
            else {
                System.out.println("Invalid input");
            }


        } while (wantToAdd != 1 && wantToAdd != 0);

        // getPaymentAndCalculateBalance();

    }

    public static void getPaymentAndCalculateBalance() {
        double paymentAmount;

        do {
            System.out.println("Please enter payment amount: ");
            paymentAmount = myInput.nextDouble();
            if (paymentAmount < totalPrice) {
                System.out.println("Payment amount is less than total Price by: " + (paymentAmount - totalPrice));
            } else {
                System.out.println("Thank you :( . Your Balance is :  " + (totalPrice - paymentAmount));
            }
        } while (paymentAmount < totalPrice);
    }
}