import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * classe Main
 */
public class Main {

    public static void main(String[] args) {
        // Execute la fonction debut dans le main
        Menu.Debut();
        List<String> listeJoueurs = Menu.Pseudo();
        short tailleListe = (short)listeJoueurs.size();
        System.out.println(listeJoueurs);
        Jeu.LancerJeu(tailleListe, listeJoueurs);
        // while (true) {

    }
}
