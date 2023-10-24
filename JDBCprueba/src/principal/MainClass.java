/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import principal.dominio.mascota.MascotaService;
import principal.dominio.usuario.UsuarioService;

/**
 *
 * @author pc
 */
public class MainClass {
    
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        MascotaService mascotaService = new MascotaService();

        
        try {
            //Creamos  usuarios
            usuarioService.crearUsuario("fiorde@hotmail.com", "fiorde14");
            usuarioService.crearUsuario("tincho@hotmail.com", "eggprogramacion");
            usuarioService.imprimirUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
    }
}
