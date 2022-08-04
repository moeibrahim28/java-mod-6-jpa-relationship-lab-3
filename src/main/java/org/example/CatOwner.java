package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CAT_OWNERS_DATA")
@Getter
@Setter
public class CatOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    List<Owner> ownerList = new ArrayList<>();
    @ManyToMany
    List<Cat> catList = new ArrayList<>();
}
