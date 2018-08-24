package rentalstore;

public class RegularMovie extends Movie {
    public RegularMovie(String title){
        super(title);
    }
    protected double getAmount(int day) {
        double amount = 2;
        if (day > 2) {
            amount += (day - 2) * 1.5;
        }
        return amount;
    }

    protected int getFrequentRenterPoints(int day) {
        return 1;
    }
}
