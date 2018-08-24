package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        double totalAmount = 0;
        double frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            double thisAmount =each.getAmount();
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        double totalAmount = 0;
        double frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM><H1><P>\n";
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            double thisAmount =each.getAmount();
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "<BR>\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "<P>Amount owed is <EM>" + String.valueOf(totalAmount) + "</EM><P>\n";
        result += "You earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points";
        return result;
    }



}
