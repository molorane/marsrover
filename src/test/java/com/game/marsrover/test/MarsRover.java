package com.game.marsrover.test;

import com.game.marsrover.concretecommand.CommandRover;
import com.game.marsrover.domain.Plateau;
import com.game.marsrover.domain.Position;
import com.game.marsrover.domain.enums.Orientation;
import com.game.marsrover.exceptions.InvalidCommandException;
import com.game.marsrover.exceptions.OutOfPlateauException;
import com.game.marsrover.rover.MarsRover2016;
import com.game.marsrover.rover.Rover;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsRover {

    Plateau plateau;

    @BeforeEach
    public void setup() {
        plateau = Plateau.getInstance();
    }

    @BeforeEach
    public void plateauShouldNotbeNull() {
        Assert.assertNotNull(plateau);
    }

    @Test
    public void shouldSetNewPositionSixTowSouth() {
        Position pos = new Position(3, 3, Orientation.S);
        Rover rover = new MarsRover2016("Mars Rover 2016", pos);
        Assert.assertEquals(pos, rover.getPosition());

        String strCommand = "LMMLMRMRMM";
        CommandRover command = new CommandRover(rover);
        command.execute(strCommand);

        Assert.assertEquals("Position returned not 6,2,S", pos, new Position(4, 6, Orientation.S));
    }

    @Test
    public void shouldReturnInitialPositionThreeThreeSouth() {
        Position pos = new Position(3, 3, Orientation.S);
        Rover rover = new MarsRover2016("Mars Rover 2016", pos);
        Assert.assertEquals(pos, rover.getPosition());

        String strCommand = "LMMLMRMRMMMMM";
        CommandRover command = new CommandRover(rover);

        command.execute(strCommand);
        command.undo(strCommand);

        Assert.assertEquals("Position returned not 3,3,S", pos, new Position(3, 3, Orientation.S));
    }

    @Test
    public void shouldReturnZeroNegativeTwoWest() {
        Position pos = new Position(3, 1, Orientation.E);
        Rover rover = new MarsRover2016("Mars Rover 2016", pos);
        Assert.assertEquals(pos, rover.getPosition());

        String strCommand = "MLMMLLMMMRMLMMLMMMR";
        CommandRover command = new CommandRover(rover);

        command.execute(strCommand);

        Assert.assertEquals("Position returned not 0,-2,W", pos, new Position(0, -2, Orientation.W));
    }

    @Test
    public void shouldReturnTwoZeroNorth() {
        Position pos = new Position(0, 0, Orientation.N);
        Rover rover = new MarsRover2016("Mars Rover 2016", pos);
        Assert.assertEquals(pos, rover.getPosition());

        String strCommand = "RMML";
        CommandRover command = new CommandRover(rover);

        command.execute(strCommand);

        Assert.assertEquals("Position returned not 2,0,N", pos, new Position(2, 0, Orientation.N));
    }

    @Test
    void shouldThrowOutOfPlateauException() {

        Assertions.assertThrows(OutOfPlateauException.class, () -> {

            Position pos = new Position(3, 3, Orientation.S);
            Rover rover = new MarsRover2016("Mars Rover 2016", pos);
            Assert.assertEquals(pos, rover.getPosition());

            String strCommand = "LMMLMRMMMMRMM";
            CommandRover command = new CommandRover(rover);
            command.execute(strCommand);
        });
    }

	@Test
	void shouldThrowInvalidCommanException() {

		Assertions.assertThrows(InvalidCommandException.class, () -> {

			Position pos = new Position(3, 3, Orientation.S);
			Rover rover = new MarsRover2016("Mars Rover 2016", pos);
			Assert.assertEquals(pos, rover.getPosition());

			String strCommand = "LMMLMRMMMMPO";
			CommandRover command = new CommandRover(rover);
			command.execute(strCommand);
		});
	}

	@Test
    public void okay(){
        var b = "";
    }

}
