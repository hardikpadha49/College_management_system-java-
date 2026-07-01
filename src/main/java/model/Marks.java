package model;

public class Marks {
    private int id;
    private int student_id;
    private String subject;
    private int marks;
    public Marks(int student_id,String subject, int marks){
        this.student_id=student_id;
        this.subject=subject;
        this.marks=marks;
    }
    public Marks(int id,int student_id,String subject, int marks){
        this.id=id;
        this.student_id=student_id;
        this.subject=subject;
        this.marks=marks;
    }
    //Getter
    public int getId(){
        return id;
    }
    public int getStudent_id(){
        return student_id;
    }
    public String getSubject(){
        return subject;
    }
    public int getMarks(){
        return marks;
    }
    //setters
    public void setSubject(String subject){
        this.subject=subject;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }

    @Override
    public String toString(){
        return "Marks{id=" + id + ", studentId=" + student_id + ", subject=" + subject + ", marks=" + marks + "}";
    }
}
