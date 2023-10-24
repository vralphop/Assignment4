package Assignment4;

public class ManagementCompany extends Object {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private int propCount;
    private Plot plot;

    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.propCount = 0;
        this.plot = new Plot(x, y, width, depth);
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee);
        this.propCount = otherCompany.propCount;
        for (int i = 0; i < this.propCount; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (propCount >= MAX_PROPERTY) {
            return -1; 
        }
        if (property == null) {
            return -2; 
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3; 
        }
        for (int i = 0; i < propCount; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; 
            }
        }
        properties[propCount] = property;
        propCount++;
        return propCount - 1; 
    }

    public void removeLastProperty() {
        if (propCount > 0) {
            properties[propCount - 1] = null;
            propCount--;
        }
    }

    public boolean isPropertiesFull() {
        return propCount >= MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return propCount;
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < propCount; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentPropperty() {
        if (propCount == 0) {
            return null;
        }

        Property maxRentProperty = properties[0];
        for (int i = 1; i < propCount; i++) {
            if (properties[i].getRentAmount() > maxRentProperty.getRentAmount()) {
                maxRentProperty = properties[i];
            }
        }
        return maxRentProperty;
    }

    public boolean isMangementFeeValid() {
        return (mgmFee >= 0.0 && mgmFee <= 100.0);
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public Property[] getProperties() {
        return properties;
    }

    public double getMgmFeePer() {
        return mgmFee;
    }

    public Plot getPlot() {
        return plot;
    }
    public int getMaxProperty() {
        return MAX_PROPERTY;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Information of all properties in ").append(name).append(", taxID: ").append(taxID).append("\n");

        for (int i = 0; i < propCount; i++) {
            result.append(properties[i].toString()).append("\n");
        }

        return result.toString();
    }
}
