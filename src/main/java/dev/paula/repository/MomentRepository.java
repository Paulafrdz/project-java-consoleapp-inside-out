package dev.paula.repository;

import java.util.List;

import dev.paula.contracts.InterfaceDatabase;
import dev.paula.models.*;
import dev.paula.db.MomentDataBase;


public class MomentRepository {

    private InterfaceDatabase db;

    public MomentRepository(){
        this.db = new MomentDataBase();
    }

    public void StoreMoment(Moment moment) {
        db.store(moment);

    }

    public List<Moment> getAllMoments(){
        return db.getAll();
    }

    public void deleteMoment(int id) {
        db.deleteById(id);
    }

   
}
