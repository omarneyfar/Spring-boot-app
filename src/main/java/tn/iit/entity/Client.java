package tn.iit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor//obligatoire selon la spec JPA
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity

public class Client implements Serializable /*obligatoire selon le JPa*/ {
	private static final long serialVersionUID = 1L;
	@Include//equals and hashcode fonctionne à base de rib pk
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
	private Long cin;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "client")
	private List<Compte> compte;
	//BigDecimal
	//@Transient//attribut mais n'est pas sauvgarder dans la base (generalement dans les champs de calcul)
	//private int jarraya;

}