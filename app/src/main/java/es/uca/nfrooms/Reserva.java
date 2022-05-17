package es.uca.nfrooms;

public class Reserva {
    private String name;
    private int number;

    public Reserva(int number, String name){
        this.number = number;
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
}