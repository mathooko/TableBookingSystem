import java.util.Scanner;

abstract class Table {
    private double woodPrice= 42500;
    private double drawers=0;
    private double area=9600;
    private double length;
    private double width;
    int noTables;
    double discount=0;

    abstract double getWoodPrice();

    public double getDrawers()
    {
        return drawers;
    }
    public double getWidth()
    {
        return width;
    }
    public double getLength()
    {
        return length;
    }
    public int getNoTables() {
        return noTables;
    }
    public double getArea() {
        return area;
    }
    Scanner inputs= new Scanner (System.in);
    public Table(int noTables, double length, double width)
    {
        this.noTables=noTables;
        this.length=length;
        this.width=width;
    }
    public double area()
    {
        System.out.println("Enter width of your table: ");
        width=inputs.nextDouble();
        System.out.println("Enter length:");
        return 0;
    }
    public  double drawerPrice() {
        System.out.println("Enter number of drawers(Maximum of 6 drawers");
        drawers = inputs.nextInt();
        if (drawers < 0 || drawers > 6) {
            System.out.println("Invalid input. Either you have entered less than the required amont or you have exceeded the limit(6)");
            System.out.println("Enter number of drawers: ");
            drawers = inputs.nextInt();
        } else if ( drawers==1){
            return 2500;
        }
        else{
            return 2500 + ((drawers - 1) * 2000);//
        }
        return ((drawers - 1) * 2000) + 2500; //
    }
        public double discount(){
            System.out.println("Enter number of tables");
            double discount = 0.0;
            System.out.println("Enter number of Tables:");
            noTables = inputs.nextInt();
            if(noTables == 0 || noTables < 0) {
                System.out.println("Enter at least one table");
                noTables = inputs.nextInt();
            }
           else if(noTables>1) {
                    discount = .95;
                }
           else {

           discount=1;
           }

               return discount;

    }
    }