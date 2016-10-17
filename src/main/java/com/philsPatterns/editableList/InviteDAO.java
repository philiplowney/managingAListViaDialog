package com.philsPatterns.editableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 * Pretend Data Access Object.
 * 
 * This would normally be stateless of course, as a data-access object,
 * but the DB/Rest service/File/SOAP Service/whatever-the-data-source-is
 * is out of scope in this example.
 * 
 * A couple of sleeps are put in to simulate a non-trivial delay
 * 
 * @author Philip
 *
 */
@Stateful
public class InviteDAO
{
	private List<InviteModel> invites;
	@PostConstruct
	public void init()
	{
		invites = new ArrayList<>();
	}
	public List<InviteModel> findAll()
	{
		sleepRandomly();
		return invites;
	}
	private void sleepRandomly()
	{
		long randomSleep = new Random().nextInt(500);
		try
		{
			Thread.sleep(randomSleep);
		}
		catch (InterruptedException e)
		{
			System.out.println("Can't sleep :(");
			e.printStackTrace();
		}
	}
	public InviteModel update(InviteModel toUpdate)
	{
		sleepRandomly();
		return toUpdate;
	}
	public InviteModel save(InviteModel toSave)
	{
		sleepRandomly();
		invites.add(toSave);
		return toSave;
	}
}
