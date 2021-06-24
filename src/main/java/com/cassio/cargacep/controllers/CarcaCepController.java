package com.cassio.cargacep.controllers;

import com.cassio.cargacep.models.entities.Rua;
import com.cassio.cargacep.repositories.RuaRepository;
import com.cassio.cargacep.services.CepCidadesService;
import com.cassio.cargacep.services.CepRuasService;
import com.cassio.cargacep.utils.Fetcher;
import com.cassio.cargacep.utils.PageableCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cargaCep")
public class CarcaCepController {

    @Autowired
    private final RuaRepository ruarepository;

    @Autowired
    private final CepCidadesService cepCidadesService;

    @Autowired
    private final CepRuasService cepRuasService;

    public CarcaCepController(RuaRepository ruarepository, CepCidadesService cepCidadesService, CepRuasService cepRuasService) {
        this.ruarepository = ruarepository;
        this.cepCidadesService = cepCidadesService;
        this.cepRuasService = cepRuasService;
    }

    @GetMapping
    public int findAll() throws IOException {
        FileWriter arquivosCep = cepCidadesService.popularCidadesCep();

        Fetcher<RuaRepository, Rua> f = new Fetcher<>(ruarepository) {
            @Override
            public List<Rua> fetch(Pageable pageRequest) {
                return ruarepository.findAll(pageRequest).toList();
            }
        };

        PageableCollection<Rua> pageableCollection = new PageableCollection<>(f);

        cepRuasService.popularCepsRuas(arquivosCep, pageableCollection);

        return 1;
    }
}
