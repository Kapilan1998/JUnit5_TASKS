import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SharedTempDirectoryTest {
    @TempDir
    static Path sharedTempDir;

    @BeforeAll
    static void BeforeAll(){
        System.out.println(sharedTempDir);
    }

    @Test
    void testWithTempDir(@TempDir Path tempDir) throws IOException{
        Path numbersPath = tempDir.resolve("numbersTest.txt");

        List<String> numberList = Arrays.asList("100","200","300");
        Files.write(numbersPath,numberList);

        assertAll(
                () -> assertTrue(Files.exists(numbersPath),"File should exist"),
                () -> assertLinesMatch(numberList,Files.readAllLines((numbersPath)))
        );
    }

    @Test
    void testAsSharedTempDir1() throws IOException{
        Path numbersPath =sharedTempDir.resolve("myNumbers.txt");

        List<String> numberList = Arrays.asList("15","20","25");
        Files.write(numbersPath,numberList);

        assertAll(
                () -> assertTrue(Files.exists(numbersPath),"File should exist"),
                () -> assertLinesMatch(numberList,Files.readAllLines(numbersPath))
        );
    }

    @Test
    void testAsSharedTempDir2() throws IOException{
        Path path =sharedTempDir.resolve("names.txt");

        List<String> nameList = Arrays.asList("Kamal","Pooja","Raj");
        Files.write(path,nameList);
        assertLinesMatch(nameList,Files.readAllLines(path));
    }

    @AfterAll
    static void AfterAll(){
        System.out.println(sharedTempDir.getFileName());
    }

}
