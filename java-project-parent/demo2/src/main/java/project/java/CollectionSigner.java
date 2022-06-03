package project.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionSigner {
    private String name;
    private String position;

    @Override
    public int hashCode() {
        int x = Objects.hashCode(this.name);
        int y = Objects.hashCode(this.position);
        return x * y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        else if (Objects.nonNull(obj) && obj instanceof CollectionSigner) {
            CollectionSigner other = (CollectionSigner) obj;
            return Objects.equals(this.getName(), other.getName()) && Objects.equals(this.getPosition(), other.getPosition());
        }
        return false;
    }
}
