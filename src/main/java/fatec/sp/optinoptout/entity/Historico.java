package fatec.sp.optinoptout.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fatec.sp.optinoptout.enums.TipoHistorico;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "his_data")
    private Date data;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    private boolean sms;

    private boolean whats;

    private boolean ligacao;

    @Column(name = "termo_versao")
    private Long termoVersao;

    @Column(name = "tipo_historico")
    @Enumerated(value = EnumType.STRING)
    private TipoHistorico tipoHistorico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public TipoHistorico getTipoHistorico() {
        return this.tipoHistorico;
    }

    public void setTipoHistorico(TipoHistorico tipoHistorico) {
        this.tipoHistorico = tipoHistorico;
    }

}