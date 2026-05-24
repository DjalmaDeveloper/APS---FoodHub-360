package aps.FoodHub360.service;

import aps.FoodHub360.dto.DashboardDTO;
import aps.FoodHub360.model.CanalPedido;
import aps.FoodHub360.model.Pedido;
import aps.FoodHub360.model.StatusPedido;
import aps.FoodHub360.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = repository.findAll();

        pedidos.sort(
                Comparator
                        .comparing(Pedido::isPrioridadeAlta)
                        .reversed()
                        .thenComparing(Pedido::getHorario)
        );

        return pedidos;
    }

    public void salvar(Pedido pedido) {
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setHorario(LocalDateTime.now());

        repository.save(pedido);
    }

    public void alterarStatus(Long id, StatusPedido status) {
        Pedido pedido = repository.findById(id).orElseThrow();
        pedido.setStatus(status);

        if (status == StatusPedido.CONCLUIDO) {
            pedido.setHorario(LocalDateTime.now());
        }

        repository.save(pedido);
    }

    public DashboardDTO gerarDashboard() {

        List<Pedido> pedidos = repository.findAll();

        DashboardDTO dto = new DashboardDTO();

        dto.setTotalVendas(
                pedidos.stream()
                        .mapToDouble(Pedido::getValor)
                        .sum()
        );

        dto.setPedidosWhatsapp(
                pedidos.stream()
                        .filter(p -> p.getCanal()
                                == CanalPedido.WHATSAPP)
                        .count()
        );

        dto.setPedidosApp(
                pedidos.stream()
                        .filter(p -> p.getCanal()
                                == CanalPedido.APP)
                        .count()
        );

        dto.setPedidosBalcao(
                pedidos.stream()
                        .filter(p -> p.getCanal()
                                == CanalPedido.BALCAO)
                        .count()
        );

        dto.setPedidosDelivery(
                pedidos.stream()
                        .filter(p -> p.getCanal()
                                == CanalPedido.DELIVERY)
                        .count()
        );

        dto.setPedidosAbertos(
                pedidos.stream()
                        .filter(p -> p.getStatus()
                                == StatusPedido.ABERTO)
                        .count()
        );

        dto.setPedidosEmPreparo(
                pedidos.stream()
                        .filter(p -> p.getStatus()
                                == StatusPedido.EM_PREPARO)
                        .count()
        );

        dto.setPedidosConcluidos(
                pedidos.stream()
                        .filter(p -> p.getStatus()
                                == StatusPedido.CONCLUIDO)
                        .count()
        );

        double media = pedidos.stream()
                .filter(p -> p.getHorarioConclusao() != null)
                .mapToLong(p ->
                        Duration.between(
                                p.getHorario(),
                                p.getHorarioConclusao()
                        ).toMinutes()
                )
                .average()
                .orElse(0.0);

        dto.setTempoMedioProducao(media);

        return dto;
    }
}
