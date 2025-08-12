package dev.paula.repository;

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
}
