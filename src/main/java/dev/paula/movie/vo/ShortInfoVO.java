package dev.paula.movie.vo;

import java.util.Arrays;

public class ShortInfoVO {
    
    private String name;
    private String[] genre;
    private String releaseDate;


    public String getName() {
        return name;
    }

    public String[] getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
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
        if (releaseDate == null) {
            if (other.releaseDate != null)
                return false;
        } if (!Arrays.equals(genre, other.genre))
            return false;
        return true;
    }   

}
