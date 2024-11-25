package pe.edu.i202220639.cl1_jpa_data_diaz_luque.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
public class CountryLanguagePk implements Serializable {

    private String countryCode;
    private String language;

}
