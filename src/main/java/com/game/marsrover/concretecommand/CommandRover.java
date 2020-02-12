package com.game.marsrover.concretecommand;

import com.game.marsrover.command.ICommand;
import com.game.marsrover.rover.Rover;

public class CommandRover implements ICommand {
    
    private final Rover rover;
    
    public CommandRover(Rover rover){
        this.rover = rover;
    }

    public void execute(String command) {
        this.rover.commandRover(command);
    }

    public void undo(String command) {
        this.rover.undoCommand(new StringBuilder(command).reverse().toString());
    }
    
}
