package by.zinovich.three.tv.programs;

import by.zinovich.three.tv.tvdirector.Programs;

public class Adds extends TVProgram {
    public Adds(String name, int lengthIMinutes) throws Exception {
        super(name, lengthIMinutes);
        ProgramType = Programs.Adds;
    }

    @Override
    public String toString() {
        return "Adds{" + "Name:'" + getName() + '\'' +  ", LengthIMinutes:" + getLengthIMinutes() + '}';
    }
}
