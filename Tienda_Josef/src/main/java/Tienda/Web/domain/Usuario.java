/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data 
@Entity // Convierte la clase en entidad 
@Table(name = "usuario") // Llama a la tabla usuario de la base de datos mapeandola 
public class Usuario implements Serializable { // Llama a la biblioteca de serializable para 
    
    private static final long serialVersionUID = 1L; 

    @Id // Indica que este campo es la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID (auto_increment).
    @Column(name = "id_usuario")  // Llama a la tabla id_usuario de la base de datos mapeandola 
    private Long idUsuario;

    // Creacion de las variables de la tabla de base de datos 
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    private boolean activo;

    // Creacion de relacion uno a muchos con la entidad Rol
    @OneToMany
    @JoinColumn(name = "id_usuario") // Se va a usar el id_usuario fcomo llave para la relacion 
    private List<Rol> roles; // Llama la lista de rol 
}
