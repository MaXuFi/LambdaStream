package lambdaTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/9 21:53
 * @description 初识Stream管道流
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        //list集合
        List<String> testList = Arrays.asList("lina", "joge", "lamb", "yaml");
        List<String> testList_new = testList.stream()
                .filter(s -> s.startsWith("l"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        //array数组
        String arrayString[] = {"lina", "joge", "lamb", "yaml"};
        Stream<String> arrayString1 = Stream.of(arrayString);

        //文本文件转为管道流
        try {
            Stream<String> lines = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(testList_new);
    }
}
