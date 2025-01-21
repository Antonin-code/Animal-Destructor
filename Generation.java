import org.w3c.dom.ls.LSOutput;

public class Generation {
    //Fonction pour créer le terrain
    public static String[][] CreationTerrain(){
        return new String[][] { {"\uD83C\uDF33","1\uFE0F⃣","2\uFE0F⃣","3\uFE0F⃣","4\uFE0F⃣","5\uFE0F⃣","6\uFE0F⃣","7\uFE0F⃣","8\uFE0F⃣","9\uFE0F⃣","\uD83D\uDD1F","⏸\uFE0F","\uD83C\uDF33"},
                                {"🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥","🔥"},
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
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11");
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
