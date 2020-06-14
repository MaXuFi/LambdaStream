package lambdaTest;

import lambdaBean.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/10 23:27
 * @description
 */
public class LambdaDemo4 {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        List<String> collect = nameList.stream()
//                .map(x -> x.toUpperCase())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<Integer> collect1 = nameList.stream().map(String::length)
                .collect(Collectors.toList());

//        System.out.println(collect1);

        nameList.stream().mapToInt(String::length).forEach(System.out::println);

 //       System.out.println(collect);



        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");


        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        //将每个employee的年龄加1，将性别中的M换成male，F换成female
        //peek函数是一个特殊的函数，当函数没有返回值或者参数就是返回值的时候可以使用peek函数
        employees.stream().
                peek(employee -> {
                    employee.setAge(employee.getAge() + 1);
                    employee.setGender(employee.getGender().equals("M")? "male":"female");
                }).collect(Collectors.toList());

        //将“hello”，“world”两个字符串组成的集合，元素的每一个字母打印出来。
        //这个需求用map无法实现，map只能针对一位数组进行操作，数组里面还有数组，管道里面还有管道，它是无法处理的
        List<String> words = Arrays.asList("hello", "word");

        words.stream()
                .flatMap(w->Arrays.stream(w.split("")))
                .forEach(System.out::println);

    }
}
