package model;

public class Medikament {

    private String name;
    private double preis;
    private String krankheit;

    public Medikament(String name, double preis, String krankheit) {
        this.name = name;
        this.preis = preis;
        this.krankheit = krankheit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getKrankheit() {
        return krankheit;
    }

    public void setKrankheit(String krankheit) {
        this.krankheit = krankheit;
    }
}
