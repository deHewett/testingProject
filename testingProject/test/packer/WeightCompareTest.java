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
public class WeightCompareTest {
    
    ProductWeightComparator comparator = new ProductWeightComparator();
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing ProductWeightComparator class...");
    }
    
    
    /**
     * Test of compare method, of class ProductWeightComparator.
     */
    
    @Test
    public void testCompare()
    {
        Product a = new Product("a",1,false,false);
        Product b = new Product("b",2,false,false);
        Product c = new Product("c",3,false,false);
        Product d = new Product("d",4,false,false);
        Product e = new Product("e",5,false,false);
        Product f = new Product("f",5,false,false);
        Product g = new Product("g",2,false,false);
        
        System.out.println("Tests to see whether product one is heavier than product 2");
        
        System.out.println("Product 1: " +b.getWeight() + " Product 2: " + a.getWeight());
        
        Assert.assertEquals(-1,comparator.compare(b,a));
        
        System.out.println("Product 1: " +c.getWeight() + " Product 2: " + b.getWeight());
        
        Assert.assertEquals(-1,comparator.compare(c,b));
        
        System.out.println("Tests 2 products of equal weight");
        
        System.out.println("Product 1: " +e.getWeight() + " Product 2: " + f.getWeight());
        
        
        Assert.assertEquals(-1,comparator.compare(e,f));
        
        System.out.println("Product 1: " +g.getWeight() + " Product 2: " + b.getWeight());
        
        Assert.assertEquals(-1,comparator.compare(b,g));
        
        System.out.println("Testing with only 1 input");
        
        Assert.assertEquals(-1,comparator.compare(a));
        Assert.assertEquals(-1,comparator.compare(b));
        Assert.assertEquals(-1,comparator.compare(c));
        Assert.assertEquals(-1,comparator.compare(d));
    }
    
    
}
