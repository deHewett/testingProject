
import java.util.ArrayList;
import java.util.List;
import packer.Address;
import packer.Box;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;
import packer.Manifest;
import packer.Packer;
import packer.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bunta
 */
public class Example {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);
        System.out.println("\nDEPOT:");
        System.out.println(depot);
        
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);
        customer.addAddress(customerAddress2);
        System.out.println("\nCUSTOMER");
        System.out.println(customer);

        Manifest manifest = new Manifest();
        manifest.addProduct(new Product("Hammer", 3, false, false), 1);
        manifest.addProduct(new Product("Nails", 1, false, false), 12);
        manifest.addProduct(new Product("Ladder", 15, false, false), 2);
        manifest.addProduct(new Product("Saw", 5, false, false), 1);
        manifest.addProduct(new Product("Light Bulbs", 1, false, true), 20);
        manifest.addProduct(new Product("Weedkiller", 2, true, false), 1);
        
        System.out.println(manifest.toString());

        System.out.println("\nMANIFEST (to be packed):");
        System.out.println(manifest);

        System.out.println("\nPACKING:");
        List<Box> done = Packer.packProducts(customer, depot, manifest);

        
        // Results
        for (Box b : done) {
            System.out.println(b);
        }
        
    }
    
    
}
