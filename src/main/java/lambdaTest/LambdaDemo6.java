package lambdaTest;

import lambdaBean.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/11 22:32
 * @description
 */
public class LambdaDemo6 {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        cities.stream().sorted(Comparator.naturalOrder()).forEach(System.out ::println);

        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);

        //自然排序
        numbers.sort(Comparator.naturalOrder());
        //倒序排列
        numbers.sort(Comparator.reverseOrder());

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

        //年龄正序排列
        employees.sort(Comparator.comparing(Employee::getAge));
        //年龄倒序
        employees.sort(Comparator.comparing(Employee::getAge).reversed());
        employees.forEach(System.out::println);


        //不加reversed，两个都是正序
        //最后加reversed,两个都是倒序
        //在第一个后加reversed，第一个是倒序，第二个是正序
        employees.sort(
                Comparator.comparing(Employee::getGender)
                           .thenComparing(Employee::getAge)
                            .reversed()
        );
    }
}
