package rentalstore;

public class ArtMovie extends Movie {
    public ArtMovie(String title) {
        super(title);
    }
    protected double getAmount(int day) {
        return 6*day;
    }

    protected double getFrequentRenterPoints(int day) {
        return 1.5;
    }
}
