package dev.paula.db;

import java.util.ArrayList;
import java.util.List;

import dev.paula.contracts.InterfaceDataBase;
import dev.paula.models.Moment;

public class MomentDataBase implements InterfaceDataBase{
    private List<Moment> moments;

    public MomentDataBase(){
        this.moments = new ArrayList<>();
    }

    public void store(Moment moment){
        moments.add(moment);
    }
    public List<Moment> getAll() {
        return moments;
    }

    public void deleteById(int id) {
        moments.removeIf(moment -> moment.getId() == id);
    }

}