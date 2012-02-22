package fr.ybo.benchmoteurcsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerationFchierCsv {

	private Random random = new Random();

	private char[] caracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '0' };

	private String separateur = ",";
	/**
	 * ~10 000 000 de lignes ~200 caractères par ligne ~20 champs (4/5 gros
	 * autour de 30 car.)
	 */

	private String genererChampString(int taille) {
		char[] champString = new char[taille];
		for (int count = 0; count < taille; count++) {
			champString[count] = caracteres[random.nextInt(caracteres.length)];
		}
		return String.copyValueOf(champString);
	}

	private String genererChampBoolean() {
		return random.nextBoolean() ? "1" : "0";
	}

	private String genererChampDouble(int nbDixaines, int nbDecimals) {
		StringBuilder builder = new StringBuilder();
		builder.append(random.nextInt((int) Math.pow(10, nbDixaines)));
		builder.append('.');
		builder.append(random.nextInt((int) Math.pow(10, nbDecimals)));
		return builder.toString();
	}

	private String genererChampInteger(int nbDixaines) {
		return Integer.toString(random.nextInt((int) Math.pow(10, nbDixaines)));
	}

	private String genererEntete() {
		return "a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20";
	}

	private String genererLigne() {
		StringBuilder ligne = new StringBuilder();
		// Champ 1 (a1)
		ligne.append(genererChampString(30));
		ligne.append(separateur);
		// Champ 2 (a2)
		ligne.append(genererChampBoolean());
		ligne.append(separateur);
		// Champ 3 (a3)
		ligne.append(genererChampInteger(5));
		ligne.append(separateur);
		// Champ 4 (a4)
		ligne.append(genererChampDouble(5, 5));
		ligne.append(separateur);
		// Champ 5 (a5)
		ligne.append(genererChampString(5));
		ligne.append(separateur);
		// Champ 6 (a6)
		ligne.append(genererChampString(30));
		ligne.append(separateur);
		// Champ 7 (a7)
		ligne.append(genererChampBoolean());
		ligne.append(separateur);
		// Champ 8 (a8)
		ligne.append(genererChampInteger(5));
		ligne.append(separateur);
		// Champ 9 (a9)
		ligne.append(genererChampDouble(5, 5));
		ligne.append(separateur);
		// Champ 10 (a10)
		ligne.append(genererChampString(5));
		ligne.append(separateur);
		// Champ 11 (a11)
		ligne.append(genererChampString(30));
		ligne.append(separateur);
		// Champ 12 (a12)
		ligne.append(genererChampBoolean());
		ligne.append(separateur);
		// Champ 13 (a13)
		ligne.append(genererChampInteger(5));
		ligne.append(separateur);
		// Champ 14 (a14)
		ligne.append(genererChampDouble(5, 5));
		ligne.append(separateur);
		// Champ 15 (a15)
		ligne.append(genererChampString(5));
		ligne.append(separateur);
		// Champ 16 (a16)
		ligne.append(genererChampString(30));
		ligne.append(separateur);
		// Champ 17 (a17)
		ligne.append(genererChampBoolean());
		ligne.append(separateur);
		// Champ 18 (a18)
		ligne.append(genererChampInteger(5));
		ligne.append(separateur);
		// Champ 19 (a19)
		ligne.append(genererChampDouble(5, 5));
		ligne.append(separateur);
		// Champ 20 (a20)
		ligne.append(genererChampString(5));

		return ligne.toString();
	}

	public static void main(String[] args) throws IOException {

		GenerationFchierCsv generateur = new GenerationFchierCsv();

		long startTime = System.currentTimeMillis();

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("fichier.csv")));

		writer.write(generateur.genererEntete());
		writer.write("\n");

		String ligne = null;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		long somme = 0;

		for (long count = 0; count < 10000000L; count++) {
			ligne = generateur.genererLigne();
			if (ligne.length() < min) {
				min = ligne.length();
			}
			if (ligne.length() > max) {
				max = ligne.length();
			}
			somme += ligne.length();
			writer.write(ligne);
			writer.write('\n');

			if (count % 10000 == 0) {
				System.out.println("Ligne : " + count);
			}
		}

		System.out.println("Statistiques sur la taille des lignes : ");
		System.out.println("\tMin : " + min);
		System.out.println("\tMax : " + max);
		double moyenne = (double) somme / 10000000.0;
		System.out.println("\tMoyenne : " + moyenne);

		long tailleFichier = somme;
		tailleFichier += generateur.genererEntete().length();
		// Retour à la ligne
		tailleFichier += 10000001L;

		System.out.println("Taille du fichier : " + tailleFichier);

		long elapsedTime = System.currentTimeMillis() - startTime;

		System.out.println("Génération en " + elapsedTime + "ms");

		writer.close();
	}
}
