package service;
import model.User;
import repository.UserRepository;
import util.ValidationUtil;
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User login(String username,String password)throws Exception{
        ValidationUtil.validateNotEmpty("Username",username);
        ValidationUtil.validateNotEmpty("Password",password);
        return userRepository.login(username,password);
    }
}
