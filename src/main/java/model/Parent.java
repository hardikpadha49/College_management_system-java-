package model;

public class Parent {
    private int id;
    private int user_id;
    private String name;
    private String phone_no;
    private int student_id;

    public Parent(int user_id,String name,String phone_no,int student_id){
        this.user_id=user_id;
        this.name=name;
        this.phone_no=phone_no;
        this.student_id=student_id;
    }

    public Parent(int id,int user_id,String name,String phone_no,int student_id){
        this.id=id;
        this.user_id=user_id;
        this.phone_no=phone_no;
        this.name=name;
        this.student_id=student_id;
    }

    //Getters

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getName(){
        return name;
    }

    public int getStudent_id() {
        return student_id;
    }

    //Setters
    public void setPhone_no(String phone_no) {
        this.phone_no= phone_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString(){
        return "Parent{id="+id+", name="+name+" , Phone no="+phone_no+" ,Student id="+student_id+'}';
    }
}


