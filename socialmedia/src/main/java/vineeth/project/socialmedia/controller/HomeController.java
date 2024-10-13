package vineeth.project.socialmedia.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vineeth.project.socialmedia.models.User;
import vineeth.project.socialmedia.repository.UserRepository;
import vineeth.project.socialmedia.service.UserService;

@RestController
public class HomeController {
	
   @Autowired
   UserService userService;
   
   @Autowired
   UserRepository userRepository;
   
   @PostMapping("/users")
   public User createUser(@RequestBody User user) {
	   
	   User savedUser = userService.registerUser(user);
	   return savedUser;
	   
   }
   
   @GetMapping("/users")
   public List<User> getUsers(){
	   List<User> users = userRepository.findAll();
	   return users;
   }
   
   @GetMapping("/users/{userId}")
   public User getUserById(@PathVariable("userId") Integer Id) throws Exception{
	    User user = userService.findUserById(Id);
		return user;
   }
   
  /* @GetMapping("/findUserByEmail/{email}")
   public User findUserByEmail(@PathVariable("Email") String email) throws Exception{
	    User user = userService.findUserByEmail(email);
		return user;
   } */
   
   @PutMapping("/users/{userId}")
   public User updatedUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {
          
	   User updatedUser = userService.updateUser(user, userId);
       return updatedUser;
   }
   
   @PutMapping("/users/follow/{userId1}/{userId2}")
   public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
	   
	   User user = userService.followUser(userId1, userId2);
	   return user;
	   
   }
   
   @PutMapping("users/search")
   public List<User> searchUser(@RequestParam String query){
	   
	   List<User> user = userService.serachUser(query);
	   return user;
	   
   }

}
