package example1;

public class Person {
    private String name;
    private String number;
    private String password;

    public Person() {
    }

    public Person(String name, String number, String password) {
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String numble) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void work(){
        System.out.println("work");
    }
}
