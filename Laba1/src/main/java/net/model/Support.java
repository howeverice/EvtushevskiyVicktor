package net.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "support")
@Getter
@Setter
@ToString
public class Support {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "problem")
    private String problem;

}
