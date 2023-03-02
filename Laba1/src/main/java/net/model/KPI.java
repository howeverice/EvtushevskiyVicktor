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
@Table(name = "kpi")
@Getter
@Setter
@ToString

public class KPI
{
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "result")
    private Double result;

    @Column(name = "functioning")
    private Double functioning;

    @Column(name = "performance")
    private Double performance;

    @Column(name = "costs")
    private Double costs;

    @Column(name = "efficiency")
    private Double efficiency;

    @Column(name = "month")
    private String month;

}
