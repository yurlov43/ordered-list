import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedListTest {

    @Test
    public void add() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        Assert.assertEquals(orderedList.count(), 0);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(4);
        Assert.assertEquals(orderedList.count(), 4);
        Assert.assertEquals((int)orderedList.head.value, 1);
        Assert.assertEquals((int)orderedList.head.next.value, 2);
        Assert.assertEquals((int)orderedList.tail.value, 5);
        Assert.assertEquals((int)orderedList.tail.prev.value, 4);
        orderedList.clear(false);
        Assert.assertEquals(orderedList.count(), 0);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(4);
        Assert.assertEquals(orderedList.count(), 4);
        Assert.assertEquals((int)orderedList.head.value, 5);
        Assert.assertEquals((int)orderedList.head.next.value, 4);
        Assert.assertEquals((int)orderedList.tail.value, 1);
        Assert.assertEquals((int)orderedList.tail.prev.value, 2);
    }

    @Test
    public void find() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        Assert.assertEquals(orderedList.count(), 0);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(4);
        Assert.assertEquals(orderedList.find(56), null);
        Assert.assertEquals(orderedList.find(1), orderedList.head);
        Assert.assertEquals(orderedList.find(5), orderedList.tail);
    }

    @Test
    public void delete() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        Assert.assertEquals(orderedList.count(), 0);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(4);
        orderedList.delete(5);
        orderedList.delete(1);
        Assert.assertEquals(orderedList.find(56), null);
        Assert.assertEquals(orderedList.find(2), orderedList.head);
        Assert.assertEquals(orderedList.find(4), orderedList.tail);
        Assert.assertEquals(orderedList.count(), 2);
    }
}