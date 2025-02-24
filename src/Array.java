import java.util.ArrayList;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        resizeIfRequired();

        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    public void insertFirst(int item) {
        resizeIfRequired();

        for (int i = count - 1; i >= 0; i--)
            items[i + 1] = items[i];

        items[0] = item;
        count++;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count + 1];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }

    public int max() {
        int max = 0;
        for (int item : items)
            if (item > max)
                max = item;

        return max;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        var intersection2 = new Array(intersection.count);

        for (int item : intersection.items)
            if (intersection2.indexOf(item) < 0 && item != 0)
                intersection2.insert(item);

        return intersection2;
    }

    public Array union(Array other) {
        var union = Array.this;

        for (int item : other.items)
            if (this.indexOf(item) < 0 && item != 0)
                union.insert(item);

        var union2 = new Array(union.count);

        for (int item : union.items)
            if (union2.indexOf(item) < 0 && item != 0)
                union2.insert(item);

        return union2;
    }

    public Array serialize(){
        var currArray = new Array(count);

        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= i; j++)
                if (currArray.indexOf(items[i]) < 0){
                    if (items[i] < currArray.items[j])
                        currArray.insertAt(items[i], currArray.indexOf(currArray.items[j]));
                    if (i == j)
                        currArray.insert(items[i]);
                }
        }
        return currArray;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public void removeLast() {
        count--;
    }

    public void removeFirst() {
        for (int i = 0; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void print() {
        var list = new ArrayList<>();
        for (int i = 0; i < count; i++)
            list.add(items[i]);
        System.out.println(list);
    }
}