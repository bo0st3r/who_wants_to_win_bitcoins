package utilitaires;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import modele.Deck;

public class Serialization {

	/*
	 * Writes a deck into a JSON file in JSON format. The JSON file name's depends
	 * of the "dest" param passed while calling the method.
	 * 
	 * @param Deck deck It's a set of questions
	 * 
	 * @param String dest It's the name of the .json file
	 */
	public static void deckToJson(Deck deck, String dest) {
		// Gets the text in JSON format for the deck
		String json = new Gson().toJson(deck);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(dest + ".json"))) {
			bw.write(json);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	//J'�tais ICI
	public static Deck jsonToDeck(String dest) {
		try (BufferedReader br = new BufferedReader(new FileReader(dest + ".json"))) {
			String fromFile = "";

			String tmp = br.readLine();
			while (tmp != null) {
				fromFile = fromFile + tmp;
				tmp = br.readLine();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
