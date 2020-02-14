package br.com.cast.treinamento.controller;

import br.com.cast.treinamento.model.dto.CursoDTO;
import br.com.cast.treinamento.model.dto.PaginacaoDTO;
import br.com.cast.treinamento.model.request.CursoPaginadoRequest;
import br.com.cast.treinamento.model.request.CursoRequest;
import br.com.cast.treinamento.service.CursoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    CursoService service;

    @ApiOperation(value = "API para consultar cursos")
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<List<CursoDTO>> consultar() {
        return ResponseEntity.ok(service.consultarTodos());
    }

    @ApiOperation(value = "API para consultar cursos de forma paginada")
    @PostMapping(value = "/consultar-paginado")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Page<CursoDTO>> consultarPaginado(@RequestBody PaginacaoDTO<CursoPaginadoRequest> filtro) {
        return ResponseEntity.ok(service.consultarPaginado(filtro));
    }

    @PostMapping
    @ApiOperation(value = "API para incluir cursos")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Void> inserir(@RequestBody CursoRequest curso) {
        service.inserir(curso.toDto());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "API para alterar cursos")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Void> alterar(@RequestBody CursoRequest curso) {
        service.alterar(curso.toDto());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "API para excluir cursos")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Token de acesso", required = true, paramType = "header", dataTypeClass = String.class) })
    public ResponseEntity<Void> alterar(@PathVariable("id") Long id) {
        service.excluir(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
