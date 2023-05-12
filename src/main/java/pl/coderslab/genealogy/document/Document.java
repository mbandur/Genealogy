package pl.coderslab.genealogy.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.coderslab.genealogy.person.Person;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Person person1;
    @Column(nullable = false)
    private DocumentType documentType;
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