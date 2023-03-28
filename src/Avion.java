/*
 * Auteur:Thibault Cart
 * Date:27.03.2023
 * description: Application permantant la gestion d'un aeroport, fait dans le cadre du CC du lundi 27.03.2023
 */
public class Avion {

    // Declaration proprietes
    private int id;
    private String marque;
    private String modele;

    // constructeur
    public Avion(int id, String marque, String modele) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
    }

    // methodes toString en override pour retourner les contenu de l'instance
    // d'avion
    @Override
    public String toString() {
        return "id : " + this.id + " de marque/modele : " + this.marque + " " + this.modele;
    }

    // region getter Setter pour acceder au valeur de l'objet
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return this.modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    // endregion

}
