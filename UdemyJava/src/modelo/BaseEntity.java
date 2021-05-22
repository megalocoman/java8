package modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int ultimoId;

    public BaseEntity() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object b) {
        if (this == b) return true;
        if (b == null || getClass() != b.getClass()) return false;
        BaseEntity base = (BaseEntity) b;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
