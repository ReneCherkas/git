package Classes;

import java.time.LocalDateTime;

public class Person {
    private static long ID = 0;
    private  long id = ++ID;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Color eyeColor;
    private ColorHair hairColor;
    private Country nationality;
    private Location location;

    public Person(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Color eyeColor, ColorHair hairColor, Country nationality, Location location) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.creationDate = creationDate;
    this.eyeColor = eyeColor;
    this.hairColor = hairColor;
    this.nationality = nationality;
    this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Color getColor() {
        return eyeColor;
    }

    public ColorHair getColorHair() {
        return hairColor;
    }

    public void setColorHair(ColorHair hairColor) {
        this.hairColor = hairColor;
    }

    public Country getCountry() { return nationality; }

    public void setCountry(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() { return location; }


    @Override
    public String toString() {
        return String.format("Идентификатор: %d%n" +
                        "Имя: %s%n" +
                        "Координата X : %s%n" +
                        "Координата Y : %s%n" +
                        "Дата создания: %s%n" +
                        "Цвет глаз: %s%n" +
                        "Цвет волос: %s%n" +
                        "Национальность: %s%n" +
                        "Локация: %n" +
                        "X: %d%n"+
                        "y: %d%n"+
                        "z: %d",
                id, name, coordinates.getX(), coordinates.getY(), creationDate, eyeColor, hairColor, nationality, location.getX(),location.getY(),location.getZ());
    }
}
