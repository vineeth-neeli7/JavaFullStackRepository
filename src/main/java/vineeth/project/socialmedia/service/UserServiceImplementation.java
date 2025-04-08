package vineeth.project.socialmedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vineeth.project.socialmedia.models.User;
import vineeth.project.socialmedia.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User findUserById(Integer userId) throws Exception{
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new Exception("User is not present with Id"+ userId);
	}
 
	@Override
	public User findUserByEmail(String email) {
	    
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer userId1, Integer userId2) throws Exception {
		
		User user1 =findUserById(userId1);
		User user2 =findUserById(userId2);
		
		user1.getFollowing().add(user2.getId());
		user2.getFollowers().add(user1.getId());
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		return user1;
	}

	@Override
	public User updateUser(User user, Integer userId) throws Exception {
		Optional<User> user1 = userRepository.findById(userId);
		
		if(user1.isEmpty()) {
		throw new Exception("user not exist with id" + userId);	
		}
		
		  User oldUser = user1.get();
		  
		  if(user.getFirstName()!=null) {
			  oldUser.setFirstName(user.getFirstName());
		  }
		  
		  if(user.getLastName()!=null) {
			  oldUser.setLastName(user.getLastName());
		  }
		  
		  if(user.getEmail()!=null) {
			  oldUser.setEmail(user.getEmail());
		  }
		  
		  if(user.getGender()!=null) {
			  oldUser.setGender(user.getGender());
		  }
		  
		  if(user.getPassword()!=null) {
			  oldUser.setPassword(user.getPassword());
		  }
		  
		  User updatedUser = userRepository.save(oldUser);
			
		return updatedUser;
	}

	@Override
	public List<User> serachUser(String query) {
      
		List<User> searchedUser = userRepository.searchUser(query);

		return searchedUser;
	}

}
