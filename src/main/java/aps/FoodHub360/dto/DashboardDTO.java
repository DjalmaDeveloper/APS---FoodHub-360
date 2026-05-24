package aps.FoodHub360.dto;

public class DashboardDTO {

    private Double totalVendas;
    private Long pedidosWhatsapp;
    private Long pedidosApp;
    private Long pedidosBalcao;
    private Long pedidosDelivery;
    private Long pedidosAbertos;
    private Long pedidosEmPreparo;
    private Long pedidosConcluidos;
    private Double tempoMedioProducao;

    public Double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public Long getPedidosWhatsapp() {
        return pedidosWhatsapp;
    }

    public void setPedidosWhatsapp(Long pedidosWhatsapp) {
        this.pedidosWhatsapp = pedidosWhatsapp;
    }

    public Long getPedidosApp() {
        return pedidosApp;
    }

    public void setPedidosApp(Long pedidosApp) {
        this.pedidosApp = pedidosApp;
    }

    public Long getPedidosBalcao() {
        return pedidosBalcao;
    }

    public void setPedidosBalcao(Long pedidosBalcao) {
        this.pedidosBalcao = pedidosBalcao;
    }

    public Long getPedidosDelivery() {
        return pedidosDelivery;
    }

    public void setPedidosDelivery(Long pedidosDelivery) {
        this.pedidosDelivery = pedidosDelivery;
    }

    public Long getPedidosAbertos() {
        return pedidosAbertos;
    }

    public void setPedidosAbertos(Long pedidosAbertos) {
        this.pedidosAbertos = pedidosAbertos;
    }

    public Long getPedidosEmPreparo() {
        return pedidosEmPreparo;
    }

    public void setPedidosEmPreparo(Long pedidosEmPreparo) {
        this.pedidosEmPreparo = pedidosEmPreparo;
    }

    public Long getPedidosConcluidos() {
        return pedidosConcluidos;
    }

    public void setPedidosConcluidos(Long pedidosConcluidos) {
        this.pedidosConcluidos = pedidosConcluidos;
    }

    public Double getTempoMedioProducao() {
        return tempoMedioProducao;
    }

    public void setTempoMedioProducao(Double tempoMedioProducao) {
        this.tempoMedioProducao = tempoMedioProducao;
    }
}
