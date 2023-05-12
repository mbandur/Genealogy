package pl.coderslab.genealogy.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.coderslab.genealogy.document.Document;
import pl.coderslab.genealogy.event.Event;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10, name = "first_nane")
    private String firstName;
    @Column(nullable = true, length = 10, name = "second_nane")
    private String secondName;
    @Column(nullable = false, length = 20, name = "last_nane")
    private String lastName;
    @Column(nullable = true, length = 20, name = "maiden_nane")
    private String maidenName;
    @Column(name = "sex", nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @OneToMany(mappedBy = "person1")
    @JsonIgnore
    private List<Document> documentList = new ArrayList<>();
    @OneToMany(mappedBy = "person1")
    @JsonIgnore
    private List<Event> eventList = new ArrayList<>();
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