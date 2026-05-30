package oop_extend_case2;

public class Employee {
    //共同属性
    private String number;
    private String name;
    private int salary;
    //空参构造
    public Employee() {
    }
    //全参构造
    public Employee(String number, String name, int salary) {
        this.number = number;
        this.name = name;
        this.salary = salary;
    }

    //get/set方法
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //共同行为
    public void work(){
        System.out.println("工作");
    }
    public void eat(){
        System.out.println("吃饭");
        /*
        经理和厨师的吃饭行为只是当前场景下的共性表现，
        父类只负责定义通用行为规范，不应该写死具体实现，
        否则后续子类扩展时会失去灵活性。
         */
    }
}
