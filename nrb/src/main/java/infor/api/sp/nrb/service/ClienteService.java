package infor.api.sp.nrb.service;

import infor.api.sp.nrb.models.Cliente;
import infor.api.sp.nrb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;



    public Cliente buscar(int id){
        System.out.print(this.clienteRepository);
        Optional<Cliente> clienteObj = this.clienteRepository.findById(id);
        System.out.print(this.clienteRepository);
        return clienteObj.orElse(null);
    }
    public void  add(List<Cliente> clientes){
        clienteRepository.saveAll(clientes);
    }

}
