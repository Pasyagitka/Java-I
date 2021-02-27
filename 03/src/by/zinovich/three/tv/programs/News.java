package by.zinovich.three.tv.programs;

import by.zinovich.three.tv.tvdirector.Programs;

public class News extends TVProgram {
    public News(String name, int lengthIMinutes) throws Exception {
        super(name, lengthIMinutes);
        ProgramType = Programs.News;
    }

    public String toString() {
        return "News{" + "Name:'" + getName() + '\'' +  ", LengthIMinutes:" + getLengthIMinutes() + '}';
    }
}
