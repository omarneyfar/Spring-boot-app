package tn.iit.entity;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name="t_compte")
public class Compte implements Serializable{
	private static final long serialVersionUID = 1L;
	@Include //equals and hash Code fonction a base du RIB
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rib;
	@Column(name="Client")
	private String nomClient;
	private float solde;//BigDecimal
}
