package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.enums.StatusPedido;

public class Pedido {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date dataCriacao = new Date();
	private StatusPedido status;
	private List<PedidoItem> pedidos = new ArrayList<>();
	private Cliente cliente;
	
	public Pedido(StatusPedido status, Cliente cliente) {
		this.status = status;
		this.cliente = cliente;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<PedidoItem> getPedidos() {
		return pedidos;
	}
	
	public void adicionarPedidoItem(PedidoItem pedido) {
		pedidos.add(pedido);
	}
	
	public void removerPedidoItem(PedidoItem pedido) {
		pedidos.remove(pedido);
	}
	
	public double calcularTotal() {
		Double soma = 0.0;
		for (PedidoItem pedidoItem: pedidos) {
			Integer quantidade = pedidoItem.getQuantidade();
			Produto produto = pedidoItem.getProduto();
			Double totalPedidoItem = quantidade * produto.getPreco();
			soma += totalPedidoItem;
		}
		return soma;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: "+sdf.format(dataCriacao)+"\n");
		sb.append("Status do pedido: "+status.toString()+"\n");
		sb.append("Cliente: "+cliente.getNome()+" ("+sdf2.format(cliente.getDataNascimento())+") - "+ cliente.getEmail()+"\n");
		sb.append("itens do pedido: \n");
		for(PedidoItem p : pedidos) {
			Produto produto = p.getProduto();
			sb.append(produto.getNome()+", "+produto.getPreco()+", Quantidade: "+p.getQuantidade()+", SubTotal: "+p.calcularSubTotal()+"\n");
		}
		sb.append("Total: "+calcularTotal()+"\n");
		return sb.toString();
	}
	
}
