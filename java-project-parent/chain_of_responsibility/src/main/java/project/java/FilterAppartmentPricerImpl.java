package project.java;

public class FilterAppartmentPricerImpl extends FilterAppartmentAbstract {
    @Override
    public boolean filter(AppartmentData appartmentData) {
        System.out.println("pricer");
        if (appartmentData.getPrice() < 1_000_000) {
            return true;
        }
        return false;
    }
}
