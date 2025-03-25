package services;

import models.Personne;

public class ListePersonne_SansTrous {

    public final static int NBRE_MAX_PERSONNES = 6;

    private Personne[] personnes;
    private int nbPersonnes;

    public ListePersonne_SansTrous() {
        this.personnes = new Personne[NBRE_MAX_PERSONNES];
        this.nbPersonnes = 0;
    }

    public int getNombre() {
        return nbPersonnes;
    }

    public void vider() {
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] != null) {
                personnes[i] = null;
            }
        }
    }

    public boolean ajouter(Personne p) {
        boolean condition = false;
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] == null) {
                personnes[i] = p;
                nbPersonnes++;
                condition = true;
                break;
            }
        }
        return condition;
    }

    public boolean supprimer(Personne p) {
        boolean condition = false;
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] == p) {
                personnes[i] = null;
                for (int j = 0; j < personnes.length; j++) {
                    if (personnes[i] == null) {
                        if (i != personnes.length - 1) {
                            personnes[i] = personnes[i + 1];
                            personnes[i + 1] = null;
                        }
                    }
                }
                condition = true;
                break;
            }
        }
        return condition;
    }

    public void afficher() {
        for (int i = 0; i < personnes.length; i++) {
            System.out.println(personnes[i] + " | ");
        }
        

    }

}
