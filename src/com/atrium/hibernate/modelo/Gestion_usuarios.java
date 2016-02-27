package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarioavion;
import com.atrium.hibernate.UsuarioavionId;
import com.atrium.hibernate.DAO.UsuarioavionDAO;

public class Gestion_usuarios implements IGestion_usuarios {
	private UsuarioavionDAO usuarioavionDAO;

	public void setUsuarioaviondao(UsuarioavionDAO usuarioaviondao) {
		this.usuarioavionDAO = usuarioaviondao;
	}
	
	/* (non-Javadoc)
	 * @see com.atrium.hibernate.modelo.IGestion_usuarios#altaUsuario(com.atrium.hibernate.Usuarioavion)
	 */
	@Override
	public void altaUsuario(Usuarioavion usuario) {
		usuarioavionDAO.save(usuario);
	}
	
	@Override
	public Usuarioavion getUser(String login, String password) {
		UsuarioavionId userid=new UsuarioavionId(login,password);
		return usuarioavionDAO.findById(userid);
	}

}
