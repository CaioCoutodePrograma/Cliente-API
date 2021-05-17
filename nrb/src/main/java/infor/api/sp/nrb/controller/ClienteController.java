package infor.api.sp.nrb.controller;

import infor.api.sp.nrb.models.Cliente;
import infor.api.sp.nrb.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api")
@Api(value="API REST Cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
    ClienteService clienteService = new ClienteService();

    @GetMapping("/clientes")
    @ApiOperation(value = "Retorna uma lista de Clientes")
    public List<Cliente> listacliente(){
        Cliente cliente0 =new Cliente(1,"Abelardo");
        Cliente cliente1 = new Cliente(2,"Xuliano");
        List<Cliente> listadeclientes = new ArrayList<>();
        listadeclientes.add(cliente0);
        listadeclientes.add(cliente1);
        //clienteService.add(listadeclientes);
        return listadeclientes;
    }



   /* @RequestMapping("/cliente/{id}")
    @ApiOperation(value ="Não retorna nada ainda")
    public Cliente cliente(@PathVariable int id){
        return clienteService.buscar(id);
    }*/
}
