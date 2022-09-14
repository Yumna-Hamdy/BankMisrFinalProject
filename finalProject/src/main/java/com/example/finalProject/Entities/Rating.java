package com.example.finalProject.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "filmRatingKey")
//class Rating {
//
//    @EmbeddedId
//    Rating id;
//
//    @ManyToOne
//    @MapsId("user_id")
//    @JoinColumn(name = "user_id")
//    User user;b
//
//    @ManyToOne
//    @MapsId("id")
//    @JoinColumn(name = "movie_id")
//    Movie movie;
//
//     private int rating;
//    
//    // standard constructors, getters, and setters
//}


@Embeddable
class MovieUserRatingId implements Serializable {

    //@Column(name = "user_id")
	int mId;
	int uId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
