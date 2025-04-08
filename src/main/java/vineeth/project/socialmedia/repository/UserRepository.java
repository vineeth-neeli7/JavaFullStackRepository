package vineeth.project.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vineeth.project.socialmedia.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
    
	@Query("Select u from User u where u.firstName like %:query% or u.lastName Like %:query% or u.email Like %:query%")
	public List<User> searchUser(@Param("query") String query); /* http://locolhost:3000//queruexample?query="sai" */
  
}
