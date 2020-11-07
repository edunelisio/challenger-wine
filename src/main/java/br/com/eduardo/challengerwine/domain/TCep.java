package br.com.eduardo.challengerwine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class TCep implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String ibge;

    public String getCepFormatted() {
        return cep.trim().replace("-","");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCep tCep = (TCep) o;
        return Objects.equals(cep, tCep.cep) &&
                Objects.equals(ibge, tCep.ibge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, ibge);
    }
}
