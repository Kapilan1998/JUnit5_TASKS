import org.junit.jupiter.api.*;

public class OuterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all method executing");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all method executing");
    }

    @Test
    void outerTest1(){

    }

    @Test
    void outerTest2(){

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class innerTest{

        @BeforeAll
         void beforeAllInside(){
            System.out.println("before all method executing inside inner class...");
        }

        @AfterAll
         void afterAllInside(){
            System.out.println("after all method executing inside inner class...");
        }

        @Test
        void innerTest1(){

        }

        @Test
        void innerTest2(){

        }

        @Test
        void innerTest3(){

        }
    }
}
