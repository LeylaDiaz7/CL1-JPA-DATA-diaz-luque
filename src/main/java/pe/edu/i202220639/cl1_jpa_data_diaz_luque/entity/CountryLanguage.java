package pe.edu.i202220639.cl1_jpa_data_diaz_luque.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {


    @EmbeddedId
    private CountryLanguagePk countryLanguagePk;
    private String isOfficial;
    private Double percentage;

    @ManyToOne
    @JoinColumn(name="CountryCode")
    @MapsId("countryCode")
    private Country country;

}
