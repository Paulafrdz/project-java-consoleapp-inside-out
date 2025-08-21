package dev.paula.movie.dtos;

import dev.paula.movie.vo.ShortInfoVO;

import com.google.gson.annotations.SerializedName;

public class MovieDTO {
    
    private String imdbId;
    private String response; // Add this field
    private String error;

    @SerializedName("short")
    private ShortInfoVO shortInfo;

    public String getImdbId(){
        return imdbId;
    }

    public ShortInfoVO getShortInfo() {
        return shortInfo;
    }

    public String getResponse() {
        return response; // Add this getter
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
