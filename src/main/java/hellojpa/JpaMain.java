package hellojpa;


import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) //페이징
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
//            findMember.setName("HelloJPA");

                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }finally {
                em.close();
            }

            emf.close();

    }
}


// 오류해결 1 - pom.xml과 persistence.xml 변경후 maven 리프레쉬
// 2 - e.printStackTrace(); // 오류구문 자세한 확인
// findMemberr가 null값이였는데 이유가 자동으로 테이블이 드랍되고 재생성되어서 persistence.xml파일에서
// <!--<property name="hibernate.hbm2ddl.auto" value="create" />--> 이거 주석처리해서 해결함