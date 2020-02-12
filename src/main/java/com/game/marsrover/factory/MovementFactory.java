package com.game.marsrover.factory;

import com.game.marsrover.domain.Plateau;
import com.game.marsrover.domain.Position;
import com.game.marsrover.domain.enums.Direction;
import com.game.marsrover.exceptions.OutOfPlateauException;

public class MovementFactory {

    public void moveForward(Position position) {
        move(position, Direction.FORWARD);
    }

    public void moveBackward(Position position) {
        move(position, Direction.REVERSE);
    }

    private void move(Position position, Direction direction) {

        if (direction == Direction.FORWARD) {
            if (Plateau.getPlateauSize() > position.getY() + 1 && Plateau.getPlateauSize() > position.getX() + 1) {

                switch (position.getOrientation()) {
                    case N:
                        position.setY(position.getY() + 1);
                        break;
                    case W:
                        position.setX(position.getX() - 1);
                        break;
                    case E:
                        position.setY(position.getY() - 1);
                        break;
                    case S:
                        position.setX(position.getX() + 1);
                        break;
                }
            } else {
                throw new OutOfPlateauException("Heads up! You can't move forward! The rover is moving out side of the plateau.\n"
                        + "However, you can increase the size of the plateau!");
            }
        } else {
            if (Plateau.getPlateauSize() > position.getY() + 1 || Plateau.getPlateauSize() > position.getX() + 1) {
                switch (position.getOrientation()) {
                    case N:
                        position.setY(position.getY() - 1);
                        break;
                    case W:
                        position.setX(position.getX() + 1);
                        break;
                    case E:
                        position.setY(position.getY() + 1);
                        break;
                    case S:
                        position.setX(position.getX() - 1);
                        break;
                }
            } else {
                throw new OutOfPlateauException("Heads up! You can't move forward! The rover is moving out side of the plateau.\n"
                        + "However, you can increase the size of the plateau!");
            }
        }
    }
}
