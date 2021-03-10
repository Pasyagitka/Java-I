package by.zinovich.three.tv.main;

import by.zinovich.three.tv.programs.*;
import by.zinovich.three.tv.tvdirector.Director;
import by.zinovich.three.tv.tvdirector.Programs;


import java.util.logging.Logger;
import parse.JSONSerialize;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            Director programDirector = new Director(12, "Станислав");
            logger.info("Director is created");
            logger.info("Creating instances of TVProgram");
            TVProgram tp1 = new News("Вечер с Соловьём Владимировым", 15);
            TVProgram tp2 = new Adds("Собачий корм", 3);
            TVProgram tp3 = new Adds("Кошачий корм \"Феникс\"", 2);
            TVProgram tp4 = new Cartoons("Бубка Гоб", 25);
            TVProgram tp5 = new Films("Тектоник", 125);
            TVProgram tp6 = new News("Вести недели", 15);
            logger.info("Adding instances to program list");
            TVProgram tp7 = new News("*27*94", -100);
            TodaysProgram program1 = new TodaysProgram();
            program1.programList.add(tp1);
            program1.programList.add(tp2);
            program1.programList.add(tp3);
            program1.programList.add(tp4);
            program1.programList.add(tp5);
            program1.programList.add(tp6);
            logger.info("FindLongestProgram");
            System.out.println(programDirector.FindLongestProgram(program1).toString());
            logger.info("ProgramTableDuration");
            System.out.println("Длительность всей программы: " + programDirector.ProgramTableDuration(program1) + " минут");
            programDirector.SortProgramTable(program1);
            logger.info("SortProgramTable");
            System.out.println(program1.programList.toString());
            logger.info("SearchProgramByType(Programs.News)");
            System.out.println("Новости: " + programDirector.SearchProgramByType(program1, Programs.News));

            program1.jsonSerialize();
            TodaysProgram program2 = TodaysProgram.jsonDeserialize();
            System.out.println("program2:");
            System.out.println(program2.programList);
        }
        catch (Exception e) {
            logger.warning("Exception was thrown");
            System.out.println(e.getMessage());
        }
    }
}
