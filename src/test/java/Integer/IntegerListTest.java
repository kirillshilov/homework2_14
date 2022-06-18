package Integer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {

    private final IntegerListInterface test = new IntegerList();

    @BeforeEach
    void clearParam(){
        for (int i = 0; i < test.size(); i++) {
            test.remove(0);
        }

    }
    @Test
    void shouldReturnNullParamExceptionsWhenParamIsNull() {
        assertThrows(NullParamExceptoins.class, () -> test.add(null));
    }

    @Test
    void shouldReturnOutOfBoundExceptionsWhenArrayIsFull() {
        for (int i = 0; i < 10; i++) {
            test.add(5);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(10));

    }

    @Test
    void shouldReturnString() {
        assertEquals(5, test.add(5));
    }

    @Test
    void shouldReturnIndexOutOfBoundExceptionWhenArrayIsFull() {
        for (int i = 0; i < 10; i++) {
            test.add(5);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> test.add(0, 5));
        test.remove(0);
    }

    @Test
    void shouldReturnAddedInteger() {
        assertEquals(5, test.add(0, 5));
    }

    @Test
    void shouldReturnIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> test.set(11, 5));
    }

    @Test
    void shouldReturnStringSetMethod() {
        assertEquals(5, test.set(0, 5));
    }

    @Test
    void shouldReturnNotFoundExceptionsWhenElementNotFound() {
        assertThrows(NotFoundException.class, () -> test.remove(Integer.valueOf(8)));
    }

    @Test
    void shouldReturnIntegerIfRemoveSuccess() {
        test.add(7);
        assertEquals(7, test.remove(Integer.valueOf(7)));

    }

    @Test
    void shouldReturnOutOFBoundExceptionWhenIndexIsBigestWhenArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> test.remove(11));
    }

    @Test
    void shouldReturnStringWhenItemIsRemoved() {
        test.add(0, 5);
        assertEquals(5, test.remove(0));
    }

    @Test
    void returnTrueWhenArrayHaveItem() {
        test.add(5);
        assertTrue(test.contains(5));
    }

    @Test
    void returnFalseWhenItemNotFound() {
        assertFalse(test.contains(5));
    }

    @Test
    void shouldReturnIntWhenElementIsFound() {
        test.add(5);
        assertEquals(0, test.indexOf(5));
    }

    @Test
    void shouldReturnIntegerWhenElementIsFound() {
        test.clear();
        test.add(5);
        test.add(6);
        assertEquals(2, test.lastIndexOf(5));

    }

    @Test
    void shouldReturnMinusOneWhenElementNotFound() {
        assertEquals(-1, test.lastIndexOf(5));
    }

    @Test
    void shouldReturnIndexOutOfBoundsExceptionWhenNumberOfElemMoreWhenLenght() {
        test.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> test.get(11));

    }

    @Test
    void shouldReturnStringWhenElementIsSetUp() {
        test.add(5);
        assertEquals(5, test.get(0));

    }

    @Test
    void shouldReturnRuntimeExceptionWhenListIsNUll() {
        assertThrows(RuntimeException.class, () -> test.equals(null));
    }

    @Test
    void shouldReturnFalseWhenLenghtStringListsIsDeferent() {
        IntegerListInterface one = new IntegerList();
        test.add(5);
        assertNotEquals(test, one);

    }

    @Test
    void shouldReturnTrueWhenStringLIstIsEquals() {
        IntegerListInterface one = new IntegerList();
        one.add(5);
        test.add(5);
        assertEquals(test, one);

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
        test.add(5);
        Integer[] one = new Integer[test.size()];
        one[0] = 5;
        assertEquals(Arrays.toString(one), Arrays.toString(test.toArray()));
        test.remove(0);
    }

}