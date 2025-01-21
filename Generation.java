public class Generation {
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