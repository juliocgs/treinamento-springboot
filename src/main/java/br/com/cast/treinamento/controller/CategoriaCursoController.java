package br.com.cast.treinamento.controller;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cast.treinamento.model.dto.CategoriaCursoDTO;
import br.com.cast.treinamento.service.CategoriaCursoService;

@RestController
@RequestMapping(value = "/categoria-curso")
public class CategoriaCursoController {

    @Autowired
    private CategoriaCursoService service;

    @ApiOperation(value = "API para consultar as categorias de curso")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    @GetMapping
    public ResponseEntity<List<CategoriaCursoDTO>> consultar() {
        return ResponseEntity.ok(service.consultarTodos());
    }

    @PostMapping
    @ApiOperation(value = "API para incluir as categorias de curso")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Void> inserir(@RequestBody CategoriaCursoDTO curso) {
        service.inserir(curso);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "API para alterar as categorias de curso")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Void> alterar(@RequestBody CategoriaCursoDTO curso) {
        service.alterar(curso);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "API para excluir as categorias de curso")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Void> alterar(@PathVariable("id") Long id) {
        service.excluir(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
