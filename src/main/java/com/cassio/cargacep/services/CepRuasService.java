package com.cassio.cargacep.services;

import com.cassio.cargacep.models.CepRuas;
import com.cassio.cargacep.models.entities.Rua;
import com.cassio.cargacep.models.enums.TipoLogradouro;
import com.cassio.cargacep.utils.PageableCollection;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CepRuasService {

    private static final int TIPO_CEP_UNIDADES_OPERACIONAIS = 5;

    public void popularCepsRuas(FileWriter arquivosCep, PageableCollection<Rua> ruas) throws IOException {
        List<CepRuas> listaCepsRuas = new ArrayList<>();

        for (Rua rua : ruas) {
            CepRuas cepFinal = new CepRuas();

            cepFinal.setTipoCep(TIPO_CEP_UNIDADES_OPERACIONAIS);

            cepFinal.setCep(StringUtils.leftPad(Long.toString(rua.getCep()), 8, "0"));

            cepFinal.setSiglaUf(rua.getBairro().getCidade().getEstado().getUf().trim());

            cepFinal.setNomeUf(StringUtils.rightPad(rua.getBairro().getCidade().getEstado().getNomeEstado().trim(), 70, ' '));

            cepFinal.setNomeLocalidade(StringUtils.rightPad(rua.getBairro().getCidade().getNomeCidade().trim(), 70, ' '));

            cepFinal.setNomeBairro(StringUtils.rightPad(rua.getBairro().getNomeBairro(), 70, ' '));

            cepFinal.setNomeBairroAbreviado(StringUtils.rightPad(rua.getBairro().getNomeBairro().substring(0, Math.min(rua.getBairro().getNomeBairro().length(), 19)) + ".", 30, ' '));

            cepFinal.setNomeTipoLogradouro(StringUtils.rightPad(rua.getTipo(), 30, ' '));

            cepFinal.setNomeTipoLogradouroAbreviado(StringUtils.rightPad(descobrirTipoDeLogradouroAbreviado(rua.getTipo()), 53, ' '));

            cepFinal.setNomeLogradouro(StringUtils.rightPad(rua.getNomeRua(), 210, ' '));

            cepFinal.setCodIbgeEstado(StringUtils.rightPad(Long.toString(rua.getBairro().getCidade().getEstado().getIbge()), 6, ' '));

            cepFinal.setCodIbgeCidade(StringUtils.rightPad(Long.toString(rua.getBairro().getCidade().getIbge()), 48, ' '));

            listaCepsRuas.add(cepFinal);
        }

        escreverArquivoFinalCepsAPI(arquivosCep, listaCepsRuas);
    }

    private static String descobrirTipoDeLogradouroAbreviado(String tipoLogradouro) {
        for (TipoLogradouro tipo : TipoLogradouro.values()) {
            if (tipoLogradouro.toLowerCase(Locale.ROOT).contains(tipo.getNomeReal().toLowerCase(Locale.ROOT))) {
                return tipo.getAbreviacao().toUpperCase(Locale.ROOT);
            }
        }
        return StringUtils.EMPTY;
    }

    private static void escreverArquivoFinalCepsAPI(FileWriter arquivo, List<CepRuas> cepsAPI) throws IOException {
        PrintWriter writer = new PrintWriter(arquivo);

        cepsAPI.forEach(writer::println);

        arquivo.close();
    }
}
