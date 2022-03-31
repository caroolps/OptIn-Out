package fatec.sp.optinoptout.vo;

public class UsuarioConfigVO {
    private boolean sms;
    private boolean whats;
    private boolean ligacao;

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
}
