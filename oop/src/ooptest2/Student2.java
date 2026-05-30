package ooptest2;

public class Student2 {
    //属性
    private String name;
    private int age;
    private String gender;
    //构造方法：一般会构造一个空参和一个全参
    public Student2(){
    }
    public Student2(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //set/get方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }


}
