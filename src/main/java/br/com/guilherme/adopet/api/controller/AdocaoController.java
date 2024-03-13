package br.com.guilherme.adopet.api.controller;

import br.com.guilherme.adopet.api.dto.AprovacaoAdocaoDTO;
import br.com.guilherme.adopet.api.dto.ReprovacaoAdocaoDTO;
import br.com.guilherme.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.guilherme.adopet.api.exception.ValidacaoException;
import br.com.guilherme.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

//O objetivo da classe controller é controlar o fluxo de requerimentos

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoAdocaoDTO dto) {
        try {
            this.adocaoService.solicitar(dto);
            return ResponseEntity.ok("Adoção solicitada com suceso");
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aprovar")
    @Transactional
    public ResponseEntity<String> aprovar(@RequestBody @Valid AprovacaoAdocaoDTO dto) {
        this.adocaoService.aprovar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    @Transactional
    public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovacaoAdocaoDTO dto) {
        this.adocaoService.reprovar(dto);
        return ResponseEntity.ok().build();
    }

}
