package by.zinovich.three.tv.workers;

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
