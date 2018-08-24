package rentalstore;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer = new Customer("Terry");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("Rental Record for Terry\nAmount owed is 0.0\nYou earned 0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }
}