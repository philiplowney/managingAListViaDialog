package com.philsPatterns.editableList;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class IndexUI implements Serializable
{
	private static final long serialVersionUID = 1013636459182580709L;
	@Getter @Setter
	private List<InviteModel> invites;
	@Getter
	private InviteModel selectedInvite;
	@Getter @Setter
	private PageState pageState;
	
	@Inject
	private InviteDAO inviteDAO;
	
	@PostConstruct
	public void init()
	{
		invites = inviteDAO.findAll();
		selectedInvite = null;
		pageState = PageState.VIEW;
	}
	
	public void clickAdd()
	{
		selectedInvite = new InviteModel();
		pageState = PageState.ADD;
	}
	
	public void selectInvite(InviteModel selectedInvite)
	{
		this.selectedInvite = selectedInvite;
	}
	
	public void clickSave()
	{
		if(pageState==PageState.ADD)
		{
			inviteDAO.save(selectedInvite);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Invite Added", selectedInvite.getFirstName()+" "+selectedInvite.getSurname()));
		}
		else if(pageState == PageState.EDIT)
		{
			inviteDAO.update(selectedInvite);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Invite Updated", selectedInvite.getFirstName()+" "+selectedInvite.getSurname()));
		}
		invites = inviteDAO.findAll();
		pageState = PageState.VIEW;
	}
	
	public void clickEdit()
	{
		pageState = PageState.EDIT;
	}
	
	public void clickCancel()
	{
		pageState = PageState.VIEW;
	}
	
	public enum PageState
	{
		VIEW,
		ADD,
		EDIT;
	}
}
