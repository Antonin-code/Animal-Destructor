public class Generation {
    /**
     * Génère une grille représentant le terrain de jeu.
     * <p>
     * La grille est une matrice 2D de chaînes de caractères où :
     * <ul>
     *     <li>"🔥" représente des cases de feu (bords ou zones bloquées).</li>
     *     <li>"🟩" représente des cases d'herbe (zones traversables).</li>
     *     <li>Les dernières colonnes ajoutent des identifiants de ligne (A-J) pour plus de clarté.</li>
     * </ul>
     *
     * @return Une matrice 2D de chaînes de caractères représentant le terrain de jeu.
     *
     * <h3>Exemple de retour :</h3>
     * */
    //Fonction pour créer le terrain
    public static String[][] CreationTerrain(){
        return new String[][] {
                {"🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","A"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","B"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","C"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","D"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","E"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","F"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","G"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","H"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","I"},
                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥","J"},
                {"🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥"}};
    }

    //Fonction pour afficher le terrain
    public static void Affichage(String[][] grille) {
        //Variable pour texte rouge
        final String ROUGE = "\u001B[31m";
        final String RESET = "\u001B[0m";

        //Affichage coordonnées colonnes
        System.out.println("\uD83C\uDF33"+" 1️⃣"+" 2️⃣"+" 3️⃣"+" 4️⃣"+" 5️⃣"+" 6️⃣"+" 7️⃣"+" 8️⃣"+" 9️⃣"+" \uD83D\uDD1F"+" ⏸️"+" \uD83C\uDF33"+ROUGE);
        for (String[] lignes : grille) {
            for (String colonne : lignes) {
                //Affichage des cases
                System.out.print(colonne + " ");
            }
            //Affichage coordonnées colonnes
            System.out.println();
        }
        System.out.println(RESET);
    }
}