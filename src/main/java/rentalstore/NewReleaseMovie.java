package rentalstore;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title){
        super(title);
    }
    protected double getAmount(int day) {
        return day * 3.0;
    }

    protected int getFrequentRenterPoints(int day) {
        if(day>1){
            return 2;
        }
        return 1;
    }
}
