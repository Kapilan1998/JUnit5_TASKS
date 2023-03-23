import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagTest {

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
        f1= null;
    }

    @Test
    @Tag(value = " dev")
    void add_two_positive_number(){
        f1 = new first();
        int actualResult = f1.add(20,80);
        assertEquals(100,actualResult);
    }

    @Test
    @Tag(value = " dev")
    void add_Two_Negative_Integer() {
        int actualResult = f1.add(-10, -30);
        assertEquals(-40, actualResult);
    }

    @Test
    @Tag(value = " prod")
    @Tag(value = " dev")
    void add_Positive_And_Negative_Number() {
        int actualResult = f1.add(15, -20);
        assertEquals(-5, actualResult);
    }

}
