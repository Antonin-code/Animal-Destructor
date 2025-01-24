import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.ArrayList;
import java.util.AbstractMap;

public class ordreFichier {
    /**
     * Trie un fichier contenant les scores des joueurs en fonction de leur score.
     * Chaque ligne du fichier doit être formatée comme suit :
     * `<Pseudo> --> <Score>`.
     *
     * @param cheminFichier le chemin vers le fichier à trier.
     * @param ordreCroissant un booléen indiquant si le tri doit être en ordre croissant (`true`) ou décroissant (`false`).
     * @throws IOException si une erreur d'entrée/sortie se produit lors de la lecture ou de l'écriture du fichier.
     */
    public static void trierFichierParScore(String cheminFichier, boolean ordreCroissant) throws IOException {
        // Lire toutes les lignes du fichier
        List<String> lignes = Files.readAllLines(Paths.get(cheminFichier));

        // Traiter les lignes pour séparer pseudo et score
        List<Map.Entry<String, Integer>> joueursScores = new ArrayList<>();
        for (String ligne : lignes) {
            if (ligne.contains(" --> ")) {
                String[] parties = ligne.split(" --> ");
                String pseudo = parties[0].trim();
                int score = Integer.parseInt(parties[1].trim());
                joueursScores.add(new AbstractMap.SimpleEntry<>(pseudo, score));
            }
        }

        // Trier la liste en fonction des scores
        joueursScores.sort((entry1, entry2) -> {
            if (ordreCroissant) {
                return Integer.compare(entry1.getValue(), entry2.getValue());
            } else {
                return Integer.compare(entry2.getValue(), entry1.getValue());
            }
        });


        // Générer les nouvelles lignes triées
        List<String> lignesTriees = joueursScores.stream()
                .map(entry -> entry.getKey() + " --> " + entry.getValue())
                .collect(Collectors.toList());

        // Réécrire le fichier avec les lignes triées
        Files.write(Paths.get(cheminFichier), lignesTriees);

        System.out.println("Fichier trié avec succès (" + (ordreCroissant ? "croissant" : "décroissant") + ").");
        System.out.println(' ');
        System.out.println(' ');

        // Fonction pour afficher le Score
        Menu.Score();

    }
        public static void croissant (String fichier) throws IOException {
            List<String> lignes = Files.readAllLines(Paths.get(fichier));
            for (String ligne : lignes) {
                //if
            }
        }
        public static void decroissant (String fichier){

        }
}