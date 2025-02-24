import org.junit.Test;

public class ArrayTest {
    @Test
    public void Test() {
        System.out.println("----------Testing Array Started---------");
        var array = new Array(5);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        //array.insert(30);
        System.out.println(array.indexOf(30));
        array.print();
        System.out.println(array.max());
        array.insertAt(15, 2);
        array.print();
        array.removeAt(1);
        array.insert(30);
        array.insert(-10);
        array.print();
        var array2 = new Array(5);
        array2.insert(5);
        array2.insert(25);
        array2.insert(30);
        array2.insert(30);
        array2.insertAt(40, 2);
        array2.insertAt(50, 3);
        array2.insertAt(60, 4);
        array2.insert(-10);
        array2.insert(-10);
        array2.print();
        var newIntersectArray = array.intersect(array2);
        System.out.println("New Intersect Array");
        newIntersectArray.print();
        var newUnionArray = array.union(array2);
        System.out.println("New Union Array");
        newUnionArray.serialize().print();

        var array3 = new Array(5);
        array3.insert(8);
        array3.insert(8);
        array3.insert(8);
        array3.insert(7);
        array3.insert(7);
        array3.insert(10);
        array3.insert(3);
        array3.insert(4);
        array3.insert(2);
        array3.insert(6);
        array3.insert(5);
        array3.insertAt(1, 5);
        array3.insert(11);
        array3.insert(9);
        array3.insert(12);
        array3.insert(12);
        array3.insert(0);
        array3.insert(12);
        System.out.println("Serial Array");
        array3.print();
        array3.serialize().print();
        var array4 = array3.serialize();
        array4.insertFirst(13);
        array4.insert(14);
        array4.insert(16);
        array4.insert(15);
        System.out.println(array4.max());
        array4.print();
        array4.serialize().print();
        array4.removeFirst();
        array4.removeLast();
        array4.removeLast();
        array4.removeFirst();
        array4.removeLast();
        array4.print();
        array4.reverse();
        array4.print();
        System.out.println("----------Testing Array Ended---------");
        System.out.println();
    }
}

