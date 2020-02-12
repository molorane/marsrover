package com.game.marsrover.command;

import com.game.marsrover.domain.Position;

public interface IMoveBehaviour {
	
	void move(Position position);

	void undo(Position position);
}
