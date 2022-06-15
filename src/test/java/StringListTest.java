
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    private final StringListInterface test = new StringList();

    @Test
    void shouldReturnNullParamExceptionsWhenParamIsNull() {
        assertThrows(NullParamExceptoins.class,()->test.add(null));
    }
    @Test
    void shouldReturnOutOfBoundExceptionsWhenArrayIsFull() {
        for (int i = 0; i < 10; i++) {
            test.add("aaa");
        }
        assertThrows(IndexOutOfBoundsException.class,()->test.add("CCC"));

    }
    @Test
    void shouldReturnString() {
        assertEquals("AAA", test.add("AAA"));
    }

    @Test
    void shouldReturnIndexOutOfBoundExceptionWhenArrayIsFull() {
        for (int i = 0; i < 10; i++) {
            test.add("aaa");
        }

        assertThrows(IndexOutOfBoundsException.class,()->test.add(0,"CCC"));
        test.remove(0);
    }
    @Test
    void shouldReturnAddedString() {

assertEquals("AAA",test.add(0,"AAA"));
        test.remove("AAA");
    }

    @Test
    void shouldReturnIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class,()->test.set(11,"AAA"));
    }
    @Test
    void shouldReturnStringSetMethod() {
        assertEquals("AAA",test.set(0, "AAA"));
    }
    @Test
    void shouldReturnNotFoundExceptionsWhenElementNotFound() {
        assertThrows(NotFoundException.class,()-> test.remove("rrrrrrrrrrrrrrrrrrrrr"));
    }
    @Test
    void shouldReturnStringIfRemoveSuccess() {
        test.add("aaa");
        assertEquals("aaa",test.remove("aaa"));

    }
    @Test
    void shouldReturnOutOFBoundExceptionWhenIndexIsBigestWhenArray() {
        assertThrows(IndexOutOfBoundsException.class,()-> test.remove(11));
    }
    @Test
    void shouldReturnStringWhenItemIsRemoved() {
        test.add(0,"AAA");
assertEquals("AAA", test.remove(0));
    }
    @Test
    void returnTrueWhenArrayHaveItem() {
        test.add("AAA");
        assertTrue(test.contains("AAA"));
        test.remove("AAA");
    }
    @Test
    void returnFalseWhenItemNotFound() {
        assertFalse(test.contains("AAA"));
    }
    @Test
    void shouldReturnIntWhenElementIsFound() {
        test.add("AAA");
        assertEquals(0, test.indexOf("AAA"));
        test.remove("AAA");
    }
    @Test
    void shouldReturnIntegerWhenElementIsFound() {
        test.add("AAA");
        test.add("BBB");
        assertEquals(2, test.lastIndexOf("AAA"));
        test.remove(0);
        test.remove(0);
    }
    @Test
    void shouldReturnMinusOneWhenElementNotFound() {
        assertEquals(-1, test.lastIndexOf("AAA"));
    }

    @Test
    void shouldReturnIndexOutOfBoundsExceptionWhenNumberOfElemMoreWhenLenght() {
        test.add("AAA");
        assertThrows(IndexOutOfBoundsException.class,()->test.get(11));
        test.remove(0);
    }
    @Test
    void shouldReturnStringWhenElementIsSetUp() {
        test.add("AAA");
        assertEquals("AAA", test.get(0));
        test.remove(0);
    }
    @Test
    void shouldReturnRuntimeExceptionWhenListIsNUll() {
        assertThrows(RuntimeException.class,()->test.equals(null));
    }
   @Test
    void shouldReturnFalseWhenLenghtStringListsIsDeferent() {
        StringListInterface one = new StringList();
       test.add("AAA");
       assertFalse(test.equals(one));
       test.remove(0);
    }
  @Test
  void shouldReturnTrueWhenStringLIstIsEquals() {
      StringListInterface one = new StringList();
      one.add("AAA");
      test.add("AAA");
      assertTrue(test.equals(one));
      test.remove(0);
    }
    @Test
    void couldReturnSizeOfStringList() {
    assertEquals(0, test.size());
    }

    @Test
    void shouldReturnEmpty() {
        assertTrue(test.isEmpty());
    }

    @Test
    void clear() {
        assertEquals("Cleared", test.clear());
    }

    @Test
    void shouldReturnStringArray() {
        test.add("AAA");
        String [ ] one = new String[test.size()];
        one[0] = "AAA";
        assertEquals (Arrays.toString(one), Arrays.toString(test.toArray()));
        test.remove(0);
    }

}