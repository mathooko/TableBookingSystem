public class Pine extends Table {


    public Pine(double length, double width, int drawers) {
        super(drawers, length, width);
    }
    @Override
    int woodPrice(){
        return 0;
    }
}
