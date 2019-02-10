package pl.edu.wszib.springtalkingwithworld.model;

public class Restaurant {


    public static double visitCost(Customer customer){
        double result = 25d;
        if (customer.partner){
            result+=15;
        }

        if (customer.child){
            result+=40;
        }

        if (customer.pet){
            result+=20;
        }

        return result;
    }

}
