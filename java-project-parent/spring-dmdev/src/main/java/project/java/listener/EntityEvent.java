package project.java.listener;

import lombok.Getter;

import java.util.EventObject;

@Getter
public class EntityEvent extends EventObject {
    private final AccessType accessType;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }


}
