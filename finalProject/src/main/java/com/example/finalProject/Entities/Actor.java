package com.example.finalProject.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actor{
    @Id
    @GeneratedValue
    public int actorId;
    public String actorName;
    // add image absolute path
    public String imagePath;
    
//    @OneToMany(mappedBy = "actor")
//    List<ActorMovies> actorMovies;
    
}