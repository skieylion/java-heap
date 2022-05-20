package project.java;

import java.util.Objects;

public abstract class FilterAppartmentAbstract implements FilterAppartment {

    FilterAppartment parent;

    public void post(AppartmentData appartmentData) {
        if (filter(appartmentData) && Objects.nonNull(parent)) {
            parent.post(appartmentData);
        }
    }

    public void setParent(FilterAppartment parent) {
        this.parent = parent;
    }
}
