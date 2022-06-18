package Integer;

import java.util.Arrays;


public class IntegerList implements IntegerListInterface{

    private final Integer [] integerList;
    private static int count = 0;


    public IntegerList() {
        integerList = new Integer [10];
        Arrays.fill(integerList, 0);
    }


    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullParamExceptoins("параметры не заданы");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(0)) {
                integerList[i] = item;
                count++;
                return item;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index > integerList.length || count == integerList.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = integerList.length; i > index; i--) {
            if (!integerList[i - 1].equals(0)) {
                integerList[i] = integerList[i - 1];
            }
        }
        integerList[index] = item;
        count++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index > integerList.length || index > count) {
            throw new IndexOutOfBoundsException();
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < count ; i++) {
            if (integerList[i].equals(item)) {
                integerList[i] = 0;
                for (int j = i; j < count; j++) {
                    integerList[j] = integerList[j + 1];
                }
                count--;
                return item;
            }
        }

        throw new NotFoundException("Element not Found");
    }

    @Override
    public Integer remove(int index) {

        if (index > count || index > integerList.length) {
            throw new IndexOutOfBoundsException();
        }
        Integer one = integerList[index];
        for (int i = index; i < integerList.length - 1; i++) {
            integerList[i] = 0;
            integerList[i] = integerList[i + 1];
        }
        count--;
        return one;
    }

    @Override
    public boolean contains(Integer item) {
        IntegerList.sortInsertion(integerList);
       return (0 <(Arrays.binarySearch(integerList, item)));
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int counter = count-1;
        int shet = 0;
        for (int i = counter; i >= 0 ; i--) {
            if (integerList[i].equals(item)){
                return shet+1;
            }
            shet++;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException();
        }
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (count != otherList.size()){
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (!integerList[i].equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return integerList[0].equals(0);
    }

    @Override
    public String clear() {
        Arrays.fill(integerList, 0);
        return "Cleared";
    }

    @Override
    public Integer []  toArray() {
        Integer [] one = new Integer[size()];
        System.arraycopy(integerList, 0, one, 0, count);
        return one;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerList that = (IntegerList) o;
        return Arrays.equals(integerList, that.integerList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerList);
    }


    public static void sortInsertion(Integer [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = generateRandomArray();

        long start = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - start);

    }
}
