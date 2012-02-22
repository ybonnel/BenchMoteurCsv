package fr.ybo.benchmoteurcsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import fr.ybo.moteurcsv.MoteurCsv;
import fr.ybo.moteurcsv.modele.InsertObject;

public class Bench {

	private static final File fichier = new File("fichier.csv");

	private static MoteurCsv moteur;

	public static void instanciationMoteur() {
		long startTime = System.nanoTime();
		moteur = new MoteurCsv(ObjetCsv.class);
		long elapsedTime = (System.nanoTime() - startTime) / 1000;
		System.out.println("Instanciation du moteur : " + elapsedTime + "µs");
	}

	public static void bench1() throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		moteur.parseFileAndInsert(new FileReader(fichier), ObjetCsv.class, new InsertObject<ObjetCsv>() {
			@Override
			public void insertObject(ObjetCsv objet) {
				// On ne fait rien dans le cadre du bench.
			}
		});
		long elapsedTime = (System.currentTimeMillis() - startTime);
		System.out.println("Lecture du fichier : " + elapsedTime + "ms");
	}

	public static void gestionMemoire() {
		// Mémoire totale allouée
		long totalMemory = Runtime.getRuntime().totalMemory();
		// Mémoire utilisée
		long currentMemory = totalMemory - Runtime.getRuntime().freeMemory();
		System.out.println("Mémoire avant gc : " + (currentMemory / 1024) + "ko/" + (totalMemory / 1024) + "ko");
		System.gc();
		// Mémoire totale allouée
		totalMemory = Runtime.getRuntime().totalMemory();
		// Mémoire utilisée
		currentMemory = totalMemory - Runtime.getRuntime().freeMemory();
		System.out.println("Mémoire après gc : " + (currentMemory / 1024) + "ko/" + (totalMemory / 1024) + "ko");
	}

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Thread.sleep(5000);
		gestionMemoire();
		instanciationMoteur();
		gestionMemoire();
		for (int count = 1; count <= 5; count++) {
			bench1();
			gestionMemoire();
		}
	}

}
