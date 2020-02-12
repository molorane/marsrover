package com.game.marsrover.behaviour;

import com.game.marsrover.command.IMoveBehaviour;
import com.game.marsrover.domain.Position;
import com.game.marsrover.factory.MovementFactory;

public class Reverse implements IMoveBehaviour {
	
	MovementFactory movementFactory;

	public Reverse() {
		movementFactory = new MovementFactory();
	}

	public void move(Position position) {
		movementFactory.moveBackward(position);
	}

	public void undo(Position position) {
		movementFactory.moveForward(position);
	}
}