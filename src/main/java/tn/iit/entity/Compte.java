package tn.iit.entity;

import java.io.Serializable;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name="t_compte")//pour changer le nom de tableau dans mysql(recommandé)
public class Compte implements Serializable /*obligatoire selon le JPa*/ {
	private static final long serialVersionUID = 1L;
	@Include//equals and hashcode fonctionne à base de rib pk
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
	private Long rib;
	@Column(name="client")//changer le nom du colonne dans le tableau
	private String nomClient;
	private float solde;//BigDecimal
	//@Transient//attribut mais n'est pas sauvgarder dans la base (generalement dans les champs de calcul)
	//private int jarraya;

}