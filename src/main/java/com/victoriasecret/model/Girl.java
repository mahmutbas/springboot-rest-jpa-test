package com.victoriasecret.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by TCMBAS on 06/04/2017.
 */
@Data
@Entity
@Table(name = "T_GIRLS")
public class Girl
{
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    private String surname;
    private Integer age;
    private Long weigth;
    private Long heigth;

    public Girl(String name)
    {
        Assert.hasLength(name, "Username must not be empty");
        Assert.notNull(name, "VIN must not be null");
        this.name = name;
    }

    public Girl()
    {
    }
}
