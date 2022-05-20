package project.java;

public class FilterAppartmentAgerImpl extends FilterAppartmentAbstract {

    @Override
    public boolean filter(AppartmentData appartmentData) {
        System.out.println("ager");
        if(appartmentData.getAge()<50) {
            return true;
        }
        return false;
    }
}
