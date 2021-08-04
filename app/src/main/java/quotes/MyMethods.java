package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public abstract class MyMethods {
    public static String getOneQuote(String path) {
        ArrayList<Quote> quote = null;
        int randomIndex = 0;
        int max = 0;
        try {
            Gson gson = new Gson();
            // read json file
            FileReader reader = new FileReader(path);
            // read list ot objects
            Type quotesListType = new TypeToken<ArrayList<Quote>>() {
            }.getType();
            // from json to objects
            quote = gson.fromJson(reader, quotesListType);
            // select random quote
            max = quote.size();
            if(max == 1){
                randomIndex = 0;
            }else{
                randomIndex = (int) (Math.random() * max);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // get random quote text
        if(max == 0){
            return "json is empty";
        }
        return quote.get(randomIndex).text;
    }
}
