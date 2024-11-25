package pe.edu.i202220639.cl1_jpa_data_diaz_luque.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePk {

    private String countryCode;
    private String language;

}
