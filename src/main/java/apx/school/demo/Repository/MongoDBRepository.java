package apx.school.demo.Repository;

import apx.school.demo.Entity.AuthEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import apx.school.demo.Model.User;


public interface MongoDBRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
