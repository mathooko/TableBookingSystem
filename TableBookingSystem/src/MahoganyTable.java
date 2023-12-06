public class MahoganyTable extends Table {



    public MahoganyTable() {
        woodPrice();
        setDrawer();
        setDimentions();
        setTablePrice();
    }
    @Override
    void woodPrice() {
        woodPrice = 3000;
    }
    @Override
    protected void displayTableData(){
        System.out.println("Table: " + "Mahogany");
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