package hellojpa;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name="MBR")
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MY_SEQUENCES",
//        initialValue = 1 , allocationSize = 50)
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩을 셋팅하면 연관관계를 proxy로 조회
    @JoinColumn
    private Team team;

// 프록시 초기화 사용할때 사용
//    @Column(name = "TEAM")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

//    public Locker getLocker() {
//        return locker;
//    }
//
//    public void setLocker(Locker locker) {
//        this.locker = locker;
//    }
//
//    public List<MemberProduct> getMemberProducts() {
//        return memberProducts;
//    }
//
//    public void setMemberProducts(List<MemberProduct> memberProducts) {
//        this.memberProducts = memberProducts;
//    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }

    /**
     * 기본 매핑 테스트
     */
//    @Id
//    @GeneratedValue (strategy = GenerationType.SEQUENCE,
//    generator = "MEMBER_SEQ_GENERATOR")
////    @GeneratedValue(strategy = GenerationType.TABLE,
////            generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;
//    @Column(name = "name", nullable = false)
//    private String username;
//
//    public Member() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    //    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }



    /**
     * 여러가지 내용을 추가한 테스트 (생성자,getter,setter)
     */

    //    @Id
    //    private Long id;
    //    @Column(name = "name")
    //    private String username;
    //    private Integer age;
    //    @Enumerated(EnumType.STRING)
    //    private RoleType roleType;
    //    @Temporal(TemporalType.TIMESTAMP)
    //    private Date createdDate;
    //    @Temporal(TemporalType.TIMESTAMP)
    //    private Date lastModifiedDate;
    //
    //    private LocalDate testLocalDate;
    //    private LocalDateTime testLocalDateTime;
    //    @Lob
    //    private String description;
    //
    //
    //    public Member() {
    //    }
    //
    //    public Long getId() {
    //        return id;
    //    }
    //
    //    public void setId(Long id) {
    //        this.id = id;
    //    }
    //
    //    public String getUsername() {
    //        return username;
    //    }
    //
    //    public void setUsername(String username) {
    //        this.username = username;
    //    }
    //
    //    public Integer getAge() {
    //        return age;
    //    }
    //
    //    public void setAge(Integer age) {
    //        this.age = age;
    //    }
    //
    //    public RoleType getRoleType() {
    //        return roleType;
    //    }
    //
    //    public void setRoleType(RoleType roleType) {
    //        this.roleType = roleType;
    //    }
    //
    //    public Date getCreatedDate() {
    //        return createdDate;
    //    }
    //
    //    public void setCreatedDate(Date createdDate) {
    //        this.createdDate = createdDate;
    //    }
    //
    //    public Date getLastModifiedDate() {
    //        return lastModifiedDate;
    //    }
    //
    //    public void setLastModifiedDate(Date lastModifiedDate) {
    //        this.lastModifiedDate = lastModifiedDate;
    //    }
    //
    //    public String getDescription() {
    //        return description;
    //    }
    //
    //    public void setDescription(String description) {
    //        this.description = description;
    //    }
    //    public Member(Long id, String name) {
    //        this.id = id;
    //        this.name = name;
    //    }
    //    public Member(Long id) {
    //        this.id = id;
    //    }
    //
    //    public Long getId() {
    //        return id;
    //    }
    //
    //    public void setId(Long id) {
    //        this.id = id;
    //    }
    //
    //    public String getName() {
    //        return name;
    //    }
    //
    //    public void setName(String name) {
    //        this.name = name;
    //    }
}
