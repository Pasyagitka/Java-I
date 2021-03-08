package by.zinovich.three.tv.tvdirector;

import by.zinovich.three.tv.programs.TVProgram;
import by.zinovich.three.tv.programs.TodaysProgram;

import java.util.List;

public interface IDirector {
    TVProgram FindLongestProgram(TodaysProgram TP);
    List<TVProgram> SearchProgramByType(TodaysProgram TP, Programs programtype);
    int ProgramTableDuration(TodaysProgram TP);
    void SortProgramTable(TodaysProgram TP);
}
