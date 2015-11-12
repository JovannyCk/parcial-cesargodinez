/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uniec.parcial.cesargodinez;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ghosbyte
 */
@Controller
@RequestMapping("/reservaciones")


public class AquiSeHacenReservaciones {
    
    
    @RequestMapping("/guardar")
    @ResponseBody String guardar() throws Exception{
        DAOReservacion daor=new DAOReservacion();
        DAOCliente daoc=new DAOCliente();
        DAOTarjeta1 daot=new DAOTarjeta1();
        Cliente c1 =new Cliente();
        c1.setEmail("ghosbyte.sh@gmail.com");
        c1.setNombre("Ghosbyte");
        c1.setPaterno("scott");
        daoc.guardar(c1);
        
        Tarjeta1 t1=new Tarjeta1();
        t1.setIdCliente(c1);
        t1.setNombreTarjeta("Banamex");
        t1.setNumeroTarjeta(52043131);
        t1.setSaldo(120000f);
        daot.guardar(t1);
        
        Reservacion reservacion=new Reservacion();
        reservacion.setIdCliente(c1);
        reservacion.setIdTarjeta(t1);
        reservacion.setCiudadDestino("cancun");
        reservacion.setNombreHotel("Bahias");
        reservacion.setNumeroPersonas(2);
        
         return "Reervacion guardardada con exito";
    }  
}
