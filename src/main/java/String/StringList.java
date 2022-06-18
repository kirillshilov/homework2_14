package String;

import java.util.Arrays;

public class StringList implements StringListInterface {


    private final String [] stringList;
    private static int count = 0;


    public StringList() {
        stringList = new String[10];
        Arrays.fill(stringList, "null");
    }


    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullParamExceptoins("параметры не заданы");
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals("null")) {
                stringList[i] = item;
                count++;
                return item;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String add(int index, String item) {
        if (index > stringList.length || count == stringList.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = stringList.length; i > index; i--) {
            if (!stringList[i - 1].equals("null")) {
                stringList[i] = stringList[i - 1];
            }
        }
        stringList[index] = item;
        count++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if ((index > stringList.length) || (index > count)) {
            throw new IndexOutOfBoundsException();
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < count ; i++) {
            if (stringList[i].equals(item)) {
                stringList[i] = "null";
                for (int j = i; j < count; j++) {
                    stringList[j] = stringList[j + 1];
                }
                count--;
                return item;
            }
        }

        throw new NotFoundException("Element not Found");
    }

    @Override
    public String remove(int index) {

        if (index > count || index > stringList.length) {
            throw new IndexOutOfBoundsException();
        }
        String one = stringList[index];
        for (int i = index; i < stringList.length - 1; i++) {
            stringList[i] = "null";
            stringList[i] = stringList[i + 1];
        }
        count--;
        return one;

    }

    @Override
    public boolean contains(String item) {
        for (String s : stringList) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        int counter = count-1;
        int shet = 0;
        for (int i = counter; i >= 0 ; i--) {
            if (stringList[i].equals(item)){
                return shet+1;
            }
           shet++;
        }
return -1;
    }

    @Override
    public String get(int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException();
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
if (count != otherList.size()){
    return false;
}
        for (int i = 0; i < count; i++) {
            if (!stringList[i].equals(otherList.get(i))){
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
        return stringList[0].equals("null");
    }

    @Override
    public String clear() {
        for (int i = 0; i < stringList.length; i++) {
            stringList[i] = "null";
        }
        return "Cleared";
    }

    @Override
    public String []  toArray() {
        String [] one = new String[size()];
        System.arraycopy(stringList, 0, one, 0, count);
        return one;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringList that = (StringList) o;
        return Arrays.equals(stringList, that.stringList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(stringList);
    }

}
