import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * classe Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Execute la fonction debut dans le main
        Sauvegarde.creerFichier("FichierScore");
        Menu.Debut();
        List<String> listeJoueurs = Menu.Pseudo();
        short tailleListe = (short)listeJoueurs.size();
        Sauvegarde sauvegarde = new Sauvegarde();
        Jeu.LancerJeu(tailleListe, listeJoueurs);
        Sauvegarde.ajoutPseudo(listeJoueurs);

        // while (true) {

    }
}
