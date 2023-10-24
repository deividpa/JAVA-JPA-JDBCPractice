/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import principal.dominio.usuario.Usuario;

/**
 *
 * @author pc
 */
public final class UsuarioDAO extends DAO {
    public void guardarUsuario(Usuario usuario) throws Exception {
        try {
            if(usuario == null) {
                throw new Exception("Debe indicar un usuario");
            }
            
            String query = "INSERT INTO Usuario (correoElectronico, clave)" +
                    "VALUES ('" + usuario.getCorreoElectronico() + "', '" + usuario.getClave() + "' );";
            
            insertarModificarEliminar(query);
        } catch(Exception e) {
            throw e;
        }
    }
    
    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if(usuario == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            
            String query = "UPDATE Usuario SET " + 
                    "clave = '" + usuario.getClave() + "' WHERE correoElectronico = '" + usuario.getCorreoElectronico() + "';";
            
            insertarModificarEliminar(query);
        } catch(Exception ex) {
            throw ex;
        }
    }
    
    public void eliminarUsuario(String correEletronico) throws Exception {
        try {

            String query = "DELETE FROM Usuario WHERE correoElectronico = '" + correEletronico + "'";

            insertarModificarEliminar(query);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public Usuario buscarUsuarioPorCorreoElectronico(String email) throws Exception {
        try {
            String query = "SELECT * FROM Usuario WHERE correoElectronico = '" + email + "'";
            consultarBase(query);
            
            Usuario usuario = null;
            
            while(resultado.next()) {
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
            
        } catch(Exception ex) {
            desconectarBase();
            throw ex;
        }
    }
    
    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {

            String sql = "SELECT * FROM Usuario "
                    + " WHERE id = '" + id + "'";

            consultarBase(sql);

            Usuario usuario = null;
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Usuario> listarUsuarios() throws Exception {
        try {
            String query = "SELECT correoElectronico, clave FROM Usuario";
            consultarBase(query);
            
            Usuario usuario = null;
            Collection<Usuario> usuarios = new ArrayList();
            
            while(resultado.next()) {
                usuario = new Usuario();
                usuario.setCorreoElectronico(resultado.getString(1));
                usuario.setClave(resultado.getString(2));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch(Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
