package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, nullable = false)
  private long id;
  @Column(nullable = false)
  private byte[] logo;

  @Column(nullable = false)
  private String nombre;

  @Column
  private Boolean Activo;

  @ManyToOne
  @JoinColumn(name = "procesoeleccion_id")
  private ProcesoEleccion procesoeleccion;
}
