//package com.example.finalProject.Entities;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
////import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Actor{
//    @Id
//    @GeneratedValue
//    public int actorId;
//    public String actorName;
//    // add image absolute path
//    public String actorImagePath;
//    
////    @OneToMany(mappedBy = "actorId")
////    List<ActorMovies> actorMovies;
//    
//}

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
    public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorImagePath() {
		return actorImagePath;
	}
	public void setActorImagePath(String actorImagePath) {
		this.actorImagePath = actorImagePath;
	}
	public String actorName;
    // add image absolute path
    public String actorImagePath;
    
//    @OneToMany(mappedBy = "actorId")
//    List<ActorMovies> actorMovies;
    
}