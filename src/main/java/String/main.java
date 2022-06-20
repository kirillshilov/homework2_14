package String;

public class main {
    public static void main(String[] args) {


StringList test = new StringList ();
        System.out.println(test.add("Samm"));
        System.out.println(test.add("ddd"));
        System.out.println(test.add(0, "Summ"));
        System.out.println(test.isEmpty());
        System.out.println(test.size());
        System.out.println(test.remove(0));
        System.out.println(test.remove("Samm"));
        System.out.println(test.contains("ddd"));
        System.out.println(test.get(0));
    }
}
