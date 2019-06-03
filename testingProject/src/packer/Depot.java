package packer;

/**
 *
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name.toString();
    }
    
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    public String toString() {
        return this.getName();
    }
    
}
