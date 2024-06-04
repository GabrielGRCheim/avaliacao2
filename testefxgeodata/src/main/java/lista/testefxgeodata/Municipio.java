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
 * @brief Class Municipio
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Municipio {
    private String codigoIBGE;
    private String nome;
    private String microrregiao;
    private String estado;
    private String regiaoGeografica;
    private double areaKm2;
    private int populacao;
    private int domicilios;
    private double pibTotal;
    private double idh;
    private double rendaMedia;
    private double rendaNominal;
    private int peaDia;
    private double idhEducacao;
    private double idhLongevidade;
    private LocalDateTime dataUltimaAtualizacao;

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

    public String getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(String microrregiao) {
        this.microrregiao = microrregiao;
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

    public double getAreaKm2() {
        return areaKm2;
    }

    public void setAreaKm2(double areaKm2) {
        this.areaKm2 = areaKm2;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(int domicilios) {
        this.domicilios = domicilios;
    }

    public double getPibTotal() {
        return pibTotal;
    }

    public void setPibTotal(double pibTotal) {
        this.pibTotal = pibTotal;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(double idh) {
        this.idh = idh;
    }

    public double getRendaMedia() {
        return rendaMedia;
    }

    public void setRendaMedia(double rendaMedia) {
        this.rendaMedia = rendaMedia;
    }

    public double getRendaNominal() {
        return rendaNominal;
    }

    public void setRendaNominal(double rendaNominal) {
        this.rendaNominal = rendaNominal;
    }

    public int getPeaDia() {
        return peaDia;
    }

    public void setPeaDia(int peaDia) {
        this.peaDia = peaDia;
    }

    public double getIdhEducacao() {
        return idhEducacao;
    }

    public void setIdhEducacao(double idhEducacao) {
        this.idhEducacao = idhEducacao;
    }

    public double getIdhLongevidade() {
        return idhLongevidade;
    }

    public void setIdhLongevidade(double idhLongevidade) {
        this.idhLongevidade = idhLongevidade;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
    
    

    // Getters e Setters omitidos por brevidade

    // Métodos para cálculos
    public double calcularDensidadeDemografica() {
        return populacao / areaKm2;
    }

    public double calcularPibPerCapita() {
        return pibTotal / populacao;
    }

    public String classificarIDH(double idh) {
        if (idh > 0.80) {
            return "Muito alto";
        } else if (idh >= 0.70) {
            return "Alto";
        } else if (idh >= 0.55) {
            return "Médio";
        } else {
            return "Baixo";
        }
    }

    public String getDataUltimaAtualizacaoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataUltimaAtualizacao.format(formatter);
    }

    // Outros métodos omitidos por brevidade
}