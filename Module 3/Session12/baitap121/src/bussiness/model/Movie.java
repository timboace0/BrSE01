package bussiness.model;

import java.time.LocalDate;

public class Movie {
    private int id;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private float rating;

    public Movie(int id, String title, String director, LocalDate releaseDate, float rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Title: %-15s | Director: %-15s | Release Date: %-15s | Rating: %-4.1f",
                id,title,director,releaseDate,rating);
    }
}
