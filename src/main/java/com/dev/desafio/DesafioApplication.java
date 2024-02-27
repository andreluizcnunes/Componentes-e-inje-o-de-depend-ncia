package com.dev.desafio;

import com.dev.desafio.entities.Order;
import com.dev.desafio.services.OrderService;
import com.dev.desafio.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Numero Pedido: ");
		Integer codido = sc.nextInt();

		System.out.print("Valor Pedido: ");
		double valor = sc.nextDouble();

		System.out.print("Porcento Desconto: ");
		double desconto = sc.nextDouble();

		Order order = new Order(codido, valor, desconto);

		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderService(shippingService);

		double total = orderService.total(order);

		System.out.println("Pedido código " + codido);
		System.out.println("Valor total: R$ " + total);
		sc.close();
	}
}
