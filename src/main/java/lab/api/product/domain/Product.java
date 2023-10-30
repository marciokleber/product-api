package lab.api.product.domain;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    @SequenceGenerator(name = "SEQ_PRODUCT", sequenceName = "SEQ_PRODUCT")
    private Long id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    private String observacao;

}
