
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

@DisplayName("testFirst class loading")
public class testFirst {

    private static first f1;

    @BeforeAll
    static void beforeAll(){
        f1 = new first();
        System.out.println("@BeforeAll is executing...");
    }

    @AfterAll
    static void afterAll(){
        f1 = null;
        System.out.println("@AfterAll is executing....");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("@BeforeEach is executing ....");
    }

    @AfterEach
    void afterEach(){
        System.out.println("@AfterEach is executing ....");
    }

    @Test           //when we are writing test cases we need to put @Test annotation
    @DisplayName("Adding 2 positive number")        //easy for readability, understand in test report
    void addTwoPositiveInteger() {
        System.out.println("add Two Positive Integer......");
        int actualResult = f1.add(15, 20);
        assertEquals(35, actualResult);
    }

    @Test
//    @Disabled("Some errors need to be check")
    @DisplayName("Adding 2 negative number")
    void addTwoNegativeInteger() {
        System.out.println("add Two Negative Integer......");
        int actualResult = f1.add(-10, -30);
        assertEquals(-40, actualResult);
    }

    @Test
    @DisplayName("Adding 2 numbers")
    void addPositiveAndNegativeNumber() {
        System.out.println("adding Positive And Negative Number ......");
        int actualResult = f1.add(15, -20);
//        assertEquals(-5, actualResult);
        assertThat(actualResult, is(equalTo(-5)));
    }

}

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
 class testSecond {


    private static first f2;

    @BeforeAll
    static void beforeAll(){
        f2 = new first();
        System.out.println("@BeforeAll is executing...");
    }

    @AfterAll
    static void afterAll(){
        f2 = null;
        System.out.println("@AfterAll is executing....");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("@BeforeEach is executing ....");
    }

    @AfterEach
    void afterEach(){
        System.out.println("@AfterEach is executing ....");
    }

    @Test
    @Disabled("some errors are found")          // stop temperorly calling this function
    void add_2_positive_number() {
        int actualResult = f2.add(15, 25);
        assertEquals(40, actualResult);
    }


}

