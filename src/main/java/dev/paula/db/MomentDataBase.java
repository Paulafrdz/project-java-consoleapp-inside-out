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

    @Override
    public void store(Moment moment){
        moments.add(moment);
    }

    @Override
    public List<Moment> getAll() {
        return moments;
    }
    
    @Override
    public void deleteById(int id) {
        moments.removeIf(moment -> moment.getId() == id);
    }

}