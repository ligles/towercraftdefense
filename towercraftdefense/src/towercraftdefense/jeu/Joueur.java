package towercraftdefense.jeu;

/**
 * Created by SDOUGAMEHDI on 12/01/2016.
 */
public class Joueur {

    private String pseudo;
    private String nom;
    private String prenom;

    private Partie partie;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
    }

    public Joueur(String nom, String prenom, String pseudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }


    public void beginPartie(Partie partie){
        this.partie = partie;
    }
}
