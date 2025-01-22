import java.io.File;
import java.io.IOException;

public class Sauvegarde {

    public String meilleurScore = "meilleurscore.txt";
    public File fichier = new File(meilleurScore);

    // Fonction qui permet de creer le fichier texte si celui ci n'existe pas deja
    public Sauvegarde() {
        try {
            // Vérifie si le fichier existe
            if (!fichier.exists()) {
                // Crée le fichier
                if (fichier.createNewFile()) {
                    System.out.println("Fichier créé avec succès : ");
                } else {
                    System.out.println("Erreur lors de la création du fichier.");
                }
            } else {
                System.out.println("Le fichier existe déjà : ");
            }
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite : " );
        }
    }

    public static void main(String[] args) {
        // Création d'une instance de Sauvegarde pour déclencher l'opération
        new Sauvegarde();
    }
}
