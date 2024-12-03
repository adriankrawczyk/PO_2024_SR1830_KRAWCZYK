package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final ArrayList<Simulation> simulations;
    private final ArrayList<Thread> threads = new ArrayList<>();
    private ExecutorService threadPool;

    public SimulationEngine(ArrayList<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        threadPool = Executors.newFixedThreadPool(4);
        for (Simulation simulation : simulations) {
            threadPool.submit(simulation::run);
        }
    }



    public void awaitSimulationsEnd() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (threadPool != null) {
            threadPool.shutdown();
            try {
                if (!threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();
                }
            } catch (InterruptedException e) {
                threadPool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
