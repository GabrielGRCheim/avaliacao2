/*
 * Copyright (C) 2024 Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package lista.testefxgeodata;

/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 01/06/2024
 * @brief Class CSVUtils
 */
import java.io.*;
import java.util.*;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CSVUtils {

    public static List<Municipio> lerCSV(String caminho) {
        List<Municipio> municipios = new ArrayList<>();
        Locale.setDefault(Locale.forLanguageTag("pt-BR")); // Define o Locale padrão para o formato brasileiro
        NumberFormat numberFormat = NumberFormat.getInstance(); // Obtém o NumberFormat para o Locale padrão
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            String[] headers = br.readLine().split(";");  // Lê a primeira linha (cabeçalho)
            while ((linha = br.readLine()) != null) {
                String[] values = linha.split(";");
                Municipio municipio = new Municipio();
                municipio.setCodigoIBGE(values[0]);
                municipio.setNome(values[1]);
                municipio.setMicrorregiao(values[2]);
                municipio.setEstado(values[3]);
                municipio.setRegiaoGeografica(values[4]);
                municipio.setAreaKm2(parseDouble(numberFormat, values[5]));
                municipio.setPopulacao(parseInt(numberFormat, values[6]));
                municipio.setDomicilios(parseInt(numberFormat, values[7]));
                municipio.setPibTotal(parseDouble(numberFormat, values[8]));
                municipio.setIdh(parseDouble(numberFormat, values[9]));
                municipio.setRendaMedia(parseDouble(numberFormat, values[10]));
                municipio.setRendaNominal(parseDouble(numberFormat, values[11]));
                municipio.setPeaDia(parseInt(numberFormat, values[12]));
                municipio.setIdhEducacao(parseDouble(numberFormat, values[13]));
                municipio.setIdhLongevidade(parseDouble(numberFormat, values[14]));
                municipios.add(municipio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return municipios;
    }

    private static double parseDouble(NumberFormat numberFormat, String value) {
        try {
            return numberFormat.parse(value).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0; // Valor padrão em caso de erro
        }
    }

    private static int parseInt(NumberFormat numberFormat, String value) {
        try {
            return numberFormat.parse(value).intValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Valor padrão em caso de erro
        }
    }

    public static void escreverCSV(List<Municipio> municipios, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            bw.write("Código IBGE;Municípios;Microrregião;Estado;Região Geográfica;Área km2;População;Domicílios;PIB Total (R$ mil);IDH;Renda Média;Renda Nominal;PEA Dia;IDH Dimensão Educação;IDH Dimensão Longevidade\n");
            for (Municipio m : municipios) {
                bw.write(String.join(";",
                        m.getCodigoIBGE(),
                        m.getNome(),
                        m.getMicrorregiao(),
                        m.getEstado(),
                        m.getRegiaoGeografica(),
                        String.valueOf(m.getAreaKm2()).replace(".", ","),
                        String.valueOf(m.getPopulacao()).replace(".", ","),
                        String.valueOf(m.getDomicilios()).replace(".", ","),
                        String.valueOf(m.getPibTotal()).replace(".", ","),
                        String.valueOf(m.getIdh()).replace(".", ","),
                        String.valueOf(m.getRendaMedia()).replace(".", ","),
                        String.valueOf(m.getRendaNominal()).replace(".", ","),
                        String.valueOf(m.getPeaDia()).replace(".", ","),
                        String.valueOf(m.getIdhEducacao()).replace(".", ","),
                        String.valueOf(m.getIdhLongevidade()).replace(".", ",")
                ));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
