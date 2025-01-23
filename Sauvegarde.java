import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Sauvegarde {
    public static boolean creerFichier(String fileName) {
        try {
            // Créer une instance File pour le fichier donné
            File fichier = new File(fileName);

            // Tenter de créer un nouveau fichier
            if (fichier.createNewFile()) {
                System.out.println("Fichier créé  ");
                return true;
            } else {
                System.out.println("Le fichier existe déjà  " );
                return false;
            }
        } catch (IOException e) {
            // Gerer les erreurs
            System.err.println("Erreur lors de la création du fichier ");
            return false;
        }
    }

    //Fonction qui permet d ajouter les pseudos saisis dans le fichier txt
    public static void ajoutPseudo(List<String> listeJoueurs) throws IOException {
        // Ouvre le fichier en mode ajout (append = true)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\croqu\\IdeaProjects\\Animal-Destructor\\FichierScore.txt", true))) {
            for (String pseudo : listeJoueurs) {
                writer.write(pseudo + " --> ");
                writer.newLine(); // Passe à une nouvelle ligne pour chaque pseudo
            }
        }
    }
}
