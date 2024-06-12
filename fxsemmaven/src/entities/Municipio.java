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
package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 09/06/2024
 * @brief Class Municipio
 */
public class Municipio {

    private String codigoIBGE;
    private String nome;
    private String microRegiao;
    private String estado;
    private String regiaoGeografica;
    private String areaKm;
    private String populacao;
    private String domicilios;
    private String pibTotal;
    private String idh;
    private String rendaMedia;
    private String rendaNominal;
    private String peaDia;
    private String idhEducacao;
    private String idhLongevidade;
    private String dataUltimaAtualizacao;

    public Municipio() {
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMicroRegiao() {
        return microRegiao;
    }

    public void setMicroRegiao(String microRegiao) {
        this.microRegiao = microRegiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiaoGeografica() {
        return regiaoGeografica;
    }

    public void setRegiaoGeografica(String regiaoGeografica) {
        this.regiaoGeografica = regiaoGeografica;
    }

    public String getAreaKm() {
        return areaKm;
    }

    public void setAreaKm(String areaKm) {
        this.areaKm = areaKm;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(String domicilios) {
        this.domicilios = domicilios;
    }

    public String getPibTotal() {
        return pibTotal;
    }

    public void setPibTotal(String pibTotal) {
        this.pibTotal = pibTotal;
    }

    public String getIdh() {
        return idh;
    }

    public void setIdh(String idh) {
        this.idh = idh;
    }

    public String getRendaMedia() {
        return rendaMedia;
    }

    public void setRendaMedia(String rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    public String getRendaNominal() {
        return rendaNominal;
    }

    public void setRendaNominal(String rendaNominal) {
        this.rendaNominal = rendaNominal;
    }

    public String getPeaDia() {
        return peaDia;
    }

    public void setPeaDia(String peaDia) {
        this.peaDia = peaDia;
    }

    public String getIdhEducacao() {
        return idhEducacao;
    }

    public void setIdhEducacao(String idhEducacao) {
        this.idhEducacao = idhEducacao;
    }

    public String getIdhLongevidade() {
        return idhLongevidade;
    }

    public void setIdhLongevidade(String idhLongevidade) {
        this.idhLongevidade = idhLongevidade;
    }

    public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public static double converter(String valor) {
        String valorSemFormato = valor.replace(".", "").replace(",", ".");
        return Double.parseDouble(valorSemFormato);
    }

    public double calcularDensidadeDemografica() {
        double populacaoNumerica = converter(populacao);
        double areaNumerica = converter(areaKm);

        double densidadeDemografica = populacaoNumerica / areaNumerica;

        return densidadeDemografica;
    }

    public double calcularPIBPerCapitaTotal() {
        double pibTotalNumerico = converter(pibTotal);
        double populacaoNumerica = converter(populacao);

        double pibPerCapitaTotal = pibTotalNumerico / populacaoNumerica;

        return pibPerCapitaTotal;
    }

    public String classificarIDH() {
        if (idh == null) {
            return null;
        } else {
            return classificarValor(converter(idh));
        }
    }

    public String classificarIDHLongevidade() {
        if (idh == null) {
            return null;
        } else {
            return classificarValor(converter(idhLongevidade));
        }
    }

    public String classificarIDHEducacao() {
        if (idh == null) {
            return null;
        } else {
            return classificarValor(converter(idhEducacao));
        }
    }

    private String classificarValor(double valor) {
        if (valor > 0.80) {
            return "Muito alto";
        } else if (valor >= 0.70) {
            return "Alto";
        } else if (valor >= 0.55) {
            return "Médio";
        } else {
            return "Baixo";
        }
    }

    public String converterParaString(double valor) {
        String valorString = String.format("%.5f", valor);
        return valorString;
    }

    public static void limparMunicipio(Municipio municipioSelecionado) {
        System.out.println("Iniciando a limpeza do município: " + municipioSelecionado.getNome());

        municipioSelecionado.setPopulacao(null);
        municipioSelecionado.setDomicilios(null);
        municipioSelecionado.setPibTotal(null);
        municipioSelecionado.setIdh(null);
        municipioSelecionado.setRendaMedia(null);
        municipioSelecionado.setRendaNominal(null);
        municipioSelecionado.setPeaDia(null);
        municipioSelecionado.setIdhEducacao(null);
        municipioSelecionado.setIdhLongevidade(null);

        LocalDateTime dataAtualizacao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataAtualizacao.format(formatter);
        municipioSelecionado.setDataUltimaAtualizacao(dataFormatada);
        // Apagando classificações do IDH
        // Você pode adicionar mais lógicas aqui se houver mais propriedades relacionadas à classificação de IDH
        System.out.println("Município limpo: " + municipioSelecionado.getNome());
    }
}
