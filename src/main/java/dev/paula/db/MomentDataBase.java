package dev.paula.db;

import java.util.ArrayList;
import java.util.List;

import dev.paula.models.Moment;

public class MomentDataBase{
    private List<Moment> moments;

    private MomentDataBase(){
        this.moments = new ArrayList<>();
    }

    public void store(Moment moment){
        moments.add(moment);
    }

}