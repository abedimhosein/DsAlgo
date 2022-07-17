package ds;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(60);
        numbers.print();

        numbers.insertAt(70, 3);
        numbers.print();

        numbers.insert(80);
        numbers.print();

        Array numbers1 = new Array(3);
        numbers1.insert(10);
        numbers1.insert(40);

        var a = numbers.intersect(numbers1);
        a.print();
        System.out.println(a.max());

        a.removeAt(0);
        a.print();
    }
}
