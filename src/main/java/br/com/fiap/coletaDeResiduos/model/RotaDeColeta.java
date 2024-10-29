package br.com.fiap.coletaDeResiduos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "TAB_ROTA_DE_COLETA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RotaDeColeta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROTA")
    @SequenceGenerator(
            name = "SEQ_ROTA",
            sequenceName = "SEQ_ROTA",
            allocationSize = 50
    )
    @Column(name = "ROTA_ID")
    private Long rotaID;
    @Column(name = "NOME_ROTA")
    private String nomeDaRota;
    @Column(name = "DATA_COLETA")
    private Date dataDaColeta;
    @Column(name = "HORA_INICIO")
    private Date horaDeInicio;
    @Column(name = "HORA_TERMINO")
    private Date horaDeTermino;
    @Column(name = "DISTANCIA_TOTAL")
    private String distanciaRota;
    @Column(name = "TIPO_ROTA")
    private String tipoDeRota;
    @Column(name = "FREQUENCIA")
    private String frequenciaDaRota;
}
