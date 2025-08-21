package dev.paula.movie.vo;

import java.util.Arrays;
import java.util.List;

public class ShortInfoVO {
    
    private String name;
    private List<String> genres;
    private String releaseYear;


    public String getName() {
        return name;
    }

    public  List<String> getGenres() {
        return genres;
    }

    public String getreleaseYear() {
        return releaseYear;
    }



    @Override
    public boolean equals(Object obj){
        if (this == obj) 
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShortInfoVO other = (ShortInfoVO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (releaseYear == null) {
            if (other.releaseYear != null)
                return false;
        } if (Arrays.equals(genres, other.genres))
            return false;
        return true;
    }   

}
