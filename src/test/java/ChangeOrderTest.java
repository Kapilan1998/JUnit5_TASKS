import org.junit.jupiter.api.*;
import org.junit.runner.manipulation.Alphanumeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(value = MethodOrderer.Alphanumeric.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ChangeOrderTest {
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
    @Order(value = 3)
    void add_Two_Positive_number(){
        f1 = new first();
        int actualResult = f1.add(20,80);
        assertEquals(100,actualResult);
    }

    @Test
    @Order(value = 1)
    void add_Two_Negative_Integer() {
        int actualResult = f1.add(-10, -30);
        assertEquals(-40, actualResult);
    }

    @Test
    @Order(value = 2 )
    void Add_Positive_And_Negative_Number() {
        int actualResult = f1.add(15, -20);
        assertEquals(-5, actualResult);
    }
}
