import java.util.Scanner;

abstract class Table {

    protected Scanner myInput = new Scanner(System.in);
    protected int drawer;
    protected double length;
    protected double width;
    protected double area;
    protected double tablePrice;

    protected double woodPrice;

    protected double drawerCost;
    protected double dimensionsCost;

    protected void setDrawer() {
        do {
            System.out.println("Please enter the no of drawers to use [0 -> 6]: ");
            drawer = myInput.nextInt();
            if(drawer>6){
                System.out.println("Invalid input.");
            }
        } while (drawer > 6 || drawer < 0);

    }

    protected void setDimentions() {
        double legthH;
        double widthH;
        double areaH;

        do {
            System.out.println("Please enter the length of the table: ");
            legthH = myInput.nextDouble();
            System.out.println("Please enter the width of the table: ");
            widthH = myInput.nextDouble();
            areaH = legthH * widthH;
            if (areaH < 9600){
                System.out.println("Please enter dimensions greater 9600 ");
            }
        }while (areaH < 9600);

        length = legthH;
        width = widthH;
        area = width * length;
    }

    protected void setTablePrice() {
        if (area == 9600) {
            dimensionsCost = 42500;
        } else  {
            double additionalSquareCm = area - 9600;
            double additionalCost = additionalSquareCm * 825;
            dimensionsCost = 42500 + additionalCost;
        }

        //Add drawer Cost

        if (drawer == 1) {
            drawerCost = 2500;
        }
        else if (drawer == 0){
            drawerCost = 0;
        }
        else {
            int additionalDrawers = drawer - 1;
            double additionalCost = additionalDrawers * 2000;
            drawerCost = 2500 + additionalCost;
        }

        tablePrice += dimensionsCost;
        tablePrice += drawerCost;
    }

    protected void displayTableData(){
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Drawers: " + drawer);
        System.out.println("Dimensions: " + length + " x " + width);
        System.out.println("Area: " + area);
        System.out.println("Wood Price: " + woodPrice);
        System.out.println("Drawer Cost: " + drawerCost);
        System.out.println("Dimensions Cost: " + dimensionsCost);
        System.out.println("Table Price: " + tablePrice);
        System.out.println("-----------------------------------------------------------------------------------------------");

    }

    abstract void woodPrice();
}