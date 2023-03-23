import org.junit.jupiter.api.*;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Dependency Inkjection for constructrs and Methods")
public class DependencyInkjectionConstructorsAndMethod {

    private static first f2;

    public DependencyInkjectionConstructorsAndMethod(TestInfo testInfo){
        System.out.println("inside constructor ...");
    String displayName = testInfo.getDisplayName();
    assertEquals("Dependency Inkjection for constructrs and Methods", displayName);
    }
    @BeforeAll
    static void beforeAll(TestInfo testInfo){
        f2 = new first();
        System.out.println("@BeforeAll is executing...");
        System.out.println(testInfo.getTags());
    }

    @AfterAll
    static void afterAll(TestInfo testInfo){
        f2 = null;
        System.out.println("@AfterAll is executing....");
//        System.out.println(testInfo.getTags());
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
    @Tag(value = "tag_1")
    @DisplayName("Adding 2 positive number")
    void addTwoPositiveInteger(TestInfo testInfo) {
        System.out.println("add Two Positive Integer......");
        int actualResult = f2.add(15, 20);
        assertEquals(35, actualResult);
        Set<String> myTags = testInfo.getTags();
        assertTrue(myTags.contains("tag_1"));
    }

    @Test
    @Tag(value = "tag_2")
    @DisplayName("Adding 2 negative number")
    void addTwoNegativeInteger(TestInfo testInfo) {
        System.out.println("add Two Negative Integer......");
        int actualResult = f2.add(-10, -30);
        assertEquals(-40, actualResult);
        System.out.println(testInfo.getTags());
    }

    @Test
    @DisplayName("Adding 2 numbers")
    void addPositiveAndNegativeNumber() {
        System.out.println("adding Positive And Negative Number ......");
        int actualResult = f2.add(15, -20);
//        assertEquals(-5, actualResult);
        assertThat(actualResult, is(equalTo(-5)));
    }

}
