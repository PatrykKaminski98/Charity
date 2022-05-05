package pl.coderslab.charity.institution;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class Institution {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotEmpty(message = "Nazwa fundacji nie może być pusta")
    private String name;
    @NotEmpty(message = "Fundacja musi mieć krótki opis")
    private String description;
}
