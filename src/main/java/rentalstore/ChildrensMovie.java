package rentalstore;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title){
        super(title);
    }
    protected double getAmount(int day) {
        double amount = 1.5;
        if (day > 3) {
            amount += (day - 3) * 1.5;
        }
        return amount;
    }

    protected double getFrequentRenterPoints(int day) {
        return 1;
    }
}
