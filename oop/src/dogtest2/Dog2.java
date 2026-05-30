package dogtest2;

public class Dog2 {
    //属性
    //姓名
    private String name;
    //年龄
    private int age;
    //get/set方法
    //姓名
    public void setName(String value){
        name =value;
    }
    public String getName(){
        return name;
    }
    //年龄
    public void setAge(int num){
        if (num>=0&&num<=15){
            age = num;
        }else{
            System.out.println(num+"不在限定范围内");
        }
    }
    public int getAge(){
        return age;
    }
    //行为
    public void eat(){
        System.out.println(age+"岁的"+name+"，正在吃骨头");
    }
}
