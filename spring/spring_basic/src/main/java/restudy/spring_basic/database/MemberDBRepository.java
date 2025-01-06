package restudy.spring_basic.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restudy.spring_basic.database.object.Member_DB;

@Repository
public interface MemberDBRepository extends JpaRepository<Member_DB, String> {

}
