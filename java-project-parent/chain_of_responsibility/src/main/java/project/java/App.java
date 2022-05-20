package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        FilterAppartmentAbstract filterCountRoom = new FilterAppartmentAbstract() {
            @Override
            public boolean filter(AppartmentData appartmentData) {
                System.out.println("count_room");
                if (appartmentData.getCountRoom() < 5) {
                    return true;
                }
                return false;
            }
        };

        FilterAppartmentAbstract pricer = new FilterAppartmentPricerImpl();
        pricer.setParent(filterCountRoom);

        FilterAppartmentAbstract ager = new FilterAppartmentAgerImpl();
        ager.setParent(pricer);

        SearchAppartment searchAppartment = new SearchAppartment(ager);
        searchAppartment.go(new AppartmentData(50.0, 20.0, 2, 4));

        System.out.println("Hello World!");
    }
}
