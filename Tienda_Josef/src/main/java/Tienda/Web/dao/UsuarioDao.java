/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.dao;



import Tienda.Web.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> { // Repositorio para la entidad Usuario que estaba en el domain 

    Usuario findByUsername(String username); // Busca por nombre de usuario

    Usuario findByUsernameAndPassword(String username, String password); // Busca por usuario y contraseña

    Usuario findByUsernameOrCorreo(String username, String correo); // Busca por usuario o correo

    boolean existsByUsernameOrCorreo(String username, String correo); // Verifica si existe usuario o correo
}
