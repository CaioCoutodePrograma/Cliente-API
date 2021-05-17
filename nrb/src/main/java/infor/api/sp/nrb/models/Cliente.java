package infor.api.sp.nrb.models;

import org.hibernate.SessionFactory;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Cliente   implements Serializable {
    private static final long serialVersionID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(){
    }
    public Cliente(int id,String nome){
        this.id = id;
        this.nome = nome;
    }
}
