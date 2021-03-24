import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    private static Stream<Arguments> TestInputParameter(){
        return Stream.of(
                // normal testcase
                Arguments.of(new int[]{5, 2, 3, 4}, new int[]{2, 3, 4, 5}),
                Arguments.of(new int[]{-2, 2, -10}, new int[]{-10, -2, 2}),
                Arguments.of(new int[]{0, 1, -5, 3, 2}, new int[]{-5, 0, 1, 2, 3}),
                Arguments.of(new int[]{0, 1, 0, 1, 0}, new int[]{0, 0, 0, 1, 1}),
                Arguments.of(new int[]{5, 3, -9, 7, 7, 10}, new int[]{-9, 3, 5, 7, 7, 10})
        );
    }

    @ParameterizedTest
    @MethodSource("TestInputParameter")
    void TestPrioriQueue(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int[] result = new int[random_array.length];

        for (int i=0; i<random_array.length; i++) {
            test.add(random_array[i]);
        }
        for (int i=0; test.size()>0 ; i++){
            result[i] = test.poll();
        }

        Assertions.assertArrayEquals(correct_array, result);
    }

    @Test
    void whenExceptionThrown_thenOfferEisNull(){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            test.offer(null);
        });
    }

    @Test
    void whenExceptionThrown_thenAddEisNull(){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            test.add(null);
        });
    }

    @Test
    void whenExceptionThrown_thenNoElementCanRemove(){
        PriorityQueue<TestClass> test = new PriorityQueue<TestClass>();
        TestClass tc1 = new TestClass("123", 1);
        test.add(tc1);
        Exception exception = Assertions.assertThrows(ClassCastException.class, () -> {
            TestClass tc2 = new TestClass("321", 2);
            test.add(tc2);
        });
    }

    class TestClass{
        public String str;
        public int I;
        TestClass(String str, int I){
            this.str = str;
            this.I = I;
        }
    }
}
