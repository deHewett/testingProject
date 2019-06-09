package packer;

import java.util.Comparator;

/**
 *
 * @author I.M.Bad
 * 
 * This is used when we need to sort by product weight descending
 */
public class ProductWeightComparator implements Comparator<Product> {
    
    public int compare(Product a)
    {
        System.out.println("Please enter 2 values, a defualt has been added in substitute");
        Product b= new Product("b",0,false,false);
        int result = this.compare(a,b);
        return result;
    }
    
    public int compare(Product a, Product b) {
        if (a.getWeight() < b.getWeight()) {return 1;}
        else if (a.getWeight() > b.getWeight()) {return -1;}
        else if (a.getWeight() == b.getWeight()) {return -1;}
        else return a.getName().compareTo(b.getName());
    }
                
}
