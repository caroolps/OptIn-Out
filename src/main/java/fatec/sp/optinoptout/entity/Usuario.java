package fatec.sp.optinoptout.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "usu_nome")
	private String nome;

	@Column(name = "usu_email")
	private String email;

	@Column(name = "usu_cpf")
	private String cpf;

	@Column(name = "usu_celular")
	private String celular;

	@Column(name = "usu_rua")
	private String rua;

	@Column(name = "usu_nmr")
	private String numero;

	@Column(name = "usu_bairro")
	private String bairro;

	@Column(name = "usu_cidade")
	private String cidade;

	@Column(name = "usu_cep")
	private int cep;

	@Column(name = "usu_dCriacao")
	private Date dCriacao;

	@Column(name = "usu_dAtualizacao")
	private Date dAtualizacao;

	@Column(name = "receber_sms")
	private boolean sms;

	@Column(name = "receber_whats")
	private boolean whats;

	@Column(name = "receber_ligacao")
	private boolean ligacao;

	@Column(name = "usu_termo")
	private Long termoVersao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public Date getdCriacao() {
		return dCriacao;
	}

	public void setdCriacao(Date dCriacao) {
		this.dCriacao = dCriacao;
	}

	public Date getdAtualizacao() {
		return dAtualizacao;
	}

	public void setdAtualizacao(Date dAtualizacao) {
		this.dAtualizacao = dAtualizacao;
	}

	public boolean getSms() {
		return sms;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}

	public boolean getWhats() {
		return whats;
	}

	public void setWhats(boolean whats) {
		this.whats = whats;
	}

	public boolean getLigacao() {
		return ligacao;
	}

	public void setLigacao(boolean ligacao) {
		this.ligacao = ligacao;
	}

	public Long getTermoVersao() {
		return termoVersao;
	}

	public void setTermoVersao(Long termoVersao) {
		this.termoVersao = termoVersao;
	}
}