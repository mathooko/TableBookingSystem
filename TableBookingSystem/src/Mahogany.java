public class Mahogany extends Table {


    public Oak(double length, double width, int drawers) {
        super(drawers, length, width);
    }
    @Override
    int woodPrice(){
        return 2015;
    }
}