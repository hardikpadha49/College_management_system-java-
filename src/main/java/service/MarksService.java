package service;
import util.ValidationUtil;
import model.Marks;
import repository.MarksRepository;
import java.util.List;
public class MarksService {
    private MarksRepository marksRepository;
    public MarksService(MarksRepository marksRepository){
        this.marksRepository=marksRepository;
    }
    public boolean addMarks(int studentId,String subject,int marks) throws Exception{
        ValidationUtil.validateNotEmpty("Subject",subject);
        ValidationUtil.validateMarks(marks);
        Marks mark=new Marks(studentId,subject,marks);
        return marksRepository.addMarks(mark);
    }
    public boolean updateMarks(int id,int studentId,String subject,int marks)throws Exception{
        if(id<=0)throw new IllegalArgumentException("Invalid Marks Id");
        if(studentId<=0)throw new IllegalArgumentException("Invalid Student Id");
        ValidationUtil.validateNotEmpty("Subject",subject);
        ValidationUtil.validateMarks(marks);
        Marks mark=new Marks(id,studentId,subject,marks);
        return marksRepository.updateMarks(mark);
    }
    public boolean deleteMarks(int id)throws Exception{
        if(id<=0){
            throw new IllegalArgumentException("Invalid Marks ID");
        }
        return marksRepository.deleteMarks(id);
    }
    public List<Marks> getMarksByStudentId(int studentId)throws Exception{
        if(studentId<=0){
            throw new IllegalArgumentException("Invalid Student ID");
        }
        return marksRepository.getMarksByStudentId(studentId);
    }
    public List<Marks> getAllMarks()throws Exception{
        return marksRepository.getAllMarks();
    }
}
