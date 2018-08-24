package rentalstore;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer = new Customer("Terry");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("Rental Record for Terry\nAmount owed is 0.0\nYou earned 0.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new RegularMovie("Titanic");
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new RegularMovie("Titanic");
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + regularMovie.getTitle() + "\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new ChildrensMovie("Titanic");
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new ChildrensMovie("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + childrenMovie.getTitle() + "\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_no_rental() {
        String statement = customer.htmlStatement();
        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n<P>Amount owed is <EM>0.0</EM><P>\nYou earned <EM>0.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_regular_movie_for_1_day(){
        Movie regularMovie = new RegularMovie("Titanic");
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n" +
                "\t" + regularMovie.getTitle() + "\t2.0<BR>\n" +
                "<P>Amount owed is <EM>2.0</EM><P>\n" +
                "You earned <EM>1.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new RegularMovie("Titanic");
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n" +
                "\t" + regularMovie.getTitle() + "\t3.5<BR>\n" +
                "<P>Amount owed is <EM>3.5</EM><P>\n" +
                "You earned <EM>1.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0<BR>\n" +
                "<P>Amount owed is <EM>3.0</EM><P>\n" +
                "You earned <EM>1.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n" +
                "\t" + newReleaseMovie.getTitle() + "\t6.0<BR>\n" +
                "<P>Amount owed is <EM>6.0</EM><P>\n" +
                "You earned <EM>2.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new ChildrensMovie("Titanic");
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5<BR>\n" +
                "<P>Amount owed is <EM>1.5</EM><P>\n" +
                "You earned <EM>1.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day(){
        Movie childrenMovie = new ChildrensMovie("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>Terry</EM><H1><P>\n" +
                "\t" + childrenMovie.getTitle() + "\t3.0<BR>\n" +
                "<P>Amount owed is <EM>3.0</EM><P>\n" +
                "You earned <EM>1.0</EM> frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_art_movie_for_1_day() {
        Movie regularMovie = new ArtMovie("Titanic");
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Terry\n" +
                "\t" + regularMovie.getTitle() + "\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 1.5 frequent renter points", statement);
    }
}