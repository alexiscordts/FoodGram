package com.FoodGramServer.FoodGramServer.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	// Bidirectional relation with photos. Because it is bidirectional, parsing into json will enter
	// an infinite loop (user->photos->users->...). To resolve this, use @JsonManagedReference and 
	// @JsonBackedReference. Put @JsonManagedReference where you want the entity of the relation to be
	// included in JSON, and @JsonBackedReference where you don't want the entity to be included.
	@OneToMany(mappedBy = "user") // mappedBy required for bidirectional to indicate the other side
//	@JsonBackReference
	@JsonIgnore
	private List<Photo> photoPosts;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "bio")
	private String bio;
	
	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@Column(name = "account_type")
	@NotNull
	private String account_type;
	
	@Column(name = "location_city")
	private String location_city;
	
	@Column(name = "location_state")
	private String location_state;
	
	@Column(name = "phone_no")
	private String phone_no;
	
	@Column(name = "profile_pic")
	private String profile_pic;
		
	
	public long getUserId() { return user_id; }
	
	public void setUserId(long user_id) { this.user_id = user_id; }
	
	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getFullName() { return full_name; }

	public void setFullName(String full_name) { this.full_name = full_name; }
	
	public String getBio() { return bio; }
	
	public void setBio(String bio) { this.bio = bio; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getAccountType() { return account_type; }

	public void setAccountType(String account_type) { this.account_type = account_type; }

	public String getLocationCity() { return location_city; }

	public void setLocationCity(String location_city) { this.location_city = location_city; }

	public String getLocationState() { return location_state; }

	public void setLocationState(String location_state) { this.location_state = location_state; }

	public String getPhoneNo() { return phone_no; }

	public void setPhoneNo(String phone_no) { this.phone_no = phone_no; }

	public String getProfilePic() { return profile_pic; }

	public void setProfilePic(String profile_pic) { this.profile_pic = profile_pic; }

	public List<Photo> getPhotoPosts() {
		return photoPosts;
	}

	public void setPhotoPosts(List<Photo> photoPosts) {
		this.photoPosts = photoPosts;
	}

}
