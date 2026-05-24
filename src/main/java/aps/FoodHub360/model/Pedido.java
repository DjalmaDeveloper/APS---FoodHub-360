package aps.FoodHub360.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    @ElementCollection
    private List<String> itens = new ArrayList<>();

    private Double valor;

    @Enumerated(EnumType.STRING)
    private CanalPedido canal;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Enumerated(EnumType.STRING)
    private PrioridadePedido prioridade;

    private LocalDateTime horario;

    private LocalDateTime horarioConclusao;

    public Pedido(){}

    public boolean isPrioridadeAlta(){
        return prioridade == PrioridadePedido.ALTA;
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public CanalPedido getCanal() {
        return canal;
    }

    public void setCanal(CanalPedido canal) {
        this.canal = canal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public PrioridadePedido getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadePedido prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public LocalDateTime getHorarioConclusao() {
        return horarioConclusao;
    }

    public void setHorarioConclusao(LocalDateTime horarioConclusao) {
        this.horarioConclusao = horarioConclusao;
    }
}
