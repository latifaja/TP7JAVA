public class Sommeur implements Runnable {
    private int[] tableau;
    private int debut;
    private int fin;
    private int somme;

    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
        this.somme = 0; // Initialisation
    }
    @Override
    public void run() {
        System.out.println("Thread démarré pour la plage [" + debut + ", " + (fin - 1) + "]");
        for (int i = debut; i < fin; i++) {
            somme += tableau[i];
        }
        System.out.println("Thread terminé pour la plage [" + debut + ", " + (fin - 1) + "], somme partielle : " + somme);
    }

    public int getSomme() {
        return somme;
    }
}
