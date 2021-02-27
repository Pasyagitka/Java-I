package by.zinovich.three.tv.tvdirector;

import by.zinovich.three.tv.programs.TVProgram;

import java.util.List;

public interface IDirector {
    TVProgram FindLongestProgram();
    List<TVProgram> SearchProgramByType(Programs programtype);
    int ProgramTableDuration();
    void SortProgramTable();
}
