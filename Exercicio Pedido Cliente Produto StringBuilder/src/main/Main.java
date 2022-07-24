package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.enums.StatusPedido;
import entidades.Cliente;
import entidades.Pedido;
import entidades.PedidoItem;
import entidades.Produto;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/* O programa recebe informações sobre o cliente e os pedidos. */
		/* retorna uma saída com a relação de todas as informações entradas utilizando StringBuilder */
		/* Exercício em java para treinamento de conceitos como scanner, entidades, classes, */
		/* métodos, construtor, StringBuilder, data, entrada e saída de dados etc...  */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/* Cliente */
		System.out.println("Sobre o cliente: ");
		System.out.print("Nome: ");
		String nomeCliente = sc.next();
		System.out.print("Email: ");
		String emailCliente = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Data de Nascimento DD/MM/YYYY: ");
		Date nascimentoCliente = sdf.parse(sc.next());
		Cliente cliente = new Cliente(nomeCliente, emailCliente, nascimentoCliente);
		
		/* Pedido */
		System.out.println("Sobre os pedidos: ");
		System.out.print("Status do pedido PAGAMENTO_PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		Pedido pedido = new Pedido(status, cliente);
		
		System.out.print("Quantos itens o pedido possui: ");
		Integer quantidadeItemsPedido = sc.nextInt();
	
		for(int i=0;i<quantidadeItemsPedido;i++) {
			System.out.println("Informações do pedido #"+i);
			System.out.print("Nome do produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço do produto: ");
			Double precoProduto = sc.nextDouble();
			System.out.print("Quantidade do produto: ");
			Integer quantidadeProduto = sc.nextInt();
			Produto produto = new Produto(nomeProduto, precoProduto);
			PedidoItem pedidoItem = new PedidoItem(quantidadeProduto, produto);
			pedido.adicionarPedidoItem(pedidoItem);
		}
		
		System.out.println(pedido);
		
		sc.close();

	}

}
