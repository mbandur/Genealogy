package pl.coderslab.genealogy.relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.genealogy.person.Person;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Person person1;
    @ManyToOne
    private Person person2;
    @Enumerated(EnumType.STRING)
    @Column(name = "relation_type_1", nullable = false)
    private RelationType relationType1;
    @Enumerated(EnumType.STRING)
    @Column(name = "relation_type_2", nullable = false)
    private RelationType relationType2;
    private String comments;
    @Column(name = "created_on", updatable = false)
    @JsonIgnore
    private LocalDateTime createdOn;
    @Column(name = "updated_on", insertable = false)
    @JsonIgnore
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}