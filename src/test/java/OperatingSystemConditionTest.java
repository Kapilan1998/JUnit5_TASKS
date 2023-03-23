
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OperatingSystemConditionTest {
    private static first f1;

    @BeforeAll
    static void beforeAllMethod(){
        f1 = new first();
        System.out.println("executing @BeforeAll method...");
    }

    @BeforeEach
    void beforeEachMethod(){
        System.out.println("executing @BeforeEach method...");
    }

    @AfterEach
    void afterEachMethod(){
        System.out.println("executing @AfterEach method...");
    }

    @AfterAll
    static void afterAllMethod(){
        System.out.println("executing @AfterAll method...");
    }

    @Test
    @EnabledOnOs(value = {OS.WINDOWS})
    void add_two_positive_number(){
        f1 = new first();
        int actualResult = f1.add(20,80);
        assertEquals(100,actualResult);
    }

    @Test
    @DisabledOnOs(value = {OS.MAC,OS.WINDOWS})
    void add_Two_Negative_Integer() {
        int actualResult = f1.add(-10, -30);
        assertEquals(-40, actualResult);
    }

    @Test
    @DisabledOnOs(value = {OS.LINUX})
    void add_Positive_And_Negative_Number() {
        int actualResult = f1.add(15, -20);
        assertEquals(-5, actualResult);
    }
}
