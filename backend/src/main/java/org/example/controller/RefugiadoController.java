package org.example.controller;

import org.example.dao.RefugiadoDAO;
import org.example.model.Refugiado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refugiados")
public class RefugiadoController {

    @Autowired
    private RefugiadoDAO refugiadoDAO;

    // Criar um novo refugiado
    @PostMapping
    public Refugiado criarRefugiado(@RequestBody Refugiado refugiado) {
        return refugiadoDAO.inserirRefugiado(refugiado);
    }

    // Obter todos os refugiados
    @GetMapping
    public List<Refugiado> listarRefugiados() {
        return refugiadoDAO.buscarTodosRefugiados();
    }

    /* Obter um refugiado por ID
    @GetMapping("/{id}")
    public Refugiado obterRefugiado(@PathVariable int id) {
        return refugiadoDAO.obterPorId(id);
    }*/

    // Atualizar um refugiado
    @PutMapping("/{id}")
    public Refugiado atualizarRefugiado(@PathVariable int id, @RequestBody Refugiado refugiado) {
        refugiado.setId(id);
        return refugiadoDAO.atualizarRefugiado(refugiado);
    }

    // Excluir um refugiado
    @DeleteMapping("/{id}")
    public void excluirRefugiado(@PathVariable int id) {
        refugiadoDAO.excluirRefugiado(id);
    }
}
