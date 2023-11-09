package tn.iit.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor//obligatoire selon la spec JPA
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name="t_client")//pour changer le nom de tableau dans mysql(recommandé)
public class Client implements Serializable /*obligatoire selon le JPa*/ {
	private static final long serialVersionUID = 1L;
	@Include//equals and hashcode fonctionne à base de rib pk
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
	private Long id;
	@Column(name="compte")//changer le nom du colonne dans le tableau
	private String nomClient;
	private float solde;//BigDecimal
	//@Transient//attribut mais n'est pas sauvgarder dans la base (generalement dans les champs de calcul)
	//private int jarraya;

}