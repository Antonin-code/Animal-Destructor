import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    // Fonction pour lancer le menu avec les options
    public static void Debut() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Bonjour bienvenue dans Animal-Destructor !! ");
        System.out.println("Voici les options possibles : ");
        System.out.println("--- P pour lancer une partie --- ");
        System.out.println("--- R pour lire les règles du jeu ---");
        System.out.println("--- Q pour quitter le jeu (mauvaise idée) ---");
        Scanner scan = new Scanner(System.in);
        String choix = scan.nextLine();

        // Rappele la fonction si le choix est different d'une lettre, exemple chiffre ou caractère spéciale
        if (choix.matches(".*[\\d-_&'(@ç!;:/?,+].*")) {
            System.out.println("Bien essayé Clément");
            System.out.println(" ");
            Debut();
        }
        // Choix pour jouer
        else if (choix.equals("P") || choix.equals("p")) {
            Jouer();
        }
        // Choix pour Regles
        else if (choix.equals("R") || choix.equals("r")) {
            Regles();
        }
        // Choix pour Quitter
        else if (choix.equals("Q") || choix.equals("q")) {
            Quitter();
        }
        // Rappele la fonction si le choix est different de P/R/Q
        else {
            System.out.println("Veuillez bien relire les options possibles : ");
            System.out.println(" ");
            Debut();
        }
    }

    // Fonction pour lancer le jeu
    public static void Jouer() {
        System.out.println("Jouer");
    }

    // Fonction pour lire les regles
    public static void Regles() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Bienvenue dans notre jeu de societe de stratégie sur plateau dans lequel vous pourrez piégés vos amis !!\n" +
                "Le jeu se joue de 2 a 4 joueur car jouer tous seul c'est triste.\n" +
                "Pour gagner il suffit d'enfermer votre adversaire, vous avez 1 deplacement et 1 case a bloquer par tour.\n" +
                "Le deplacement se fait avec Z Q S D, et les cases a bloquer avec des coordonnés exemple L5.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--- B pour quitter les regles et retourner au Menu (les regles c'est relou) --- ");
        System.out.println("--- Q Quitter le jeu (sa a l'air nul)---");
        Scanner scan = new Scanner(System.in);
        String Regles = scan.nextLine();
        if (Regles.matches(".*[\\d-_&'(@ç!;:/?,+].*")) {
            System.out.println("Bien essayé Clément");
            System.out.println(" ");
        }
        // Choix pour retourner au menu
        else if (Regles.equals("B") || Regles.equals("b")) {
            Debut();
        }
        // Choix pour quitter le jeu dans les regles
        else if (Regles.equals("Q") || Regles.equals("q")) {
            Quitter();
        }
    }

    // Fonction pour quitter le jeu
    public static void Quitter() {
        System.out.println("Bah reviens pas ");
        System.exit(0);


    }


    public static int nb_joueurs() {
        System.out.println("Combien ya t'ils de joueurs (entre 2 et 4) : ");
        Scanner scan = new Scanner(System.in);
        int nbJoueurs = scan.nextInt();
        if (nbJoueurs == 2 || nbJoueurs == 3 || nbJoueurs == 4) {
            System.out.println(" ");
        } else {
            System.out.println("Veuillez entrer un nombre valide !!");
            nb_joueurs();
        }
        return nbJoueurs;
    }


    public static List<String> Pseudo() {
        int TotalJoueurs = Menu.nb_joueurs();
        List<String> maListe = new ArrayList<>();
        for (int i = 0; i < TotalJoueurs; i++) {
            System.out.println("Entre un pseudo valide");
            Scanner scan = new Scanner(System.in);
            String pseudo = scan.nextLine();
            if (pseudo.length() >= 2 && pseudo.length() <= 10) {
                System.out.println("ok");
                maListe.add(pseudo);
            } else if (pseudo.length() > 10) {
                System.out.println("Le pseudo ne doit pas dépasser 10 caractères");
                Pseudo();
            } else if (pseudo.length() < 2) {
                System.out.println("Le pseudo doit contenir au moins 2 caractères");
                Pseudo();
            }
        }
        System.out.println("La partie commence ! ");
        return maListe;
    }
}
