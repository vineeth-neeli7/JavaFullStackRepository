package vineeth.project.socialmedia.service;

import java.util.List;


import org.springframework.stereotype.Service;

import vineeth.project.socialmedia.models.User;

@Service
public interface UserService {
	
	public User registerUser(User user);
	
	public User findUserById(Integer userId) throws Exception;
	
	public User findUserByEmail(String email);
	
	public User followUser(Integer userId1, Integer userId2) throws Exception;
	
	public User updateUser(User user,Integer userId) throws Exception;
	
	public List<User> serachUser(String query);
 
}
