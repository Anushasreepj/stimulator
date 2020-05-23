package com.tyjohtech.gol.components.simulator;

import com.tyjohtech.gol.model.Simulation;
import com.tyjohtech.gol.model.StandardRule;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Simulator {

    private Timeline timeline;
    private Simulation simulation;

    private SimulatorState state;

    private boolean reset = true;

    public Simulator(SimulatorState state) {
        this.state = state;

        this.timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> this.doStep()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void handle(SimulatorEvent event) {
        switch (event.getEventType()) {
            case START:
                start();
                break;
            case STOP:
                stop();
                break;
            case STEP:
                doStep();
                break;
            case RESET:
                reset();
                break;
        }
    }

    private void doStep() {
        if (reset) {
            reset = false;
            state.setSimulating(true);
            this.simulation = new Simulation(state.getBoard(), new StandardRule());
        }

        this.simulation.step();

        state.setBoard(simulation.getBoard());
    }

    private void start() {
        this.timeline.play();
    }

    private void stop() {
        this.timeline.stop();
    }

    private void reset() {
        stop();
        reset = true;
        this.state.setSimulating(false);
    }
}
