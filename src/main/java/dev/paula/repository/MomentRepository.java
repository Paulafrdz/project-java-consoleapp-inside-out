package dev.paula.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dev.paula.contracts.InterfaceDataBase;
import dev.paula.models.*;
import dev.paula.db.MomentDataBase;


public class MomentRepository {

    private InterfaceDataBase db;

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

    public List<Moment> findByEmotions(Emotion emotion){
        List<Moment> result = new ArrayList<>();
        for (Moment m : db.getAll()) {
            if (m.getEmotion() == emotion ) result.add(m);
        }
        return result;
    }

   public List<Moment> getMomentsByDate(int month) {
        List<Moment> filtered = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for (Moment moment : db.getAll()) {
            calendar.setTime(moment.getDate());

            if (calendar.get(Calendar.MONTH) + 1 == month){
                filtered.add(moment); 
            }
        }
        return filtered;
    }


   
}
