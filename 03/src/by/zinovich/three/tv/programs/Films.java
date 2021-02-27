package by.zinovich.three.tv.programs;

import by.zinovich.three.tv.tvdirector.Programs;

public class Films extends TVProgram {
    public Films(String name, int lengthIMinutes) throws Exception {
        super(name, lengthIMinutes);
        ProgramType = Programs.Films;
    }

    @Override
    public String toString() {
        return "Films{" + "Name:'" + getName() + '\'' +  ", LengthIMinutes:" + getLengthIMinutes() + '}';
    }
}
