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
 * @author daedh
 */
public class ManifestTest {
    
    static Manifest testManifest = new Manifest();
    static Product initTestProduct1, initTestProduct2 ,initTestProduct3 ,initTestProduct4 ,initTestProduct5, initTestProduct6;
    
    public static void init(){
    
    initTestProduct1 = new Product("Hammer", 3, false, false);
    initTestProduct2 = new Product("Nails", 1, false, false);
    initTestProduct3 = new Product("Ladder", 15, false, false);
    initTestProduct4 = new Product("Saw", 5, false, false);
    initTestProduct5= new Product("Light Bulbs", 1, false, true);
    initTestProduct6= new Product("Weedkiller", 2, true, false);
        
    testManifest.addProduct(initTestProduct1, 1);
    testManifest.addProduct(initTestProduct2, 12);
    testManifest.addProduct(initTestProduct3, 2);
    testManifest.addProduct(initTestProduct4, 1);
    testManifest.addProduct(initTestProduct5, 20);
    testManifest.addProduct(initTestProduct6, 1);
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
        
        init();
        
    }
    
    /*
        Test of addProduct method, of class Manifest
    */
    @Test
    public void testAddProduct()
    {
        Product testProduct = new Product("Test Product", 5, false, false);
        testManifest.addProduct(testProduct, 3);
        
        System.out.println(testManifest.toString());
        
        Assert.assertTrue(testManifest.toString().contains("Test Product x 3"));
        
        Product testProduct2 = new Product("Test Product2", 3, false, false);
        Product testProduct3 = new Product("Test Product3", 2, false, false);
        Product testProduct4 = new Product("Test Product4", 1, false, false);
        testManifest.addProduct(testProduct2, 3);
        testManifest.addProduct(testProduct3, 4);
        testManifest.addProduct(testProduct4, 5);
        
        System.out.println(testManifest.toString());
        
        Assert.assertTrue(testManifest.toString().contains("Test Product2 x 3"));
        Assert.assertTrue(testManifest.toString().contains("Test Product3 x 4"));
        Assert.assertTrue(testManifest.toString().contains("Test Product4 x 5"));
    }
    
    /*
        Test of removeProduct method, of class Manifest
    */
    @Test
    public void testRemoveProduct()
    {
        Product notIncluded = new Product("Not Included Item", 10, false, false);
        
        System.out.println(testManifest.toString());
        
        System.out.println("Remove Ladder");
        
        testManifest.removeProduct(initTestProduct3);
        
        System.out.println(testManifest.toString());
        
        Assert.assertTrue(!testManifest.toString().contains("Ladder x 2"));
        
        System.out.println("Remove Nails");
        
        testManifest.removeProduct(initTestProduct2);
        
        System.out.println(testManifest.toString());
        
        Assert.assertTrue(!testManifest.toString().contains("Nails x 12"));
        
        try {
            testManifest.removeProduct(notIncluded);
        }
        catch(Exception e){
            System.out.println("That product is not included in the manifest");
            Assert.assertTrue(true);
        }
        
        
        
        
    }
    /*
        Test of getTotalWeight method, of class Manifest
    */
    @Test
    public void testGetTotalWeight()
    {
        
        testManifest = new Manifest();
        
        testManifest.addProduct(initTestProduct1, 1);
        testManifest.addProduct(initTestProduct2, 12);
        testManifest.addProduct(initTestProduct3, 2);
        testManifest.addProduct(initTestProduct4, 1);
        testManifest.addProduct(initTestProduct5, 20);
        testManifest.addProduct(initTestProduct6, 1);
        
        double targetWeight = 72;
        
        
        Assert.assertEquals(targetWeight, testManifest.getTotalWeight());
        
        testManifest.addProduct(initTestProduct3, 2);
        
        targetWeight = targetWeight + ((double)initTestProduct3.getWeight()*2);
        
        Assert.assertEquals(targetWeight, testManifest.getTotalWeight());
    }
    
    /*
        Test of getHeaviestUnder method, of class Manifest
    */
    @Test
    public void testGetHeaviestUnder()
    {
        
        testManifest = new Manifest();
        
        testManifest.addProduct(initTestProduct1, 1);
        testManifest.addProduct(initTestProduct2, 12);
        testManifest.addProduct(initTestProduct3, 2);
        testManifest.addProduct(initTestProduct4, 1);
        testManifest.addProduct(initTestProduct5, 20);
        testManifest.addProduct(initTestProduct6, 1);
        
        System.out.println("Heaviest item under 10. Expected: Saw");
        
        Assert.assertTrue(testManifest.getHeaviestUnder(10).getName().contains("Saw"));
        
        System.out.println("Heaviest item under 5. Expected: Hammer");
        
        Assert.assertTrue(testManifest.getHeaviestUnder(4).getName().contains("Hammer"));
        
    }
}
