package test;

import com.company.Citrus;
import com.company.Fruit;
import com.company.Output;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class OutputTest {

    Output op = new Output();

    @BeforeMethod
    public static List<Fruit> getFruits() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("banana", "yellow"));
        fruits.add(new Fruit("apple", "green"));
        fruits.add(new Citrus("lemon", "yellow", 5));
        fruits.add(new Fruit("plum", "purple"));

        return fruits;
    }

    @Test
    public void testTheSameColor() throws Exception {
        // Arrange
        List<Fruit> fruits = getFruits();
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Citrus("lemon", "yellow", 5));

        // Act
        List<Fruit> actual = Output.theSameColor("yellow", expected);

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByName() throws Exception {
        // Arrange
        List<Fruit> fruits = getFruits();
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple", "green"));
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Citrus("lemon", "yellow", 5));
        expected.add(new Fruit("plum", "purple"));

        // Act
        List<Fruit> actual = Output.sortByName(fruits);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSaveFruitXmlFile() throws Exception {
        File file_fruits = new File("fruits.xml");
        // Arrange
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Fruit("apple", "green"));
        expected.add(new Fruit("plum", "purple"));
        expected.add(new Citrus("orange", "red", 7));
        expected.add(new Fruit("grape", "green"));
        expected.add(new Fruit("pear", "yellow"));
        expected.add(new Citrus("lemon", "yellow", 5));

        // Act
        try {
            Output.saveFruitInFile(expected);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Fruit> actual = new ArrayList<>();
        try {
            actual.addAll(Output.readFruitFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    public void testGetFruitFromFilePositive() throws Exception {
        // Arrange
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana", "yellow"));
        expected.add(new Fruit("apple", "green"));
        expected.add(new Fruit("plum", "purple"));
        expected.add(new Citrus("orange", "red", 7));
        expected.add(new Fruit("grape", "green"));
        expected.add(new Fruit("pear", "yellow"));
        expected.add(new Citrus("lemon", "yellow", 5));

        // Act
        List<Fruit> actual = op.getFruitFromFile();

        // Assert
        assertEquals(actual, expected);

    }
}