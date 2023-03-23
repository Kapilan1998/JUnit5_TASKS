import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.*;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit5Assertions {

    @Test
    void assertTrueTest(){
        assertTrue(15>5,"15 is greater than 5");
    }

    @Test
    void assertFalseTest(){
        BooleanSupplier condition = () -> 75 >100;
        assertFalse(condition, "75 is not greater than 100");
    }

    @Test
    void assertEqualsTest2(){
        float square = 5*5;
        float rectangle = 6*5;
        float delta =5;

        assertEquals(square,rectangle,delta);       // here third argument is different from the first 2 arguments
    }

    @Test
    void assertNotEqualsTest(){
        Integer value = 100;
        assertNotEquals(10,value,"The result can not be 100");
    }

    @Test
    void assertNotNullTest(){
        Object obj1 = new Object();
        assertNotNull(obj1,()->"The object must not be null");
    }

    @Test
    void assertNullTest(){
        Object obj2 = null;
        assertNull(obj2,()->"The object must be null");
    }

    @Test
    void assertSameTest(){
        String language = "Java Script";
        Optional optional = Optional.of((language));
                    // assertEquals(language,optional.get());
        assertSame(language,optional.get());
    }

    @Test
    void assertNotSameTest(){
        String frameWork = "node";
        Optional optional = Optional.of(frameWork);
        frameWork = "laravel";
        assertNotSame(frameWork,optional.get());
    }

    @Test
    void assertArrayEqualsTest(){
        char[] expected ={'J','a','v','a'};
        char[] actual ="Java".toCharArray();

        assertArrayEquals(expected,actual,"Both array shoul be equal");
    }

    @Test
    void assertAllTest(){
        Employee employee = new Employee("Vetti","Maran");
        assertAll(
                "employeeInfo",
                () -> assertNotNull(employee.getFirstName(),()->"First name should not be null"),
                ()-> assertNotNull("Maran",employee.getLastName().toLowerCase()));
            }

     @Test
     void assertThrowsTest(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Your exception message");
                }
        );
        assertEquals("Your exception message",exception.getMessage());
     }

     @Test
    void assertDoesNotThrowTest(){
        String input ="25.24E+8";
        assertDoesNotThrow(()->Double.parseDouble(input),"String not able to parse into double");
     }

     @Test
    public void assertIterableEqualsTest(){
         Iterable<String> list1 = new ArrayList<>(Arrays.asList("KK","PK","MK"));
         Iterable<String> list2 = new LinkedList<>(Arrays.asList("KK","PK","MK"));

         assertIterableEquals(list1,list2);
     }

     @Test
    void assertTimeOutTest(){
        assertTimeout(
                Duration.ofMillis(1000),
                () -> {
                    //code that requires less than 1000 milli seconds to execute
                    Thread.sleep(800);
                }
        );
     }

//     @Test
//    Void assertLinesMatchTest(){
//        List<String> expected = Arrays.asList("Scala","34","Java");
//        List<String> actual = Arrays.asList("Scala","34","Java");
//
//        assertLinesMatch(expected,actual);
//         return null;
//     }

     @Test
    void failTest(){
        //test not completed yet
//         fail("test not completed yet");
     }
}
