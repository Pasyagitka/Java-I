package by.zinovich.three.tv.programs;

import by.zinovich.three.tv.tvdirector.Programs;

public class Cartoons extends TVProgram {
    public Cartoons(String name, int lengthIMinutes) throws Exception {
        super(name, lengthIMinutes);
        ProgramType = Programs.Cartoons;
    }

    @Override
    public String toString() {
        return "Cartoon{" + "Name:'" + getName() + '\'' +  ", LengthIMinutes:" + getLengthIMinutes() + '}';
    }
}
