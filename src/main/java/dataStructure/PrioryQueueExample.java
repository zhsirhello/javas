package dataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**、
 * PriorityQueue优先队列的使用，其remove方法是删除并返回其最小的元素。
 * //特点
 * 在实例化PriorityQueue时，可以在构造函数中提供比较器。然后队列中的项目顺序将根据提供的比较器来决定。
 * 如果没有提供比较器，则将使用Collection的自然顺序（Comparable）来排序元素。
 * 此集合中不允许为null。
 * 排队队长是排序中最少的项目。
 * PriorityQueue元素之间的排序关系是任意决定的。？
 * PriorityQueue未同步。PriorityBlockingQueue是PriorityQueue的线程安全对应。
 * PriorityQueue是无界的，它会根据队列中的元素数量动态增长。它在任何给定时间都具有内部能力，随着元素的添加而增加。这种内部容量和增量的政策没有指定或标准化。
 * 此PriorityQueue的iterator（）不保证以任何特定顺序遍历队列元素。
 * 表现明智 remove（）和contains（）方法采用线性时间。peek（），element（）和size（）需要固定的时间。offer（），poll（）和remove（）取O（log n）时间。
 * offer（）和add（）是Queue接口的方法，由PriorityQueue实现。这些用于在队列中插入元素。他们在PriorityQueue方面的表现相同，没有区别。
 */
public class PrioryQueueExample {
    public static void main(String[] args) {
        Comparator<String> queueComparator = new VowelComparator();
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(10,
                queueComparator);
        priorityQueue.add("orange");
        priorityQueue.add("fig");
        priorityQueue.add("watermelon");
        priorityQueue.add("lemon");
        while (priorityQueue.size() != 0) {
            System.out.println(priorityQueue.remove());
        }
    }
}

/**
 * 自定义排序，compare方法中有两个参数。如果返回负数，表示第一个参数小于第二个参数
 */
class VowelComparator implements Comparator<String> {

    @Override
    public int compare(String x, String y) {
        if (getVowelCount(x) < getVowelCount(y)) {
            return -1;
        } else if (getVowelCount(x) > getVowelCount(y)) {
            return 1;
        }
        return 0;
    }

    public int getVowelCount(String word) {
        int vowel = 0;
        for (int i = 0; i < word.length(); i++) {
            char chr = word.charAt(i);
            if (chr == 'a' || chr == 'A' || chr == 'e' || chr == 'E'
                    || chr == 'i' || chr == 'I' || chr == 'o' || chr == 'O'
                    || chr == 'u' || chr == 'U')
                vowel++;
        }
        return vowel;
    }
}
