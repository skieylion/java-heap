package project.java;

public class SearchAppartment {
    private final FilterAppartment filterAppartment;

    public SearchAppartment(FilterAppartment filterAppartment) {
        this.filterAppartment = filterAppartment;
    }

    public void go(AppartmentData appartmentData) {
        filterAppartment.post(appartmentData);
    }

}
