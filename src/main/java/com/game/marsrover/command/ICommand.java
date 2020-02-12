package com.game.marsrover.command;

public interface ICommand {
	void execute(String command);

	void undo(String command);
}
