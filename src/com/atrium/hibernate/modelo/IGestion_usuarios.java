package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarioavion;

public interface IGestion_usuarios {

	public abstract void altaUsuario(Usuarioavion usuario);

	public abstract Usuarioavion getUser(String login, String password);

}