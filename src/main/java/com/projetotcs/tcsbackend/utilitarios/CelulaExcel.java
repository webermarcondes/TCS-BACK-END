package com.projetotcs.tcsbackend.utilitarios;

import java.util.ArrayList;
import java.util.List;

public class CelulaExcel {

    private String conteudo;
    private String hexCorFundo;
    private List<String> hexsCoresFonte;
    private String alinhamento;

    public CelulaExcel(String conteudo, String hexCorFundo) {
        this.conteudo = conteudo;
        this.hexCorFundo = hexCorFundo;
        this.hexsCoresFonte = new ArrayList<>();
    }

    public CelulaExcel(String conteudo) {
        this.conteudo = conteudo;
        this.hexsCoresFonte = new ArrayList<String>();
        this.hexCorFundo = "";
    }

    public CelulaExcel(String conteudo, String hexCorFundo, String alinhamento) {
        this.conteudo = conteudo;
        this.hexCorFundo = hexCorFundo;
        this.alinhamento = alinhamento;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getHexCorFundo() {
        return hexCorFundo;
    }

    public void setHexCorFundo(String hexCorFundo) {
        this.hexCorFundo = hexCorFundo;
    }

    public List<String> getHexsCoresFonte() {
        return hexsCoresFonte;
    }

    public void setHexsCoresFonte(List<String> hexsCoresFonte) {
        this.hexsCoresFonte = hexsCoresFonte;
    }

    public void setHexCorFonte(String hexCorFonte) {
        this.hexsCoresFonte.add(hexCorFonte);
    }

    public String getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
    }
}
