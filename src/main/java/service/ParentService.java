package service;
import model.Parent;
import model.Role;
import util.ValidationUtil;
import repository.UserRepository;
import repository.ParentRepository;

import java.util.List;

public class ParentService {
    private ParentRepository parentRepository;
    private UserRepository userRepository;

    public ParentService(ParentRepository parentRepository, UserRepository userRepository){
        this.parentRepository=parentRepository;
        this.userRepository=userRepository;
    }
    public boolean createParent(String username,String password, String name, String phoneNo, int studentId) throws  Exception{

        ValidationUtil.validateName(name);
        ValidationUtil.validatePhone(phoneNo);
        ValidationUtil.validateNotEmpty("Username",username);
        ValidationUtil.validateNotEmpty("Password",password);
        int userId=userRepository.createUser(username,password, Role.PARENT);
        if(userId==-1) return false;
        Parent parent = new Parent(userId,name,phoneNo,studentId);
        return parentRepository.addParent(parent);
    }
    public boolean updateParent(int id,int userId, String name, String phoneNo, int studentId) throws Exception{
        ValidationUtil.validateName(name);
        ValidationUtil.validatePhone(phoneNo);

        Parent parent = new Parent(id,userId,name,phoneNo,studentId);
        return parentRepository.updateParent(parent);
    }
    public boolean deleteParent(int parentId) throws Exception{
        if(parentId <=0){
            throw new IllegalArgumentException("Invalid Parent ID");
        }
        Parent parent=parentRepository.getParentById(parentId);
        if(parent==null) return false;
        return parentRepository.deleteParent(parent.getUser_id());
    }
    public Parent getParentById(int parentId) throws Exception{
        if(parentId<=0){
            throw new IllegalArgumentException("Invalid Parent ID");
        }
        return parentRepository.getParentById(parentId);
    }
    public List<Parent> getAllParents() throws Exception{
        return parentRepository.getAllParents();
    }
    public Parent getParentByUserId(int userId) throws Exception{
        for(Parent p:parentRepository.getAllParents()){
            if(p.getUser_id()==userId){
                return p;
            }
        }
        return null;
    }
}
