package project.java;

import java.util.Optional;

public interface CrudRepository<K, V> {
    Optional<V> findById(K id);

    void deleteById(K id);
}
