package model;

public class Medikament {

    private String name;
    private String preis;
    private String krankheit;

    public Medikament(String name, String preis, String krankheit) {
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

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public String getKrankheit() {
        return krankheit;
    }

    public void setKrankheit(String krankheit) {
        this.krankheit = krankheit;
    }
}
