public class test {
    public static void main(String[] args) {
        String[][] Terrain = Generation.CreationTerrain();
        Generation.Affichage(Terrain);
        for (int i = 0; i < 3; i++) {
            DestructionCase.Destruction(Terrain);
            Generation.Affichage(Terrain);
        }
    }
}
