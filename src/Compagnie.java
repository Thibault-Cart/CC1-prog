
/*
 * Auteur:Thibault Cart
 * Date:27.03.2023
 * description: Application permantant la gestion d'un aeroport, fait dans le cadre du CC du lundi 27.03.2023
 */
import java.util.ArrayList;

public class Compagnie {

    // initialisations des proprietes
    private String nom;
    private String pays;
    private ArrayList<Avion> avions = new ArrayList<Avion>();

    // constructeur
    public Compagnie(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;

    }
    // methodes toString en override pour retourner le contenu de l'objet

    @Override
    public String toString() {

        return nom + " [" + pays + "]";
    }

    /*
     * Fonction permettant l'ajout d'un avion a l'ArrayList contenant la flotte actuel de la compagnie 
     */
    public void ajouterAvion(Avion a) {
        // ajout de l'avion passé en parametres a l'ArrayList des avions de la
        // compagnies
        this.avions.add(a);
    }

    // region getter setter pour acceder au valeur de l'objet

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public ArrayList<Avion> getAvions() {
        return this.avions;
    }

    public void setAvions(ArrayList<Avion> avions) {
        this.avions = avions;
    }

    // endregion
}
