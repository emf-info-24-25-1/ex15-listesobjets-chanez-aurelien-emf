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
        nbPersonnes = 0;
    }

    public boolean ajouter(Personne p) {
        boolean condition = false;
        /*
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] == null) {
                personnes[i] = p;
                nbPersonnes++;
                condition = true;
                break;
            }
        } 
        */
        if (nbPersonnes < personnes.length) {
            personnes[nbPersonnes] = p;
            nbPersonnes++;
            condition = true;
        }

        return condition;
    }

    public boolean supprimer(Personne p) {
        boolean condition = false;
        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i] == p) {
                personnes[i] = null;
                for (int j = i; j < personnes.length; j++) {
                    if (personnes[j] == null) {
                        if (j != personnes.length - 1) {
                            personnes[j] = personnes[j + 1];
                            personnes[j + 1] = null;
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
            if (personnes[i] != null) {
                System.out.println(personnes[i] + " | ");
            }
        }
        

    }

}
