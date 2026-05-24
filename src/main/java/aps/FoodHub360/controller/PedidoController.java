package aps.FoodHub360.controller;

import aps.FoodHub360.model.CanalPedido;
import aps.FoodHub360.model.Pedido;
import aps.FoodHub360.model.PrioridadePedido;
import aps.FoodHub360.model.StatusPedido;
import aps.FoodHub360.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String monitor(Model model) {

        model.addAttribute(
                "pedidos",
                service.listarPedidos()
        );

        model.addAttribute(
                "dashboard",
                service.gerarDashboard()
        );

        return "monitor";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {

        model.addAttribute(
                "pedido",
                new Pedido()
        );

        model.addAttribute(
                "canais",
                CanalPedido.values()
        );

        model.addAttribute(
                "prioridades",
                PrioridadePedido.values()
        );

        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam String cliente,
                         @RequestParam String itens,
                         @RequestParam Double valor,
                         @RequestParam CanalPedido canal,
                         @RequestParam PrioridadePedido prioridade) {

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);

        pedido.setItens(
                java.util.Arrays.asList(
                        itens.split(",")
                )
        );

        pedido.setValor(valor);
        pedido.setCanal(canal);
        pedido.setPrioridade(prioridade);

        service.salvar(pedido);

        return "redirect:/";
    }

    @PostMapping("/status/{id}")
    public String alterarStatus(@PathVariable Long id,
                                @RequestParam StatusPedido status){

        service.alterarStatus(id, status);

        return "redirect:/";
    }
}
