package Assignment4;

public class PropertyMgmDriverNoGui {

    public static void main(String[] args) {
        ManagementCompany mgmCompany = new ManagementCompany("Alliance", "1235", 10);

        System.out.println(mgmCompany.addProperty(new Property("Almost Aspen", "Glendale", 4844.0, "Sammy Smith", 2, 1, 2, 2)));
        System.out.println(mgmCompany.addProperty(new Property("Ambiance", "Lakewood", 4114.0, "Tammy Taylor", 4, 1, 2, 2)));
        System.out.println(mgmCompany.addProperty(new Property("Bear Creek Lodge", "Peninsula", 4905.0, "Bubba Burley", 6, 1, 2, 2)));
        System.out.println(mgmCompany.addProperty(new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 4, 4, 5, 5)));

        System.out.println("The property with the highest rent:");
        Property maxRentProperty = mgmCompany.getHighestRentPropperty();
        if (maxRentProperty != null) {
            System.out.println(maxRentProperty.getRentAmount());
        }

        System.out.println("Total Rent of the properties: " + mgmCompany.getTotalRent());
        System.out.println(mgmCompany.toString());
    }
}
