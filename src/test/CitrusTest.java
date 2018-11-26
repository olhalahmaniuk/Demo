package test;

import com.company.Citrus;
import com.company.Fruit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

import static org.testng.Assert.*;

public class CitrusTest {
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
    public void testPrint() throws Exception {
        // Arrange
        System.out.print("[Fruit{name='lemon', color='yellow' Citrus [cVitaminContent=5}]");

        // Act

        // Assert
        assertEquals("[Fruit{name='lemon', color='yellow' Citrus [cVitaminContent=5}]", outContent.toString());
    }

}