public class PineTable  extends Table{


    public PineTable() {
        woodPrice();
        setDrawer();
        setDimentions();
        setTablePrice();
    }
    @Override
    void woodPrice() {
        woodPrice = 0;
    }
    @Override
    protected  void displayTableData(){
        System.out.println("Table: " + "Pine");
        super.displayTableData();
    }

    public double getTablePrice() {
        return tablePrice;
    }

    @Override
    protected void setTablePrice() {
        super.setTablePrice();
        tablePrice += woodPrice;
    }

}