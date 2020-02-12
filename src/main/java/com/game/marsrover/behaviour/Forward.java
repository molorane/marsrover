package com.game.marsrover.behaviour;

import com.game.marsrover.command.IMoveBehaviour;
import com.game.marsrover.domain.Position;
import com.game.marsrover.factory.MovementFactory;

public class Forward implements IMoveBehaviour {
	
	MovementFactory movementFactory;

	public Forward() {
		movementFactory = new MovementFactory();
	}

	public void move(Position position) {
		movementFactory.moveForward(position);
	}

	public void undo(Position position) {
		movementFactory.moveBackward(position);
	}
}