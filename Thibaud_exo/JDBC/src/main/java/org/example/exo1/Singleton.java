package org.example.exo1;

public class Singleton {
    private static Singleton instance;
    private String urlConnection;

    private Singleton(String urlConnection) {
        this.urlConnection = urlConnection;
    }

    public String getUrlConnection() {
        return urlConnection;
    }

    public static synchronized Singleton getInstance(String url) {
        if (instance == null) {
            instance = new Singleton(url);
        }
        return instance;
    }
}
