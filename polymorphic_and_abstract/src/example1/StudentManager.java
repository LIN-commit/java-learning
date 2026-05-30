package example1;

public class StudentManager {
    public void register(Person person){
        System.out.println("姓名为"+person.getName()+"的账户注册成功，账号为"+person.getNumber()+"，密码"+person.getPassword());
        person.work();
    }
}
