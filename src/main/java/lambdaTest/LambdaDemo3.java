package lambdaTest;

import lambdaBean.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liulongfei
 * @type
 * @create 2020/6/9 22:56
 * @description
 */
public class LambdaDemo3 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        //平常语法
        List<Employee> employeeList = employees.stream()
                .filter(e -> e.getAge() > 70 && e.getGender().equals("M"))
                .collect(Collectors.toList());

        //谓词的使用 and 并集
        List<Employee> employeeList1 = employees.stream()
                .filter(Employee.ageGreterThan70.and(Employee.genderEquealsWoman))
                .collect(Collectors.toList());

        //谓词的使用 and 或者
        List<Employee> employeeList2 = employees.stream()
                .filter(Employee.ageGreterThan70.or(Employee.genderEquealsWoman))
                .collect(Collectors.toList());

        //谓词的使用 negate 取反
        List<Employee> employeeList3 = employees.stream()
                .filter(Employee.ageGreterThan70.or(Employee.genderEquealsWoman.negate()))
                .collect(Collectors.toList());
        System.out.println(employeeList);

    }
}
