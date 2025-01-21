import org.w3c.dom.ls.LSOutput;

public class Generation {
    //Fonction pour créer le terrain
    public static String[][] CreationTerrain(){
        return new String[][] { {"🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🟩","🔥"},
                                {"🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥"},};
    }

    //Fonction pour afficher le terrain
    public static void Affichage(String[][] grille) {
        //Affichage coordonnées lignes
        System.out.println("    1  2  3     4  5  6     7  8  9    10    11");
        for (int i = 0; i < grille. length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                //Affichage des cases
                System.out.print(grille[i][j] + " ");
            }
            //Affichage coordonnées colonnes
            System.out.println(i);
        }
    }
}
