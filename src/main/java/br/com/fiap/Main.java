package br.com.fiap;

import br.com.fiap.domain.entity.Bem;
import br.com.fiap.domain.entity.Departamento;
import br.com.fiap.domain.entity.Inventario;
import br.com.fiap.domain.entity.TipoDeBem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import javax.swing.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        //saveInventario(manager);
        //findById( manager );
        findAll( manager );

        manager.close();
        factory.close();
    }

    private static void saveInventario(EntityManager manager){
        TipoDeBem tipoDeBem = new TipoDeBem();
        tipoDeBem.setNome("Peugeot 308");

        Departamento departamento = new Departamento();
        departamento.setNome("Zona Sul");

        Bem bem = new Bem();
        bem.setNome("Carro 2");
        bem.setAquisicao(LocalDate.now());
        bem.setEtiqueta("ZZZ999");
        bem.setTipo(tipoDeBem);
        bem.setLocalizacao(departamento);

        Inventario inventario = new Inventario();
        inventario.setDepartamento(departamento);
        inventario.setInicio(LocalDate.now());
        inventario.setRelatorio("Não possui avarias!");

        manager.getTransaction().begin();
        manager.persist( bem );
        manager.persist( inventario );
        manager.persist( departamento );
        manager.persist( tipoDeBem );

        manager.getTransaction().commit();
    }

    private static void findAll(EntityManager manager) {
        List<Bem> list = manager.createQuery( "FROM Bem" ).getResultList();

        list.forEach( System.out::println );
    }

    private static void findById(EntityManager manager) {
        Long id = Long.valueOf( JOptionPane.showInputDialog( "ID do inventario" ) );
        Inventario inventario = manager.find( Inventario.class, id );
        System.out.println( inventario );
    }
}