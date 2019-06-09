/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;


import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
/**
 *
 * @author bunta
 */
public class BoxTest {
    
    // Test data
    Product testProduct1 = new Product("test product 1", 5, false, false);
    Product testProduct2 = new Product("test product 2", 2, false, false);
    Product testProduct3 = new Product("test product 3", 1, false, false);
    Product hazardousProduct = new Product("Hazard-non-Fragile", 10, true, false);
    Product fragileProduct = new Product("Fragile-non-Hazard", 10, false, true);
    Product heavyProduct = new Product("Heavy Product", 20, false, false);
    Product aboveCapacity = new Product("Super Heavy", 100, false, false);
    
    
    
    Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
    Depot testDepot = new Depot("Main Depot", depotAddress);
    
    Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
    Customer testCustomer = new Customer("Andy Bravo", customerAddress1);
    
    Manifest testManifest = new Manifest();
    Box testBox = new Box(testCustomer, testDepot);
    
    List<Box> done;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    
    /**
     * Test of getLabel method, of class Box.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel regular products");
        testManifest.addProduct(testProduct1,1);
        testManifest.addProduct(testProduct2,1);
        testManifest.addProduct(testProduct3,1);
        
        done = Packer.packProducts(testCustomer, testDepot, testManifest);
        
        for (Box b : done) {
            Assert.assertTrue(b.getLabel().contains(testProduct1.getName()));
            Assert.assertTrue(b.getLabel().contains(testProduct2.getName()));
            Assert.assertTrue(b.getLabel().contains(testProduct3.getName()));
        }
        
        testManifest = new Manifest();
        System.out.println("getLabel Heavy product");
        testManifest.addProduct(heavyProduct,1);
        
        done = Packer.packProducts(testCustomer, testDepot, testManifest);
        
        for (Box b : done) {
            try{
            Assert.assertTrue(b.getLabel().contains("HEAVY"));
            }
            catch(Exception e){
                
            }
        }
        
        testManifest = new Manifest();
        System.out.println("getLabel Fragile product");
        testManifest.addProduct(fragileProduct,1);
        
        done = Packer.packProducts(testCustomer, testDepot, testManifest);
        
        for (Box b : done) {
            try{
            Assert.assertTrue(b.getLabel().contains("FRAGILE"));
            }
            catch(Exception e){
                Assert.assertTrue(false);
            }
        }
        
        testManifest = new Manifest();
        System.out.println("getLabel Hazardous product");
        testManifest.addProduct(hazardousProduct,1);
        
        done = Packer.packProducts(testCustomer, testDepot, testManifest);
        
        for (Box b : done) {
            try{
            Assert.assertTrue(b.getLabel().contains("HAZARDOUS"));
            }
            catch(Exception e){
                Assert.assertTrue(false);
            }
        }

    }
    
    /**
     * Test of addProduct method, of class Box.
     */
    @Test
    public void testAddProduct()
    {
        testBox.addProduct(new Product("regular",5,false,false));
        Assert.assertTrue(testBox.remainingCapacity()>=0);
        testBox = new Box(testCustomer, testDepot);
        
        testBox.addProduct(new Product("regular",20,false,false));
        Assert.assertTrue(testBox.remainingCapacity()>=0);
        testBox = new Box(testCustomer, testDepot);
        
        /*
            Tests to see if the product fails to add due to product weight exceeding the maximum capacity
        */
        testBox.addProduct(new Product("regular",50,false,false));
        Assert.assertTrue(testBox.remainingCapacity() == testBox.getCapacity());
        testBox = new Box(testCustomer, testDepot);
    }
    
    /*
        Test of getWieght method, of class Box
    */
    @Test
    public void testGetWeight()
    {
        Address depotAddress = new Address("23 Good Luck St", "Blue View", "Sandy Shores", "H337", new Coordinates(138, 995));
        Depot depot = new Depot("Main Depot", depotAddress);
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        Customer customer = new Customer("Andy Bravo", customerAddress1);
        customer.addAddress(customerAddress2);

        Manifest manifest = new Manifest();
        manifest.addProduct(new Product("Hammer", 3, false, false), 1);
        manifest.addProduct(new Product("Nails", 1, false, false), 12);
        manifest.addProduct(new Product("Ladder", 15, false, false), 2);
        manifest.addProduct(new Product("Saw", 5, false, false), 1);
        manifest.addProduct(new Product("Light Bulbs", 1, false, true), 20);
        manifest.addProduct(new Product("Weedkiller", 2, true, false), 1);

        List<Box> done = Packer.packProducts(customer, depot, manifest);

        
        // Results
        for (Box b : done) {
            Assert.assertTrue(b.getWeight() <= b.getCapacity());
        }
    }

    
}
