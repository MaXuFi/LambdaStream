package lambdaTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/11 0:03
 * @description
 */
public class LambdaDemo5 {
    public static void main(String[] args) {

        //用于截取管道中的前n个元素
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .limit(2)
                .collect(Collectors.toList());

        //跳过管道中的前n个元素
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .skip(2)
                .collect(Collectors.toList());

        //对管道中的元素去重
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .distinct()
                .collect(Collectors.toList());

        //对管道中的元素进行排序（默认是按字母的自然顺序排列）
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .sorted()
                .collect(Collectors.toList());

        //串行化好处是可以保证顺序，但是处理速度慢一些
        //并行处理速度会快，但是无法保证执行顺序，可能导致最后的结果不是自己需要的
        //parallel()函数对管道中的元素进行并行处理，无法保证顺序性，可能会出现前面的元素后处理，后面的元素优先处理
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .parallel()
                .collect(Collectors.toList());
    }
}
