package com.epf.Core;

public class map {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    public map(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;

    }

    //getters:
    public int getId_map() {
        return id_map;
    }
    public int getLigne() {
        return ligne;
    }
    public int getColonne() {
        return colonne;
    }
    public String getChemin_image() {
        return chemin_image;
    }

    //setter:
    public void setId_map(int id_map) {
        this.id_map = id_map;
    }
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}

