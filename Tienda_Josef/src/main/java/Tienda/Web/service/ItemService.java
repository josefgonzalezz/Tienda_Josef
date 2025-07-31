/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tienda.Web.service;

import Tienda.Web.domain.Item;
import java.util.List;

public interface ItemService {

    //Se usa para tener en una sesion de memoria la informacion del carrito de compras
    public List<Item> gets();

    //Se recupera el registro que tiene el iditem pasado por parametro
    //si no existe en la tabla se retorna null
    public Item get(Item item);

    //Se elimina el registro que tiene el iditem pasado por parametro
    public void delete(Item item);

    //Si el objeto item tiene un iditem que existe en la tabla item
    //El registro de actualiza con la nueva informacion
    //Si el iditem NO existe en la tabla, se crea el registro con esa informacion
    public void save(Item item);

    public void update(Item item);

    public void facturar();

    public double getTotal();
}