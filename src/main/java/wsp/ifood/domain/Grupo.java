package wsp.ifood.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Grupo {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "grupo_permissao",
	           joinColumns = @JoinColumn(name = "grupo_id"),
	           inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissaos = new ArrayList<>();
}
