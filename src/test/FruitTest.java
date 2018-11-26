package test;

import com.company.Fruit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

import static org.testng.Assert.*;

public class FruitTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeMethod
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

    }

    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testInput() throws Exception {
        // Arrange
        Fruit actual = new Fruit();
        Fruit expected = new Fruit("apple", "green");

        // Act
        //This class allows an application to create an input stream in which the bytes
        // read are supplied by the contents of a string.
        System.setIn(new StringBufferInputStream("apple green"));
        actual.input();

        //Assert
        assertEquals(actual, expected);
    }
}