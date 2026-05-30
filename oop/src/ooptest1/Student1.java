package ooptest1;

public class Student1 {
    //属性
    private String name;
    private int age;
    private int height;
    private int weight;

    //get/set方法
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

    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    //行为
    public void study(){
        System.out.println(name +"努力学习");
    }
}
