package com.cassio.cargacep.services;

import com.cassio.cargacep.models.CepCidades;
import com.cassio.cargacep.models.enums.Estados;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CepCidadesService {

    private static final String FILE_PATH_EXCEL_CEPS = "C:\\Users\\cassi\\Documents\\workspace-eclipse\\cargacep\\src\\main\\resources\\Lista_de_CEPs.xlsx";
    private static final int TIPO_CEP_MUNICIPIO = 2;

    public FileWriter popularCidadesCep() throws IOException {
        List<CepCidades> listaCepCidades = buscarCeps();
        List<CepCidades> listaCepsFormatada = formatarCeps(listaCepCidades);
        return escreverArquivoFinalCeps(listaCepsFormatada);
    }

    private static List<CepCidades> buscarCeps() throws IOException {
        List<CepCidades> cepCidadesRetorno = new ArrayList<>();

        FileInputStream arquivo = new FileInputStream(FILE_PATH_EXCEL_CEPS);
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            Iterator<Cell> cellIterator = row.cellIterator();

            CepCidades cepCidades = new CepCidades();
            cepCidades.setTipoCep(TIPO_CEP_MUNICIPIO);
            cepCidadesRetorno.add(cepCidades);

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        cepCidades.setSiglaUf(cell.getStringCellValue());
                        Estados estados = Estados.valueOf(cepCidades.getSiglaUf());
                        cepCidades.setNomeUf(estados.getNome());
                        break;
                    case 1:
                        cepCidades.setNomeLocalidade(cell.getStringCellValue());
                        break;
                    case 2:
                        break;
                    case 3:
                        cepCidades.setCep(((XSSFCell) cell).getRawValue());
                        break;
                    default:
                        break;
                }
            }
        }

        arquivo.close();

        return cepCidadesRetorno;
    }

    private static List<CepCidades> formatarCeps(List<CepCidades> listaCepCidades) {
        List<CepCidades> listaFormatada = new ArrayList<>();

        for (CepCidades cepCidades : listaCepCidades) {
            CepCidades cepCidadesFinal = new CepCidades();

            cepCidadesFinal.setTipoCep(cepCidades.getTipoCep());

            cepCidadesFinal.setCep(StringUtils.leftPad(cepCidades.getCep().trim(), 8, "0"));

            cepCidadesFinal.setSiglaUf(cepCidades.getSiglaUf().trim());

            String nomeUf = cepCidades.getNomeUf().trim();

            cepCidadesFinal.setNomeUf(StringUtils.rightPad(nomeUf, 70, ' '));

            cepCidadesFinal.setNomeLocalidade(cepCidades.getNomeLocalidade().trim());

            listaFormatada.add(cepCidadesFinal);
        }

        return listaFormatada;
    }

    private static FileWriter escreverArquivoFinalCeps(List<CepCidades> cepCidades) throws IOException {
        FileWriter arquivo = new FileWriter("C:\\Users\\cassi\\Documents\\workspace-eclipse\\cargacep\\src\\main\\resources\\CARGA_CEP_ARQUIVO_FINAL.txt");
        PrintWriter writer = new PrintWriter(arquivo);

        cepCidades.forEach(writer::println);

        return arquivo;
    }
}
