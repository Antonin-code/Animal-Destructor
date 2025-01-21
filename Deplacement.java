import java.util.Scanner;

public class Deplacement {

    public static void main(String[] args) {
        // déplacement avec plusieurs joueurs
        DeplacementMultiJoueur();
    }

    public static void DeplacementMultiJoueur() {
        String[][] grille = Generation.CreationTerrain();

        // Positions initiales des joueurs
        int joueur1X = 5, joueur1Y = 7; // Joueur 1 (🐷)
        int joueur2X = 6, joueur2Y = 7; // Joueur 2 (🐔)
        int joueur3X = 5, joueur3Y = 5; // Joueur 3 (🐰)
        int joueur4X = 6, joueur4Y = 5; // Joueur 4 (🦊)
        grille[joueur1X][joueur1Y] = "🐷";
        grille[joueur2X][joueur2Y] = "🐔";
        grille[joueur3X][joueur3Y] = "🐰";
        grille[joueur4X][joueur4Y] = "🦊";

        Scanner scanner = new Scanner(System.in);
        String commande;
        int tour = 1; // Tour : 1 = joueur1, 2 = joueur2, etc.

        System.out.println("Bienvenue dans le jeu multi-joueurs !");
        System.out.println("Utilisez Z (haut), S (bas), Q (gauche), D (droite) pour vous déplacer.");
        System.out.println("Joueurs : 🐷, 🐔, 🐰, 🦊.");

        while (true) {
            Generation.Affichage(grille);

            // Indique quel joueur doit jouer
            System.out.println("Tour du joueur " + tour + " (" + getJoueurEmoji(tour) + ")");
            System.out.print("Entrez une commande : ");
            commande = scanner.nextLine().toUpperCase();

            // Variables pour stocker les nouvelles positions
            int nouvelleX = 0, nouvelleY = 0;

            // Détermine quel joueur agit
            int joueurX = 0, joueurY = 0;
            switch (tour) {
                case 1 -> { joueurX = joueur1X; joueurY = joueur1Y; }
                case 2 -> { joueurX = joueur2X; joueurY = joueur2Y; }
                case 3 -> { joueurX = joueur3X; joueurY = joueur3Y; }
                case 4 -> { joueurX = joueur4X; joueurY = joueur4Y; }
            }
            nouvelleX = joueurX;
            nouvelleY = joueurY;

            // Gestion des déplacements
            switch (commande) {
                case "Z": nouvelleX--; break; // Haut
                case "S": nouvelleX++; break; // Bas
                case "Q": nouvelleY--; break; // Gauche
                case "D": nouvelleY++; break; // Droite
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
            if (positionOccupeeParUnJoueur(nouvelleX, nouvelleY, joueur1X, joueur1Y, joueur2X, joueur2Y, joueur3X, joueur3Y, joueur4X, joueur4Y)) {
                System.out.println("Vous ne pouvez pas marcher sur un autre joueur !");
                continue;
            }

            // Met à jour la grille : efface la position actuelle du joueur
            grille[joueurX][joueurY] = "🟩"; // Remet une case verte
            grille[nouvelleX][nouvelleY] = getJoueurEmoji(tour); // Place le joueur

            // Met à jour les positions
            switch (tour) {
                case 1 -> { joueur1X = nouvelleX; joueur1Y = nouvelleY; }
                case 2 -> { joueur2X = nouvelleX; joueur2Y = nouvelleY; }
                case 3 -> { joueur3X = nouvelleX; joueur3Y = nouvelleY; }
                case 4 -> { joueur4X = nouvelleX; joueur4Y = nouvelleY; }
            }

            // Change de joueur
            tour = (tour % 4) + 1; // Passe au joueur suivant (1 -> 2 -> 3 -> 4 -> 1)
        }
    }

    // Vérifie si une position est occupée par un joueur
    private static boolean positionOccupeeParUnJoueur(int x, int y, int j1X, int j1Y, int j2X, int j2Y, int j3X, int j3Y, int j4X, int j4Y) {
        return (x == j1X && y == j1Y) || (x == j2X && y == j2Y) || (x == j3X && y == j3Y) || (x == j4X && y == j4Y);
    }

    // Retourne l'emoji du joueur selon son numéro
    private static String getJoueurEmoji(int joueur) {
        return switch (joueur) {
            case 1 -> "🐷";
            case 2 -> "🐔";
            case 3 -> "🐰";
            case 4 -> "🦊";
            default -> " ";
        };
    }
}
