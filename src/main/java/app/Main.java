package app;
import service.*;
import repository.*;
import model.*;
import java.util.*;
import util.InputUtil;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        UserRepository userRepo=new UserRepository();
        StudentRepository studentRepo=new StudentRepository();
        TeacherRepository teacherRepo=new TeacherRepository();
        ParentRepository parentRepo=new ParentRepository();
        MarksRepository marksRepo=new MarksRepository();


        UserService userService=new UserService(userRepo);
        StudentService studentService=new StudentService(studentRepo,userRepo);
        TeacherService teacherService=new TeacherService(teacherRepo,userRepo);
        ParentService parentService=new ParentService(parentRepo,userRepo);
        MarksService marksService=new MarksService(marksRepo);
        Menu menu=new Menu(studentService,teacherService,parentService,marksService);

        int attempts =3;
        User user=null;
        while (attempts > 0){
            try {
                System.out.println("\n==================== LOGIN ====================");
                System.out.print("Enter Username: ");
                String username= sc.nextLine();
                String password=InputUtil.getPasswordInput("Enter Password: ");
                user=userService.login(username,password);
                if(user!=null){
                    System.out.println("Login Successful!!! Role: "+user.getRole());
                    break;
                }else {
                    attempts--;
                    System.out.println("Invalid credentials!!! Attempts left: "+ attempts);
                }
            }catch (Exception e){
                System.out.println("Error: "+e.getMessage());

            }
        }
        if(user==null){
            System.out.println("Too Many Failed attempts. Exiting.....");
            return;
        }
        Role role=user.getRole();
        switch (role){
            case ADMIN :
                menu.adminMenu();
                break;
            case TEACHER:
                menu.teacherMenu();
                break;
            case STUDENT:
                menu.studentMenu(user.getId());
                break;
            case PARENT:
                try {
                    Parent parent = parentService.getParentByUserId(user.getId());
                    if(parent!=null){
                        menu.parentMenu(parent.getStudent_id());
                    }else{
                        System.out.println("Parent not linked to any student");
                    }
                }catch (Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            default:
                System.out.println("Unknown Role!!!");
        }
    }
}
