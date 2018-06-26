package net.dontdrinkandroot.example.ddrstack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ExampleEntity implements net.dontdrinkandroot.extensions.springdatajpa.model.Entity<Long>
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String stringField;

    @Column(nullable = true)
    private Integer integerField;

    @Column(nullable = true)
    private LocalDate dateField;

    public Long getId()
    {
        return this.id;
    }

    public String getStringField()
    {
        return this.stringField;
    }

    public void setStringField(String stringField)
    {
        this.stringField = stringField;
    }

    public Integer getIntegerField()
    {
        return this.integerField;
    }

    public void setIntegerField(Integer integerField)
    {
        this.integerField = integerField;
    }

    public LocalDate getDateField()
    {
        return this.dateField;
    }

    public void setDateField(LocalDate dateField)
    {
        this.dateField = dateField;
    }
}
