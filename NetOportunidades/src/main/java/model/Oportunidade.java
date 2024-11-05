package model;

import java.util.Date;

public class Oportunidade {
	
    private Integer idOptn;
    private String nmVendedor;
    private String nmCliente;
    private Date dtInicio;
    private Date dtFim;
    private Double vlPrevisto;
    private String txDescricao;
    private Integer cdStatus;
    private String txMotivo;

    public Oportunidade() {
    }

    // Construtor
    public Oportunidade(Integer idOptn, String nmVendedor, String nmCliente, Date dtInicio, Date dtFim, Double vlPrevisto, String txDescricao, Integer cdStatus, String txMotivo) {
        this.idOptn = idOptn;
        this.nmVendedor = nmVendedor;
        this.nmCliente = nmCliente;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.vlPrevisto = vlPrevisto;
        this.txDescricao = txDescricao;
        this.cdStatus = cdStatus;
        this.txMotivo = txMotivo;
    }

    // Getters e Setters
    public Integer getIdOptn() {
        return this.idOptn;
    }

    public void setIdOptn(Integer idOptn) {
        this.idOptn = idOptn;
    }

    public String getNmVendedor() {
        return nmVendedor;
    }

    public void setNmVendedor(String nmVendedor) {
        this.nmVendedor = nmVendedor;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Double getVlPrevisto() {
    	if (this.vlPrevisto == null) {
    		return 0.0;
    	}
    	else
    		return vlPrevisto;
    }

    public void setVlPrevisto(Double vlPrevisto) {
        this.vlPrevisto = vlPrevisto;
    }

    public String getTxDescricao() {
        return txDescricao;
    }

    public void setTxDescricao(String txDescricao) {
        this.txDescricao = txDescricao;
    }

    public String getCdStatusStr() {
    	  switch (this.cdStatus) {
    	  case 1:
    		  return "ABERTO";
          case 2:
        	  return "EM ANDAMENTO";
          case 3:
        	  return "PAUSADO";
          case 4:
        	  return "SUCESSO";
          case 5:
        	  return "FALHA";
          case 6:
        	  return "CANCELADO";
          default:
          	return "ABERTO";
    	  }
    }

    public Integer getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
      switch (cdStatus) {
  	  	case "ABERTO":
  			this.cdStatus = 1;
        case "EM ANDAMENTO":
        	this.cdStatus = 2;
        case "PAUSADO":
        	this.cdStatus = 3;
        case "SUCESSO":
        	this.cdStatus = 4;
        case "FALHA":
        	this.cdStatus = 5;
        case "CANCELADO":
        	this.cdStatus = 6;
        default:
        	this.cdStatus = 1;
  	  }
    }
    
    public void setCdStatus(Integer cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getTxMotivo() {
        return txMotivo;
    }

    public void setTxMotivo(String txMotivo) {
        this.txMotivo = txMotivo;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idOptn=" + idOptn +
                ", nmVendedor='" + nmVendedor + '\'' +
                ", nmCliente='" + nmCliente + '\'' +
                ", dtInicio=" + dtInicio +
                ", dtFim=" + dtFim +
                ", vlPrevisto=" + vlPrevisto +
                ", txDescricao='" + txDescricao + '\'' +
                ", cdStatus=" + cdStatus +
                ", txMotivo='" + txMotivo + '\'' +
                '}';
    }
}