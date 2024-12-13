import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        // Exemple de tableau
        int[] tableau = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int nbThreads = 4; // Nombre de threads
        int taille = tableau.length;

        // Création du pool de threads
        ExecutorService executor = Executors.newFixedThreadPool(nbThreads);

        // Calculer la taille des plages
        int segmentSize = (int) Math.ceil((double) taille / nbThreads);

        // Tableau pour stocker les résultats partiels
        Future<Integer>[] futures = new Future[nbThreads];

        // Créer et soumettre des tâches pour chaque plage
        for (int i = 0; i < nbThreads; i++) {
            int debut = i * segmentSize;
            int fin = Math.min(debut + segmentSize, taille);

            // Soumission de la tâche au pool de threads
            futures[i] = executor.submit(() -> {
                int somme = 0;
                for (int j = debut; j < fin; j++) {
                    somme += tableau[j];
                }
                return somme;
            });
        }

        // Attendre les résultats et calculer la somme totale
        int sommeTotale = 0;
        for (Future<Integer> future : futures) {
            System.out.println(future.get());
            sommeTotale += future.get(); // Bloque jusqu'à la fin du thread correspondant
        }

        // Arrêt du pool de threads
        executor.shutdown();

        // Affichage de la somme totale
        System.out.println("La somme totale est : " + sommeTotale);
    }
}
