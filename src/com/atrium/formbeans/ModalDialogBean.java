package com.atrium.formbeans;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = ModalDialogBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class ModalDialogBean implements Serializable {
	public static final String BEAN_NAME = "modalDialogBean";

	public String getBeanName() {
		return BEAN_NAME;
	}

	public ModalDialogBean() {

	}

}
