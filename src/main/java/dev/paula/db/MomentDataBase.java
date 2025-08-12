package dev.paula.db;

import java.util.ArrayList;
import java.util.List;

import dev.paula.contracts.InterfaceDatabase;
import dev.paula.models.Moment;

public class MomentDataBase implements InterfaceDatabase{
    private List<Moment> moments;

    public MomentDataBase(){
        this.moments = new ArrayList<>();
    }

    public void store(Moment moment){
        moments.add(moment);
    }

}