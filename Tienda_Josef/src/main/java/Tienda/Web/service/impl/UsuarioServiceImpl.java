/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.service.impl;

/**
 *
 * @author josef
 */


import Tienda.Web.dao.RolDao;
import Tienda.Web.dao.UsuarioDao;
import Tienda.Web.domain.Rol;
import Tienda.Web.domain.Usuario;
import Tienda.Web.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Llama la clase como servicio 
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired // Inyecta de las dependencias de usuarioDao
    private UsuarioDao usuarioDao;

    @Autowired // Inyecta de las dependencias de rolDao
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true) // Muestra los usuarios solo para lectura 
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll(); // Retorna todos los usuarios
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null); // Busca un usuario por ID
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username); // Busca un usuario por su username
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password); // Busca por username y contraseña
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo); // Busca por username o correo
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo); // Verifica si existe usuario o correo
    }

    @Override
    @Transactional 
    public void save(Usuario usuario, boolean crearRolUser) {
        usuario = usuarioDao.save(usuario); // Guarda el usuario

        if (crearRolUser) { // Si se esta creando el usuario asigna el rol por defecto que sera ROLE_USER
            Rol rol = new Rol(); 
            rol.setNombre("ROLE_USER");
            rol.setIdUsuario(usuario.getIdUsuario()); // Le pone el rol asociado a un ID del usuario
            rolDao.save(rol); // Guarda el rol 
        }
    }

    @Override
    @Transactional 
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario); // Elimina el usuario
    }
}