package wsp.ifood.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wsp.ifood.Restaurante;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Pedido {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private BigDecimal subTotal;
	
	@Column(nullable = false)
	private BigDecimal taxaFrente;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	@Column(name = "data_confirmacao")
	private  LocalDateTime dataConfirmacao;
	
	@Column(name = "data_cancelamento")
	private LocalDateTime dataCancelamento;
	
	@Column(name = "data_entrega")
	private LocalDateTime dataEntrega;
	
	@Embedded
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable = false)
	private Restaurante restaurante;
	
	@ManyToMany
	@JoinTable(name = "pedido_forma_pagamento",
	           joinColumns = @JoinColumn(name = "pedido_id"),
	           inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	private List<FormaPagamento> formaPagamentos = new ArrayList<>();
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itensPedido = new ArrayList<>();
}
