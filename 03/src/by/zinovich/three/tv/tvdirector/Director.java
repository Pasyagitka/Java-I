package by.zinovich.three.tv.tvdirector;

import by.zinovich.three.tv.programs.TVProgram;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static by.zinovich.three.tv.programs.TodaysProgram.programList;


public class Director implements IDirector {
    WorkerInfo directorInfo;

    public Director(int id, String name) {
        this.directorInfo = new WorkerInfo(id, name);
    }

    @Override
    public TVProgram FindLongestProgram() {
        return programList.stream().sorted(Comparator.comparingInt(TVProgram::getLengthIMinutes).reversed()).findFirst().get();
    }
    @Override
    public List<TVProgram> SearchProgramByType(Programs programtype) {
        return programList.stream().filter((p)-> p.ProgramType == programtype).collect(Collectors.toList());
    }
    @Override
    public int ProgramTableDuration() {
        return programList.stream().mapToInt(TVProgram::getLengthIMinutes).sum();
    }
    @Override
    public void SortProgramTable() {
        programList.sort(Comparator.comparingInt(TVProgram::getLengthIMinutes));
    }

    public class WorkerInfo {
        public String workerName;
        private int workerId;

        public WorkerInfo(int workerId, String workerName) {
            this.setWorkerId(workerId);
            this.workerName = workerName;
        }

        public int getWorkerId() {
            return workerId;
        }
        public void setWorkerId(int workerId) {
            this.workerId = workerId;
        }
    }

}
