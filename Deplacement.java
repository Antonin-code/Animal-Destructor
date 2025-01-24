import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Deplacement {
    /**
     * Permet de gérer le déplacement d'un joueur dans le jeu en fonction des commandes saisies.
     *
     * @param JoueurIcone  L'icône représentant le joueur sur la grille (ex : 🐷, 🐔, 🐰, 🦊).
     * @param tour         Le numéro du tour actuel, utilisé pour identifier quel joueur joue.
     * @param coordonnees  Un tableau contenant les coordonnées actuelles du joueur (coordonnees[0] = ligne, coordonnees[1] = colonne).
     * @param grille       La grille du jeu représentant l'état actuel du terrain.
     *
     * <p>Le joueur peut utiliser les commandes suivantes pour se déplacer :
     * <ul>
     *     <li>Z : Monter d'une case (haut)</li>
     *     <li>S : Descendre d'une case (bas)</li>
     *     <li>Q : Aller à gauche</li>
     *     <li>D : Aller à droite</li>
     * </ul>
     * Si le joueur tente de marcher sur une case non valide (par exemple, une case contenant 🔥 ou un autre joueur),
     * le déplacement est annulé et une alerte est affichée.</p>
     *
     * <p>Le joueur peut également entrer "EXIT" pour quitter la partie.</p>
     *
     * <h3>Exemple d'utilisation :</h3>
     * <pre>
     * {@code
     * String[][] grille = Generation.CreationTerrain();
     * short[] position = {5, 5};
     * Deplacement.DeplacementJoueur("🐰", 1, position, grille);
     * }
     * </pre>
     */

    public static void DeplacementJoueur(String JoueurIcone, int tour, short[] coordonnees,String[][] grille, Object PseudoActuel) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String commande;

        System.out.println("Vous pouvez a tout moment regarder les regles avec r ou quitter le jeu avec l");
        System.out.println("Utilisez Z (haut), S (bas), Q (gauche), D (droite) pour vous déplacer.");

        boolean hasmoved = false;
        while (!hasmoved) {
            Generation.Affichage(grille);

            // Indique quel joueur doit jouer
            System.out.println("Tour du joueur " + PseudoActuel + " (" + JoueurIcone + ")");
            System.out.print("Entrez une commande : ");
            commande = scanner.nextLine().toUpperCase();

            // Nouvelles coordonnées
            short nouvelleX = coordonnees[0];
            short nouvelleY = coordonnees[1];

            // Gestion des déplacements
            switch (commande) {
                case "Z": nouvelleX--; break; // Haut
                case "S": nouvelleX++; break; // Bas
                case "Q": nouvelleY--; break; // Gauche
                case "D": nouvelleY++; break; // Droite
                case "R": Choix.regles_Jeu(grille);break;
                case "M": Menu.Debut(); break;
                case "L": Menu.Quitter(); break;
                case "EXIT":
                    System.out.println("Merci d'avoir joué !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Commande invalide ! Utilisez Z, S, Q ou D.");
                    continue;
            }

            // Vérifie si la nouvelle position est valide
            if (grille[nouvelleX][nouvelleY].equals("🔥")) {
                System.out.println("Vous ne pouvez pas marcher dans le feu !");
                continue;
            }

            // Empêche les joueurs de se marcher dessus
            else if (!grille[nouvelleX][nouvelleY].equals("🟩")){
                System.out.println("Vous ne pouvez pas marcher sur un autre joueur !");
                continue;
            }

            // Met à jour la grille : efface la position actuelle du joueur
            grille[coordonnees[0]][coordonnees[1]] = "🟩"; // Remet une case verte
            grille[nouvelleX][nouvelleY] = JoueurIcone; // Place le joueur

            coordonnees[0] = nouvelleX;
            coordonnees[1] = nouvelleY;
            hasmoved = true;
        }
    }
}
