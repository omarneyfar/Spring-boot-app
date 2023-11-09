package tn.iit.entity;

import java.io.Serializable;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor//obligatoire selon la spec JPA
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity

public class Compte implements Serializable /*obligatoire selon le JPa*/ {
	private static final long serialVersionUID = 1L;
	@Include//equals and hashcode fonctionne à base de rib pk
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
	private Long rib;
	private float solde;//BigDecimal
	@ManyToOne
	@JoinColumn(name = "client_cin")
	private Client client;
	//@Transient//attribut mais n'est pas sauvgarder dans la base (generalement dans les champs de calcul)
	//private int jarraya;

}