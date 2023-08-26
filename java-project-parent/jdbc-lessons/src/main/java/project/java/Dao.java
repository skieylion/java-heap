package project.java;

import java.util.List;
import java.util.Optional;

public interface Dao<K, V> {
    V save(V entity);

    Optional<V> read(K entityId);

    boolean delete(K entityId);

    void update(V entity);
}
