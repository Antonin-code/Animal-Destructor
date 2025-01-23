import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Menu {

    // Fonction pour lancer le menu avec les options
    public static void Debut() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Bonjour bienvenue dans Animal-Destructor !! ");
        System.out.println("Voici les options possibles : ");
        System.out.println("--- P pour lancer une partie --- ");
        System.out.println("--- R pour lire les règles du jeu ---");
        System.out.println("--- S pour voir les scores ---");
        System.out.println("--- L pour quitter le jeu (mauvaise idée) ---");
        Choix.choix_Menu();
    }

    // Fonction pour lancer le jeu
    public static void Jouer() {
        System.out.println("Jouer");
    }

    // Fonction pour quitter le jeu
    public static void Quitter() {
        System.out.println("Bah reviens pas ");
        System.exit(0);
    }

    //Fonction pour le score
    public static void Score() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--- B  Retourner au Menu ---");
        System.out.println("--- C  Afficher les scores en ordre croissant ---");
        System.out.println("--- D  Afficher les scores en ordre decroissant ---");
        System.out.println(" ");
        System.out.println(" ");
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\croqu\\IdeaProjects\\Animal-Destructor\\nouveauFichier.txt"))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Choix.choix_Score();
    }

    public static short nb_joueurs () {
        System.out.println("Combien ya t'ils de joueurs (entre 2 et 4) : ");
        Scanner scan = new Scanner(System.in);
        short nbJoueurs = scan.nextShort();
        if (nbJoueurs == 2 || nbJoueurs == 3 || nbJoueurs == 4){
            System.out.println(" ");
        } else {
            System.out.println("Veuillez entrer un nombre valide !!");
            nb_joueurs();
        }
        return nbJoueurs;
    }



    public static List<String> Pseudo() throws IOException {
        short TotalJoueurs = nb_joueurs();
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
        Sauvegarde.ajoutPseudo(maListe);
        System.out.println("La partie commence ! ");
        return maListe;
    }
}
