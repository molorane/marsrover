package com.game.marsrover.rover;

import com.game.marsrover.behaviour.Forward;
import com.game.marsrover.domain.Position;

public class MarsRover2016 extends Rover {

    public MarsRover2016(String name, Position startPosition) {
        this.moveBehaviour = new Forward();
        this.setRoverName(name);
        this.position = startPosition;
    }

}
