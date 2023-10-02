package Alan.Productions.Finance.Manager.Repository;

import Alan.Productions.Finance.Manager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}