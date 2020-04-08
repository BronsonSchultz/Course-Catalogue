package webApp;

import webApp.db.DBConnection;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Selector {
    DBConnection db;

    public Selector() {
        db = new DBConnection();
    }

    /**
     * create an array of json objects from an array list
     * @param list the array list of hashMaps returned by the query methods
     * @return array of json objects from an array list
     */
    public JSONObject[] jsonifyList(ArrayList<HashMap<String, String>> list) {
        JSONObject[] jsonArray = new JSONObject[list.size()];
        for (int i = 0; i < list.size(); i++) {
            JSONObject j = new JSONObject(list.get(i));
            jsonArray[i] = j;
        }
        return jsonArray;
    }
}
