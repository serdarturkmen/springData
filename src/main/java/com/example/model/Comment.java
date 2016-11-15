package com.example.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Comment extends BaseModel{
	
	private String text;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ticket")
	private Ticket ticket;
	
//	@OneToOne(mappedBy="User")
//	private User user;
	
}
