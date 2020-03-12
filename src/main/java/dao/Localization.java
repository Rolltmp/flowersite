package dao;

import dao.factory.PostgreSqlDAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

public class Localization {

    private static Localization instance;
    private Hashtable<String,Hashtable<String,String>> dictionary;

    private Localization(){
        dictionary = initDictionary();
    }

    public static Localization getInstance(){
        if(instance == null){
            instance = new Localization();
        }
        return instance;
    }

    private Hashtable<String,Hashtable<String,String>> initDictionary(){

        Hashtable<String,Hashtable<String,String>> dictionary = new Hashtable<>();
        String key;
        Hashtable<String,String> english = new Hashtable<>();
        Hashtable<String,String> russian = new Hashtable<>();
        Hashtable<String,String> hebrew = new Hashtable<>();

        String sql = "SELECT * FROM translate;";
        try(Connection connection = PostgreSqlDAOFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet result = statement.executeQuery();
                while (result.next()){
                    key = result.getString("language_key");
                    english.put(key,result.getString("english"));
                    russian.put(key,result.getString("russian"));
                    hebrew.put(key,result.getString("hebrew"));
                }
                dictionary.put("english",english);
                dictionary.put("russian",russian);
                dictionary.put("hebrew",hebrew);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public Hashtable<String, String> getDictionary(String language) {
        return dictionary.get(language);
    }
}
