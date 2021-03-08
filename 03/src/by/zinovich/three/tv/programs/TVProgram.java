package by.zinovich.three.tv.programs;

import by.zinovich.three.tv.tvdirector.Programs;

public class TVProgram {
    private String Name;
    private int LengthIMinutes; //длительность программы
    public Programs ProgramType;

    public TVProgram() {
    }

    protected TVProgram(String name, int lengthIMinutes) throws Exception {
        if (lengthIMinutes <=0)
            try {
                throw  new Exception("Ошибка! Длина программы не может быть отрицательной");
            } catch (Exception e){

                System.out.println(e.getMessage());
            }
        Name = name;
        LengthIMinutes = lengthIMinutes;
    }

    @Override
    public String toString() {
        return "TVProgram{" + "Name:'" + getName() + '\'' +  ", LengthIMinutes:" + getLengthIMinutes() +  ", ProgramType: " + getProgramType() + '}';
    }
    public String getName() {
        return Name;
    }

    public Programs getProgramType() {  return ProgramType; }
    public void setProgramType(String programType) {
        if (programType.equals("News"))
            ProgramType = Programs.News;
        if (programType.equals("Adds"))
            ProgramType = Programs.Adds;
        if (programType.equals("Cartoons"))
            ProgramType = Programs.Cartoons;
        if (programType.equals("Films"))
            ProgramType = Programs.Films;
    }

    public void setName(String name) {
        Name = name;
    }
    public int getLengthIMinutes() {
        return LengthIMinutes;
    }
    public void setLengthIMinutes(int lengthIMinutes) {
        LengthIMinutes = lengthIMinutes;
    }
}

