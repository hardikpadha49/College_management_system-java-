package model;

public class Teacher {
    private int id;
    private int user_id;
    private String name;
    private String subject;
    private String email;

    public Teacher(int user_id,String name,String subject,String email){
        this.user_id=user_id;
        this.name=name;
        this.subject=subject;
        this.email=email;
    }
    public Teacher(int id,int user_id,String name,String subject,String email){
        this.id=id;
        this.user_id=user_id;
        this.name=name;
        this.subject=subject;
        this.email=email;
    }
    //Getters

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName(){
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }
    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject){
        this.subject=subject;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return "Teacher{id="+id+", name="+name+", subject="+subject+", email="+email+'}';
    }
}
