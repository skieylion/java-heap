package project.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "text")
    public String text;
}
