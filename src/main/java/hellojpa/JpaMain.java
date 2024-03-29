package hellojpa;


import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /**
             * 값 타입 컬렉션 사용
             */
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10001"));

            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("치킨");

            member.getAddressesHistory().add(new AddressEntity("old1", "street", "10002"));
            member.getAddressesHistory().add(new AddressEntity("old2", "street", "10002"));

//            member.getAddressesHistory().add(new Address("old1", "street", "10002"));
//            member.getAddressesHistory().add(new Address("old2", "street", "10002"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================START=================");
            Member findMember = em.find(Member.class, member.getId());

//            // homeCity -> newCity;
//            Address a  =  findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");


//            // 여기에서 equals 오버라이딩 제대로 안되어있으면 작동x
//            findMember.getAddressesHistory().remove(new Address("old1", "street", "10002"));
//            findMember.getAddressesHistory().add(new Address("newCity", "street", "10002"));


            // 값타입 컬렉션확인 및 값타입 컬렉션도 지연 로딩 전략 사용
//            System.out.println("================START=================");
//            Member findMember = em.find(Member.class, member.getId());
//
//            List<Address> addressesHistory = findMember.getAddressesHistory();
//            for(Address address : addressesHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood :  favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            /**
             * 값 타입 비교
             */

//            int a = 10;
//            int b = 10;
//
//            System.out.println("a == b : " + (a == b));
//
//            Address address1 = new Address("city", "street", "10000");
//            Address address2 = new Address("city", "street", "10000");
//
//            System.out.println("address1 == address2 : " + (address1 == address2));
//            /**
//             * 이렇게 equals로 같은지를 비교하고싶으면 Address에서 equalsd와 hashcode 오버라이딩해서 써야지만 true값을 얻을 수 있음
//             */
//            System.out.println("address1 equals address2 = " + (address1.equals(address2))); // 이렇게 단순 equals 비교를하면 equals 기본은 == 비교라 false가 출력

            /**
             * 불변객체 new city가 두번저장되는것을 copyAdress를 만들어 한번만 저장되도록 변경
             */


//                Address address = new Address("city", "street", "10000");
//
//
//                Member member = new Member();
//                member.setUsername("member1");
//                member.setHomeAddress(address);
//                em.persist(member);
//
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//                member.setUsername("member2");
//                member.setHomeAddress(copyAddress);
//                em.persist(member2);
//
//                //
//                member.getHomeAddress().setCity("newCity");
//

            /**
             * embedded 타입으로 주소, 시간등 분리해서 테스트
             */
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setHomeAddress(new Address("city", "street", "10000"));
//            member.setWorkPeriod(new Period());
//
//            em.persist(member);
            /**
             * 영속성 전이 CASCADE
             * cascade는 연쇄라고 생각하면된다. 부모로 persist 하면 연관된 애도 같이 저장해준다.
             */

//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            /**
             * 지연로딩 사용해서 프록시 조회
             */
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();

//            Member m = em.getReference(Member.class, member1.getId()); // m = class hellojpa.Team$HibernateProxy$sHjkg3f

//            System.out.println("m = " + m.getTeam().getClass());
//
//            // 지연로딩 프록시 조회를 확인할수있음
//            System.out.println("================================");
//            m.getTeam().getName(); // 초기화
//            System.out.println("================================");

//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();

            // SQL : select * from Member
            // SQL : select * from Team where TEAM_ID = xxx

            /**
             * 프록시 초기화
             */
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); //Proxy
//            Hibernate.initialize(refMember); //강제 초기화
//            refMember.getUsername();
//            System.out.println(" isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));




            /**
             * 프록시 비교
             */

            //            Member member1 = new Member();
            //                member1.setUsername("member1");
            //                em.persist(member1);
            //
            //                em.flush();
            //                em.clear();
            //
            //                Member m1 = em.find(Member.class, member1.getId());
            //                System.out.println("m1.getClass() = " + m1.getClass());
            //
            //                Member reference =  em.getReference(Member.class, member1.getId());
            //                System.out.println("reference.getClass() = " + reference.getClass()); //Proxy
            //
            //                System.out.println("(m1 == reference) = " + (m1 == reference)); //true

//                Member member2 = new Member();
//                member1.setUsername("member2");
//                em.persist(member2);
//
//                em.flush();
//                em.clear();
//
//
//                Member m1= em.find(Member.class, member1.getId());
//                Member m2= em.find(Member.class, member2.getId());
//    
//                System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));


//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());


            /**
             * 팀만 조회할시 문제점(낭비) => JPA 는 지연로딩과, 프록시로 해결
             *
             */

            //            Member member = em.find(Member.class, 1L);
            ////            printMemberAndTeam(member);
            //
            //            printMember(member);

            //            Member member = new Member();
            //            member.setUsername("user1");
            //            member.setCreatedBy("kim");
            //            member.setCreatedDate(LocalDate.from(LocalDateTime.now()));
            //
            //            em.persist(member);
            //
            //            em.flush();
            //            em.clear();



            /**
             * 팀 예시 및 다양한 조인,단일전략테스트
             */

            //            Movie movie = new Movie();
            //            movie.setDirector("aaaa");
            //            movie.setActor("bbbb");
            //            movie.setName("바람과함께사라지다");
            //            movie.setPrice(10000);
            //
            //            em.persist(movie);
            //
            //            em.flush();
            //            em.clear();
            //
            //            Movie findmovie = em.find(Movie.class, movie.getId());
            //            System.out.println("findmovie = " + findmovie);

            /**
             * 팀 예시 및 다양한 조인,단일전략테스트
             */

            //            Team team = new Team();
            //            team.setName("TeamA");
            //            em.persist(team);
            //
            //            Member member = new Member();
            //            member.setUsername("member1");
            //            member.ChangeTeam(team);
            //            em.persist(member);
            //
            //
            //            em.flush();
            //            em.clear();
            //
            //            Team findTeam = em.find(Team.class, team.getId()); // 1차캐시
            //            List<Member> members = findTeam.getMembers();
            //
            //            System.out.println("======================");
            //            for (Member m : members) {
            //                System.out.println("m.getUsername() = " + m.getUsername());
            //            }
            
            
            /**
             * 양방향 매핑시 주의할점
             */
            //            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member); //team_id에 null값이 들어가는것을확인
////            양방향 매핑시 가장 많이하는 실수로 연관관계 주인에 값을 입력하지 않으므로 발생하는 null
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//
//            em.flush();
//            em.clear();


            /**
             * 양방향연관관계 기본테스트
             */
            //            //저장
            //            Team team = new Team();
            //            team.setName("TeamA");
            //            em.persist(team);
            //
            //            Member member = new Member();
            //            member.setUsername("member1");
            //            member.setTeam(team);
            //            em.persist(member);
            //
            //            em.flush();
            //            em.clear();
            //
            //            Member findMember = em.find(Member.class, member.getId());
            //            List<Member> members = findMember.getTeam().getMembers();
            //
            //            for (Member m : members) {
            //                System.out.println("m.getUsername() = " + m.getUsername());
            //            }


            //            Team findTeam = findMember.getTeam();
            //            System.out.println("findTeam.getName() = " + findTeam.getName());
            //


            /**
             * initialValue, allocationSize 값 정하고 차례대로 sequence붙는거 확인
             */
            //            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("===============================");
//
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
//
//            System.out.println("member1 = " + member1);
//            System.out.println("member2 = " + member2);
//            System.out.println("member3 = " + member3);
//
//
//            System.out.println("===============================");



            /**
             * generationType 테스트진행하였으나 h2버전 오류
             */
            //            Member member = new Member();
            ////            member.setId(3L);
            //            member.setUsername("C");
            ////            member.setRoleType(RoleType.GUEST);
            //            System.out.println("=====================");
            //            em.persist(member);
            //            System.out.println("member.id = " + member.getId());
            //            System.out.println("=====================");

            /**
             * 준영속
             */
            //            Member member =  em.find(Member.class, 105L);
//            member.setName("AAAAA");
//
//            em.detach(member); // 특정 엔티티만 준영속 상태로 전환
////            em.clear(); // 영속성 컨텍스트를 완전히 초기화
////            em.close(); // 영속성 컨텍스트를 종료
//
//            System.out.println("==========================");

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

    /**
     * 팀만 조회할시 문제점(낭비) => JPA 는 지연로딩과, 프록시로 해결
     *
     */
    //    private static void printMember(Member member) {
    //        System.out.println("member = " + member.getUsername());
    //    }
    //
    //    private static void printMemberAndTeam(Member member) {
    //
    //        String username = member.getUsername();
    //        System.out.println("username = " + username);
    //
    //        Team team = member.getTeam();
    //        System.out.println("team = " + team.getName());
    //    }
}


// 오류해결 1 - pom.xml과 persistence.xml 변경후 maven 리프레쉬
// 2 - e.printStackTrace(); // 오류구문 자세한 확인
// findMemberr가 null값이였는데 이유가 자동으로 테이블이 드랍되고 재생성되어서 persistence.xml파일에서
// <!--<property name="hibernate.hbm2ddl.auto" value="create" />--> 이거 주석처리해서 해결함