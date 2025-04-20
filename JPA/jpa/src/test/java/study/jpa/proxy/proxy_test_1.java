package study.jpa.proxy;

import jakarta.persistence.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.jpa.Entity.Member;
import study.jpa.Entity.Team;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

@SpringBootTest
public class proxy_test_1 {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void changeUserNameAndFindTest(){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Member member = new Member();
            member.setUserName("hello");

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            System.out.println("findMember = " + findMember);
            System.out.println("findMember.usernamew = " + findMember.getUserName());

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
    }

    @Test
    public void getRelativeObject(){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Member member = em.find(Member.class, 1L);
            printMemberAndTeam(member);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();

        }
    }

    private static void printMemberAndTeam(Member member) {
        String userName = member.getUserName();
        System.out.println("userName = " + userName);

        Team team = member.getTeam();
        System.out.println("team = " + team);
    }


}
