package lambdaTest;

import lambdaBean.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/14 22:25
 * @description reduce（）函数，集合元素规约
 */
public class LambdaDemo8 {
  public static void main(String[] args) {
    // integer 元素规约
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    Integer reduce = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
    // 21
    System.out.println(reduce);

    Integer reduce1 = numbers.stream().reduce(0, Integer::sum);

    // 21
    System.out.println(reduce1);

    List<String> letters = Arrays.asList("a", "b", "c", "d", "e");

    // String 元素规约
    String reduceString =
        letters.stream().reduce("", (partialString, element) -> partialString + element);
    // abcde
    System.out.println(reduceString);

    String reduceString2 = letters.stream().reduce("", String::concat);
    System.out.println(reduceString2);

      //计算所有员工年龄总和
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

      Integer sumAge = employees.stream()
     //               .map(employee -> employee.getAge())
                    .map(Employee::getAge)
                    .reduce(0, Integer::sum);

     //三个参数，和使用map进行数据类型转换是一样的
     Integer reduceTotalAge = employees.stream()
        .reduce(0, (totalAge, emp) -> totalAge + emp.getAge(), Integer::sum);

     System.out.println(sumAge);

    //大数据量的元素规约运算，更能体现出stream并行流
    //在运行并行流计算的时候，可能会将多个元素分成多个组进行运算，更快的将分组结果进行累加
    Integer reduceTotalAge2 = employees.parallelStream()
        .map(Employee::getAge)
        .reduce(0, Integer::sum, Integer::sum);

  }

}
