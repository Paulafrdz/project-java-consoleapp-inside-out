package dev.paula.contracts;

import java.util.List;
import dev.paula.models.Moment;

public interface InterfaceDatabase {
    public void store(Moment moment);
    public List<Moment> getAll();
    public void deleteById(int id);
}
