package infor.api.sp.nrb.controller;

import infor.api.sp.nrb.models.Cliente;
import infor.api.sp.nrb.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api")
@Api(value="API REST Cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteService =new ClienteService();

    @GetMapping("/clientes")
    @ApiOperation(value = "Retorna uma lista de Clientes")
    public List<Cliente> listacliente(){

        Cliente cliente0 =new Cliente(1,"Abelardo");
        Cliente cliente1 = new Cliente(2,"Xuliano");
        List<Cliente> listadeclientes = new ArrayList<>();
        listadeclientes.add(cliente0);
        listadeclientes.add(cliente1);
        return  clienteService.add(listadeclientes);
    }

    @GetMapping("/cliente/{id}")
    @ApiOperation(value ="Retorna o CLiente Inserido")
    public Cliente cliente(@PathVariable int id){
        return clienteService.buscar(id);
    }

    @GetMapping ("/listaclientes")
    @ApiOperation(value = "Retorna todos os clientes")
    public  List<Cliente> listaClientes(){
        return clienteService.todosClientes();
    }

    @PostMapping("/cliente/add/{id}")
    @ApiOperation(value = "Adiciona um Cliente")
    public Cliente addcliente(@PathVariable int id,@RequestBody Cliente clientenovo){
        clientenovo.setId(id);
        return clienteService.addCliente(clientenovo);
    }
}
