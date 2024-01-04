package it.unisa.IS_Project.AI.Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Parser {

    public static int[][] convertiMappa(String mappa) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

        JSONArray entita = (JSONArray) mappaJSON.get("mappa");

        JSONObject entitaJSON = (JSONObject) entita.get(entita.size() - 1);

        int altezza = Math.toIntExact((Long) entitaJSON.get("row")) + 1;
        int larghezza = Math.toIntExact((Long) entitaJSON.get("col")) + 1;

        int[][] map = new int[altezza][larghezza];

        for (Object obj : entita) {
            JSONObject entityJSON = (JSONObject) entitaJSON;

            int row = Math.toIntExact((Long) entityJSON.get("row"));
            int col = Math.toIntExact((Long) entityJSON.get("col"));
            int id = Math.toIntExact((Long) entityJSON.get("id"));

            map[row][col] = id;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\java\\it\\unisa\\files\\map.txt"));
            for (int[] row : map) {
                for (int id : row) {
                    writer.write(id + "\t");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

}
