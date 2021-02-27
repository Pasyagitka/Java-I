package by.zinovich.three.tv.programs;

import by.zinovich.three.tv.tvdirector.Programs;

abstract public class TVProgram {
    private String Name;
    private int LengthIMinutes; //длительность программы
    public Programs ProgramType;

    protected TVProgram(String name, int lengthIMinutes) {
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
        return "TVProgram{" + "Name:'" + getName() + '\'' +  ", LengthIMinutes:" + getLengthIMinutes() + '}';
    }
    public String getName() {
        return Name;
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

