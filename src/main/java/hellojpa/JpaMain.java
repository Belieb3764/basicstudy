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
            /**
             * 준영속
             */
            Member member =  em.find(Member.class, 105L);
            member.setName("AAAAA");

            em.detach(member); // 특정 엔티티만 준영속 상태로 전환
//            em.clear(); // 영속성 컨텍스트를 완전히 초기화
//            em.close(); // 영속성 컨텍스트를 종료

            System.out.println("==========================");

            /**
             * flush 플러시
             * 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
             */
            //            // 영속
            //            Member meber = new Member(200L, "member200");
            //            em.persist(meber);
            //
            //            em.flush();
            //            System.out.println("==========================");

            /**
             * 영속 엔티티 조회 및 수정 변경감지(Dirty Checking)
             */
            //영속
//               Member member = em.find(Member.class, 105L);
//               member.setName("ZZZZZ");

//               Member member2 = new Member(105L, "A");
//               Member member2 = new Member(160L, "B");

//               em.persist(member1);
//               em.persist(member2);
//               System.out.println("=========================="); //영속성 컨텍스트에 엔티티가 즉시 저장되고, 트랜잭션 커밋 이전에 출력됩니다.

            /**
             * 영속 엔티티와 동일성 보장
             */
            //            Member findMember1 = em.find(Member.class, 101L);
            //            Member findMember2 = em.find(Member.class, 101L);
            //
            //
            //            System.out.println("result = " + (findMember1 == findMember2));  //result = true


            //           // 비영속
            //            Member member = new Member();
            //            member.setId(101L);
            //            member.setName("HelloJPA");
            //
            //
            //            // 영속
            //            System.out.println("BEFORE");
            //            em.persist(member);
            //            System.out.println("AFTER");
            //
            //            Member findMember = em.find(Member.class, 101L);
            //            System.out.println("findMember = " + findMember.getId());
            //            System.out.println("findMember.getName() = " + findMember.getName());

            //            Member findMember = em.find(Member.class, 1L);
            //            System.out.println("findMember = " + findMember.getId());
            //            System.out.println("findMember.getName() = " + findMember.getName());


            //            List<Member> result = em.createQuery("select m from Member as m", Member.class)
            //                    .setFirstResult(1) //페이징
            //                    .setMaxResults(10)
            //                    .getResultList();
            //
            //            for (Member member : result) {
            //                System.out.println("member.name = " + member.getName());
            //            }
            //            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}


// 오류해결 1 - pom.xml과 persistence.xml 변경후 maven 리프레쉬
// 2 - e.printStackTrace(); // 오류구문 자세한 확인
// findMemberr가 null값이였는데 이유가 자동으로 테이블이 드랍되고 재생성되어서 persistence.xml파일에서
// <!--<property name="hibernate.hbm2ddl.auto" value="create" />--> 이거 주석처리해서 해결함