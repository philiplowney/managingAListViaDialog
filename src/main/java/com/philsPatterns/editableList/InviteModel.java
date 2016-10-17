package com.philsPatterns.editableList;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InviteModel implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String surname;
	private String emailAddress;
	private boolean inviteSent;
}
