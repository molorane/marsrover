package com.game.marsrover.rover;

import com.game.marsrover.behaviour.Reverse;
import com.game.marsrover.domain.Position;

public class MarsRover2019 extends Rover {

	public MarsRover2019(String name, Position startPosition) {
		this.moveBehaviour = new Reverse();
		this.setRoverName(name);
		this.position = startPosition;
	}

	// All other methods to change direction of movement that is (forward or
	// reverse)
	// can be implemented here.
}