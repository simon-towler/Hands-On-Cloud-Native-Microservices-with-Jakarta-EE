package com.packtpub.springboot.footballplayermicroservices.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * Domain model class that maps the data stored into football_player table inside database.
 *
 * @author Mauro Vocale
 * @version 1.0.0 29/09/2018
 */
@Entity
@Table(name="football_player")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name="FootballPlayer.findAll", query="SELECT f FROM FootballPlayer f")
})
public class FootballPlayer implements Serializable {
    private static final long serialVersionUID = -92346781936044228L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "surname")
    private String surname;

    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "team")
    private String team;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "position")
    private String position;

    @Column(name = "price")
    private BigInteger price;

    // Entity must have a default constructor
    public FootballPlayer() {
        // deliberately empty
    }

    public FootballPlayer(String name, String surname, int age, String team, String position, BigInteger price) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.team = team;
        this.position = position;
        this.price = price;
    }

    // attributes must have getters so that Spring REST can render them via the service
    // attributes must also have setters, so new Players submitted via API can actually be set before trying to persist them

    public Integer getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name; }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) { this.surname = surname; }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) { this.age = age; }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) { this.team = team; }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) { this.position = position; }

    public BigInteger getPrice() {
        return price;
    }
    public void setPrice(BigInteger price) { this.price = price; }
}
