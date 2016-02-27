package com.atrium.formbeans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = DatePopupBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class DatePopupBean implements Serializable {
	public static final String BEAN_NAME = "datePopup";

	public String getBeanName() {
		return BEAN_NAME;
	}

	private Date selectedDate = new Date(System.currentTimeMillis());
	private boolean popup = true;
	private boolean icon = true;

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public boolean getPopup() {
		return popup;
	}

	public boolean getIcon() {
		return icon;
	}

	public void setPopup(boolean popup) {
		this.popup = popup;
	}

	public void setIcon(boolean icon) {
		this.icon = icon;
	}
}
