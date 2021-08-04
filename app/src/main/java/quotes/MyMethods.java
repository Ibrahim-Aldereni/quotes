package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class MyMethods {
    //////////////////////////////////////////// lab 08 //////////////////////////////////////
    public static Quote getOneQuote(String path) {
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
            return null;
        }
        return quote.get(randomIndex);
    }

    //////////////////////////////////////////// lab 09 //////////////////////////////////////
    public static HttpURLConnection getConnection(String apiUrl){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return connection;
    }

    public static BufferedReader streamReader(HttpURLConnection connection){
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    // to print one quote from the api local json file
    public static QuoteApi getOneQuoteApiLocal(String path) {
        ArrayList<QuoteApi> quote = null;
        int randomIndex = 0;
        int max = 0;
        try {
            Gson gson = new Gson();
            // read json file
            FileReader reader = new FileReader(path);
            // read list ot objects
            Type quotesListType = new TypeToken<ArrayList<QuoteApi>>() {
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
            return null;
        }
        return quote.get(randomIndex);
    }

    public static void writeFromApiToLocal(String textFilePath, String jsonFilePath,String apiLineString){
        try {
            // write api line to local text file
            FileWriter fileWriter = new FileWriter(textFilePath, true);
            fileWriter.write(apiLineString+"\n");
            fileWriter.close();
            // add each line of the text file as element in list
            ArrayList<String> quotes = new ArrayList<>();
            File myObj = new File(textFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                quotes.add(data);
            }
            // write the list to json file
            FileWriter fileWriter2 = new FileWriter(jsonFilePath);
            fileWriter2.write(quotes.toString());
            fileWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
