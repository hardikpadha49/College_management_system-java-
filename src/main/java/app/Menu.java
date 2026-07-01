package app;
import service.*;
import model.*;


import java.util.Scanner;

public class Menu {
    private StudentService studentService;
    private TeacherService teacherService;
    private ParentService parentService;
    private MarksService marksService;
    private final Scanner sc = new Scanner(System.in);

    public Menu(StudentService studentService, TeacherService teacherService, ParentService parentService, MarksService marksService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.parentService = parentService;
        this.marksService = marksService;

    }

    private void printHeader(String title) {
        System.out.println("\n=================================");
        System.out.println("        " + title);
        System.out.println("=================================");
    }

    private int getIntInput(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } catch (Exception e) {
                System.out.print("Enter valid number\n");
                sc.nextLine();
            }
        }
    }


    private String getStringInput(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public void adminMenu() {
        while (true) {

            printHeader("ADMIN MENU");

            System.out.println("===== STUDENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. View Student By ID");

            System.out.println("\n===== TEACHER =====");
            System.out.println("6. Add Teacher");
            System.out.println("7. Update Teacher");
            System.out.println("8. Delete Teacher");
            System.out.println("9. View All Teachers");
            System.out.println("10. View Teacher By ID");

            System.out.println("\n===== PARENT =====");
            System.out.println("11. Add Parent");
            System.out.println("12. Update Parent");
            System.out.println("13. Delete Parent");
            System.out.println("14. View Parent By ID");
            System.out.println("15. View All Parents");

            System.out.println("\n0. Exit");

            int choice = getIntInput("Enter Choice: ");

            try {
                switch (choice) {
                    // ================= STUDENT =================

                    case 1:
                        String roll = getStringInput("Roll No: ");
                        String name = getStringInput("Name: ");
                        String cls = getStringInput("Class: ");

                        studentService.createStudent(roll, name, cls);
                        System.out.println("Student Added");
                        break;
                    case 2:
                        int sid=getIntInput("Enter Student ID: ");
                        Student s=studentService.getStudentById(sid);
                        if(s==null){
                            System.out.println("Student not found!");
                            break;
                        }
                        String newRoll = getStringInput("New Roll: ");
                        String newName = getStringInput("New Name: ");
                        String newClass = getStringInput("New Class: ");
                        studentService.updateStudent(sid,s.getUserId(),newRoll,newName,newClass);
                        System.out.println("Student Updated");
                        break;
                    case 3:
                        int id=getIntInput("Enter Student ID: ");
                        studentService.deleteStudent(id);
                        System.out.println("Student Deleted");
                        break;
                    case 4:
                        studentService.getAllStudents().forEach(System.out::println);
                        break;
                    case 5:
                        int sid1=getIntInput("Enter Student ID: ");
                        System.out.println(studentService.getStudentById(sid1));
                        break;

                    // ================= TEACHER =================

                    case 6:
                        String u=getStringInput("Username: ");
                        String p=getStringInput("Password: ");
                        String tn=getStringInput("Name: ");
                        String sub=getStringInput("Subject: ");
                        String email=getStringInput("Email: ");
                        teacherService.createTeacher(u,p,tn,sub,email);
                        System.out.println("Teacher Added");
                        break;
                    case 7:
                        int tid = getIntInput("Enter Teacher ID: ");

                        Teacher t = teacherService.getTeacherById(tid);

                        if(t == null){
                            System.out.println("Teacher not found");
                            break;
                        }

                        String tname = getStringInput("New Name: ");
                        String tsub = getStringInput("New Subject: ");
                        String temail = getStringInput("New Email: ");

                        teacherService.updateTeacher(tid, t.getUser_id(), tname, tsub, temail);

                        System.out.println("Teacher Updated");
                        break;

                    case 8:
                        int tid2 = getIntInput("Enter Teacher ID: ");
                        teacherService.deleteTeacher(tid2);
                        System.out.println("Teacher Deleted");
                        break;
                    case 9:
                        teacherService.getAllTeachers().forEach(System.out::println);
                        break;

                    case 10:
                        int tid3 = getIntInput("Enter Teacher ID: ");
                        System.out.println(teacherService.getTeacherById(tid3));
                        break;


                    // ================= PARENT =================

                    case 11:
                        String pu = getStringInput("Username: ");
                        String pp = getStringInput("Password: ");
                        String pname = getStringInput("Name: ");
                        String phone = getStringInput("Phone: ");
                        int stid = getIntInput("Enter Student ID: ");

                        parentService.createParent(pu,pp,pname,phone,stid);
                        System.out.println("Parent Added");
                        break;

                    case 12:
                        int pid = getIntInput("Enter Parent ID: ");

                        Parent parent = parentService.getParentById(pid);

                        if(parent == null){
                            System.out.println("Parent not found");
                            break;
                        }

                        String newPName = getStringInput("New Name: ");
                        String newPhone = getStringInput("New Phone: ");
                        int newSid = getIntInput("Enter Student ID: ");

                        parentService.updateParent(pid, parent.getUser_id(), newPName, newPhone, newSid);

                        System.out.println("Parent Updated");
                        break;

                    case 13:
                        int pid2 = getIntInput("Enter Parent ID: ");
                        parentService.deleteParent(pid2);
                        System.out.println("Parent Deleted");
                        break;

                    case 14:
                        int pid3 = getIntInput("Enter Parent ID: ");
                        System.out.println(parentService.getParentById(pid3));
                        break;

                    case 15:
                        parentService.getAllParents().forEach(System.out::println);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public void teacherMenu() {
        while (true) {
            printHeader("TEACHER MENU");

            System.out.println("1. Add Marks");
            System.out.println("2. Update Marks");
            System.out.println("3. Delete Marks");
            System.out.println("4. View Marks by Student");
            System.out.println("5. View all Marks");
            System.out.println("6. Exit");

            int choice = getIntInput("Enter Choice: ");

            try{
                switch(choice){
                    case 1:
                        int student_id=getIntInput("Enter Student Id: ");
                        String subject=getStringInput("Enter Subject: ");
                        int marks=getIntInput("Enter marks: ");

                        marksService.addMarks(student_id,subject,marks);
                        System.out.println("Marks Added");
                        break;

                    case 2:
                        int id= getIntInput("Enter Marks Id: ");
                        student_id=getIntInput("Enter Student Id: ");
                        subject=getStringInput("Enter Subject: ");
                        marks=getIntInput("Enter marks: ");

                        marksService.updateMarks(id,student_id,subject,marks);
                        System.out.println("Marks Updated");
                        break;

                    case 3:
                        id= getIntInput("Enter Marks id: ");

                        marksService.deleteMarks(id);
                        System.out.println("Marks deleted");
                        break;

                    case 4:
                        student_id=getIntInput("Enter Student Id: ");

                        marksService.getMarksByStudentId(student_id).forEach(System.out::println);
                        break;

                    case 5:
                        marksService.getAllMarks().forEach(System.out::println);
                        break;


                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid Choice!!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public void studentMenu(int userid) {
        while (true) {
            printHeader("STUDENT MENU");
            System.out.println("1. View My Details");
            System.out.println("2. View My Marks");
            System.out.println("3. Exit");
            int choice = getIntInput("Enter Choice: ");
            try{
                Student s = studentService.getStudentByUserId(userid);
                if(s==null){
                    System.out.println("Student not found!!!");
                    return;
                }
                switch (choice){
                    case 1:
                        System.out.println(s);
                        break;
                    case 2:
                        marksService.getMarksByStudentId(s.getId()).forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Exiting....");
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage() );
            }
        }
    }
    public void parentMenu(int sid) {
        while (true) {
            printHeader("PARENT MENU");
            System.out.println("1. View Child Details");
            System.out.println("2. View Child Marks");
            System.out.println("3. Exit");
            int choice = getIntInput("Enter Choice: ");
            try {
                switch (choice){
                    case 1:
                        Student s=studentService.getStudentById(sid);
                        if(s==null){
                            System.out.println("Student not found");
                        }else {
                            System.out.println(s);
                        }
                        break;
                    case 2:
                        marksService.getMarksByStudentId(sid).forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }catch (Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}

