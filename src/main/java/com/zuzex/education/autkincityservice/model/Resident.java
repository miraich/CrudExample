package com.zuzex.education.autkincityservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@NamedEntityGraph(
        name = "Resident",
        attributeNodes = {
                @NamedAttributeNode("passport"),
                @NamedAttributeNode("houses")
        }
)
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(mappedBy = "resident")
    private Set<Car> cars;

    @ManyToMany
    @BatchSize(size = 5)
    @JoinTable(
            name = "resident_house",
            joinColumns = @JoinColumn(name = "resident_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    private Set<House> houses;

    @Column(nullable = false)
    private String phone;
}
