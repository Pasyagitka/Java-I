package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    //
    public static void main(String[] args) {
        readSite ("https://github.com/Pasyagitka/Java-I");
    }
    public static void readSite(String s) {
        URL url = null;
        try {
            url = new URL (s);
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        }
        if (url == null) {
            throw new RuntimeException ();
        }
        try (BufferedReader d = new BufferedReader (new InputStreamReader (url.openStream()))) {
            String line = "";
            while ((line = d.readLine ()) != null) {
                System.out.println (line);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
