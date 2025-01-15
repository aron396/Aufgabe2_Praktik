package model;

import java.util.List;

public class Patient {

    private int id;
    private String name;
    private int alter;
    private String diagnose;
    private List<Medikament> medikamente;

    public Patient(int id, String name, int alter, String diagnose, List<Medikament> medikamente) {
        this.id = id;
        this.name = name;
        this.alter = alter;
        this.diagnose = diagnose;
        this.medikamente = medikamente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public List<Medikament> getMedikamente() {
        return medikamente;
    }

    public void setMedikamente(List<Medikament> medikamente) {
        this.medikamente = medikamente;
    }
}
