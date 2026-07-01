package model;

public class Student {
    private int id;
    private int userId;
    private String rollNo;
    private String name;
    private String className;

    public Student(int userId,String rollNo,String name,String className){
        this.userId=userId;
        this.rollNo=rollNo;
        this.name=name;
        this.className=className;
    }

    public Student(int id,int userId,String rollNo,String name,String className){
        this.id=id;
        this.userId=userId;
        this.rollNo=rollNo;
        this.name=name;
        this.className=className;
    }

    //Getters

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public String getClassName() {
        return className;
    }

    //Setters
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Student{id="+id+", name="+name+" , rollno="+rollNo+" ,classname="+className+'}';
    }
}
