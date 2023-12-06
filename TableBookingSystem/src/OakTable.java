public class OakTable extends Table{


    public OakTable() {
        woodPrice();
        setDrawer();
        setDimentions();
        setTablePrice();
    }
    @Override
    void woodPrice() {
        woodPrice = 2015;
    }
    @Override
    protected void displayTableData(){
        System.out.println("Table: " + "Oak");
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