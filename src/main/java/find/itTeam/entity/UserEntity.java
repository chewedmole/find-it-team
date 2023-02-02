package find.itTeam.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.List;

/**
 * Entity ��� ������������
 */
@Entity
@Table(schema = "finditteam", name = "user")
@Data
@Accessors(chain = true)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<PostEntity> posts;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<CommentEntity> comments;
    
    @OneToOne(mappedBy = "user")
    private RatingEntity rating;
}