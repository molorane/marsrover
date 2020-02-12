package com.game.marsrover.rover;

import com.game.marsrover.command.IMoveBehaviour;
import com.game.marsrover.domain.Position;
import com.game.marsrover.domain.enums.Orientation;
import com.game.marsrover.domain.enums.Rotation;
import com.game.marsrover.exceptions.InvalidCommandException;
import com.game.marsrover.exceptions.RotationNullException;

import java.math.BigDecimal;

public abstract class Rover {

    protected IMoveBehaviour moveBehaviour;
    private String roverName;
    protected Position position;

    BigDecimal obj;

    public final void moveRover() {
        this.moveBehaviour.move(position);
    }

    public final void undoRover() {
        this.moveBehaviour.undo(position);
    }

    /****
     * @param degrees
     * @param rotation
     *
     * This method is not final, indicating that any rover can
     * override it perhaps a rover with a capability such as
     * rotating less or more than 90 degrees
     */
    public void rotateRover(double degrees, Rotation rotation) {

        if (degrees == 90) {
            if (null == rotation) {
                throw new RotationNullException("Illegal rotation argument, rotation cannot be null.");
            } else // rotate rover 90
                switch (rotation) {
                    case LEFT:
                        switch (position.getOrientation()) {
                            case N:
                                position.setOrientation(Orientation.W);
                                break;
                            case W:
                                position.setOrientation(Orientation.E);
                                break;
                            case E:
                                position.setOrientation(Orientation.S);
                                break;
                            case S:
                                position.setOrientation(Orientation.N);
                                break;
                        }
                        break;
                    case RIGHT:
                        switch (position.getOrientation()) {
                            case N:
                                position.setOrientation(Orientation.S);
                                break;
                            case S:
                                position.setOrientation(Orientation.E);
                                break;
                            case E:
                                position.setOrientation(Orientation.W);
                                break;
                            case W:
                                position.setOrientation(Orientation.N);
                                break;
                        }
                        break;
                }
        }
    }

    public final String getRoverName() {
        return this.roverName;
    }

    public final void setRoverName(String roverName) {
        this.roverName = roverName;
    }

    public final Position getPosition() {
        return this.position;
    }

    public void commandRover(String command) {
        if (IsCommandValid(command)) {
            command = command.toUpperCase();
            for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case 'L':
                        rotateRover(90, Rotation.LEFT);
                        break;
                    case 'R':
                        rotateRover(90, Rotation.RIGHT);
                        break;
                    case 'M':
                        moveRover();
                }
            }
        } else {
			throw new InvalidCommandException("Sorry, you passed invalid comand: \n"
					+ "Only include the following letters (M,L,R) in your string!!");
        }
    }

    public void undoCommand(String command) {
        if (IsCommandValid(command)) {
            command = command.toUpperCase();
            for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case 'L':
                        rotateRover(90, Rotation.RIGHT);
                        break;
                    case 'R':
                        rotateRover(90, Rotation.LEFT);
                        break;
                    case 'M':
                        undoRover();
                }
            }
        } else {
			throw new InvalidCommandException("Sorry, you passed invalid comand: \n"
					+ "Only include the following letters (M,L,R) in your string!!");
        }
    }

    public final boolean IsCommandValid(String command) {
        command = command.toUpperCase();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) != 'M' && command.charAt(i) != 'L' && command.charAt(i) != 'R') {
                return false;
            }
        }
        return true;
    }
}
