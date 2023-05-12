package pl.coderslab.genealogy.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.coderslab.genealogy.person.Person;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate eventDate;
    @ManyToOne
    private Person person1;
    @Column(nullable = false)
    private EventType eventType;
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
