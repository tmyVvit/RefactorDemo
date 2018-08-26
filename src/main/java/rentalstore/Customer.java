package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

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
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while(rentals.hasMoreElements()){
            Rental each = rentals.nextElement();
            double thisAmount =each.getAmount();
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }

        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        double totalAmount = 0;
        double frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("<H1>Rental Record for <EM>" + getName() + "</EM><H1><P>\n");
        while(rentals.hasMoreElements()){
            Rental each = rentals.nextElement();
            double thisAmount =each.getAmount();
            frequentRenterPoints += each.getFrequentRenterPoints();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("<BR>\n");
            totalAmount += thisAmount;
        }

        result.append("<P>Amount owed is <EM>").append(String.valueOf(totalAmount)).append("</EM><P>\n");
        result.append("You earned <EM>").append(String.valueOf(frequentRenterPoints)).append("</EM> frequent renter points");
        return result.toString();
    }



}
