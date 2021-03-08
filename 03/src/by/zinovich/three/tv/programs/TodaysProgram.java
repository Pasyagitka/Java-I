package by.zinovich.three.tv.programs;

import java.io.*;
import java.util.ArrayList;

import by.zinovich.three.tv.programs.TodaysProgram;
import com.google.gson.Gson;


public class TodaysProgram {
    public ArrayList<TVProgram> programList;

    public TodaysProgram() {
        programList = new ArrayList<TVProgram>();
    }

    public void jsonSerialize() throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("H:/4 семестр/Java I/03/files/TodaysProgram.json")) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TodaysProgram jsonDeserialize() throws Exception {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("H:/4 семестр/Java I/03/files/TodaysProgram.json")) {
            TodaysProgram programlist = gson.fromJson(reader, TodaysProgram.class);
            return programlist;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
