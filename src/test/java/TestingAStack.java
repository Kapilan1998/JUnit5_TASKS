import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A Stack")
public class TestingAStack {
    private Stack<String> stack;

    @Test
    @DisplayName("is instantiated with new stack()")
    void IsInstantiatedWithNew(){
        stack = new Stack<String>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew{

        @BeforeEach
        void createNewStack(){
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws empty stack exception when popped")
        void throwsExceptionWhenPopped(){
            assertThrows(EmptyStackException.class,stack::pop);
        }

        @Test
        @DisplayName("throws empty stack exception when peeked")
        void throwsExceptionWhenPeeked(){
            assertThrows(EmptyStackException.class,stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing{
            String name = "Kapilan";

            @BeforeEach
            void pushAnElement(){
                stack.push(name);
            }

            @Test
            @DisplayName("it is not no longer empty")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped(){
                assertEquals(name,stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the peek element but remains not empty")
            void returnElementWhenPeeked(){
                assertEquals(name,stack.peek());
            }
        }
    }
}
