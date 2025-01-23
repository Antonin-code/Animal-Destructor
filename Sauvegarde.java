import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.stream.Collectors;

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
                System.out.println("Le fichier existe déjà  ");
                return false;
            }
        } catch (IOException e) {
            // Gerer les erreurs
            System.err.println("Erreur lors de la création du fichier ");
            return false;
        }
    }


    public static void calculScore(String pseudo, int pointsAjoutes) throws IOException {
        String cheminFichier = "FichierScore.txt";
        List<String> nouvellesLignes = new ArrayList<>();
        List<String> lignes = Files.readAllLines(Paths.get(cheminFichier));
        for (String ligne : lignes) {
            if (ligne.startsWith(pseudo + " -->")) {
                String[] parties = ligne.split(" --> ");
                int ancienScore = Integer.parseInt(parties[1]); // Extraire le score
                int nouveauScore = ancienScore + pointsAjoutes; // Ajouter les points
                nouvellesLignes.add(pseudo + " --> " + nouveauScore); // Ajouter la nouvelle ligne
            } else {
                nouvellesLignes.add(ligne); // Conserver les autres lignes inchangées
            }
        }
        Files.write(Paths.get(cheminFichier), nouvellesLignes);
    }

    //Fonction qui permet d ajouter les pseudos saisis dans le fichier txt
    public static void ajoutPseudo(List<String> listeJoueurs,int pointsAjoutes) throws IOException {
        String cheminFichier = "FichierScore.txt";

        // Charger tous les pseudos existants dans le fichier
        List<String> pseudosExistants;
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            pseudosExistants = reader.lines()
                    .map(ligne -> ligne.split(" --> ")[0]) // On extrait seulement le pseudo avant la flèche
                    .collect(Collectors.toList());
        }

        // Ouvre le fichier en mode ajout
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier, true))) {
            for (String pseudo : listeJoueurs) {
                if (!pseudosExistants.contains(pseudo)) { // Vérifie si le pseudo n'existe pas déjà
                    writer.write(pseudo + " --> " + 0);
                    writer.newLine();
                    System.out.println("Pseudo ajouté : " + pseudo);
                } else {
                    calculScore(pseudo, pointsAjoutes);
                }
            }
        }
    }

}
