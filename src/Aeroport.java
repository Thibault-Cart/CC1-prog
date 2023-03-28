
/*
 * Auteur:Thibault Cart
 * Date:27.03.2023
 * description: Application permantant la gestion d'un aeroport, fait dans le cadre du CC du lundi 27.03.2023
 */
import java.util.ArrayList;

public class Aeroport {

    private static ArrayList<Compagnie> compagnies = new ArrayList<Compagnie>();
    static Avion[] placeDisponible = new Avion[7];

    final static int TAILLE_AEROPORT = 7;

    public static void main(String[] args) {

        // Ne pas modifier !
        Avion a1 = new Avion(1, "Boeing", "747");
        Avion a2 = new Avion(2, "Boeing", "707");
        Avion a3 = new Avion(3, "Boeing", "720");
        Avion a4 = new Avion(4, "Boeing", "787");
        Avion a5 = new Avion(5, "Boeing", "747");
        Avion a6 = new Avion(6, "Boeing", "747");
        Avion a7 = new Avion(7, "Airbus", "A320");
        Avion a8 = new Avion(8, "Airbus", "A300");
        Avion a9 = new Avion(9, "Airbus", "A310");
        Avion a10 = new Avion(10, "Airbus", "A300");
        Avion a11 = new Avion(11, "Airbus", "A320");
        Avion a12 = new Avion(12, "Airbus", "A300");
        Avion a13 = new Avion(13, "Airbus", "A320");
        Compagnie c1 = new Compagnie("Lufthansa", "Allemagne");
        Compagnie c2 = new Compagnie("TAP", "Portugal");
        Compagnie c3 = new Compagnie("Swiss", "Suisse");
        Compagnie c4 = new Compagnie("Air France", "France");
        Compagnie c5 = new Compagnie("KLM", "Pays-Bas");
        Compagnie c6 = new Compagnie("Iberia", "Espagne");
        Compagnie c7 = new Compagnie("British Airways", "Angleterre");
        Compagnie c8 = new Compagnie("EasyJet", "Angleterre");
        compagnies.add(c1);
        compagnies.add(c2);
        compagnies.add(c3);
        compagnies.add(c4);
        compagnies.add(c5);
        compagnies.add(c6);
        compagnies.add(c7);
        compagnies.add(c8);
        c1.ajouterAvion(a1);
        c1.ajouterAvion(a2);
        c1.ajouterAvion(a3);
        c2.ajouterAvion(a4);
        c2.ajouterAvion(a5);
        c3.ajouterAvion(a6);
        c3.ajouterAvion(a7);
        c4.ajouterAvion(a8);
        c4.ajouterAvion(a9);
        c5.ajouterAvion(a10);
        c6.ajouterAvion(a11);
        c7.ajouterAvion(a12);
        c8.ajouterAvion(a13);

        // Fonctionnalités demandées - Ne pas modifier
        System.out.println("\n------------------ Affichage des compagnies par Pays ---------------------");
        afficherCompagniesParPays("Angleterre");
        afficherCompagniesParPays("Belgique");
        System.out.println("\n------------------ Atterrissage des avions ---------------------");
        atterir(a1);
        atterir(a12);
        atterir(a3);
        atterir(a11);
        atterir(a10);
        atterir(a5);
        atterir(a6);
        atterir(a7);

    }

    // A développer

    /*
     * Fonction prenant en parametres un pays et regardant pour toutes les
     * compagnies si elle sont de la nationalité donne en parametres
     */
    public static void afficherCompagniesParPays(String pays) {
        boolean compagnieVide = true;
        System.out.println("\nAffichage des compagnies du pays : " + pays);
        // parcours toutes les compagnies de la arraylist compagnie
        for (Compagnie compagnie : compagnies) {
            // si le pays correspond
            if (compagnie.getPays() == pays) {
                compagnieVide = false;
                System.out.println("    - " + compagnie.toString());
            }

        }
        // si aucune compagnie de cette nationalité affiche message l'indiquant
        if (compagnieVide == true) {
            System.out.println("    - Aucune compagnie");
        }
    }

    /*
     * Fonction permetant de trouver la compagnie possedant lavion passé en
     * parametre
     */
    public static String trouverCompagnie(Avion a) {
        String retour = "";
        // parcour chaque comapgnie de la arralistcompagnie
        for (Compagnie compagnie : compagnies) {
            // si la compagnie contient l'avion a dans ca flotte la variable retour prend
            // comme valeur le nom de la dite compagnie
            if (compagnie.getAvions().contains(a)) {
                retour = compagnie.getNom();
            }
        }
        return retour;
    }

    /*
     * Fonction comptant le nombre d'avion deja present dans le tableau
     * placeDisponible
     */
    public static int nbAvion() {
        int resultat = 0;
        // pour chaque avion dans tableau placedisponible
        for (Avion a : placeDisponible) {
            if (a != null) {
                // si avion est pas null alors resultat ce voit ajouter 1
                resultat++;
            }
        }
        return resultat;

    }

    public static void atterir(Avion a) {
        // compagnie avion se voit attribuer le nom de la compagnie possedant l'avion a
        String compagnieAvion = trouverCompagnie(a);
        // si l'avion n'est a aucune compagnie affiche message et refus d'atterissage
        if (compagnieAvion == "") {
            System.out.println(
                    "L'avion" + a.toString() + "appartien aucune compagnie et est donc refusé a l'atterissage");
        } else {
            // si il reste de la place dans laeroport
            if (nbAvion() < TAILLE_AEROPORT) {
                System.out.println("Atterissage de l'avion " + a.toString() + " de la compagnie " + compagnieAvion);

                // ajout de lavion au tableau placeDisponible
                if (nbAvion() == 0) {
                    placeDisponible[0] = a;
                } else {
                    placeDisponible[nbAvion()] = a;
                }

            } else {
                // si l'aeroport est plein affiche message informant l'utilisateur
                System.out.println("/! Atterissage impossible de l'avion " + a.toString() + " de la compagnie "
                        + compagnieAvion + "! Pas de place dans l'aeroport ! ");
            }
        }
    }
}
