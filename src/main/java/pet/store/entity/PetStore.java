package pet.store.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data

public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PetStoreId;
    private String petStoreAddress;
    private String petStoreName;
    private String petStoreCity;
    private String petStoreState;
    private String petStoreZip;
    private String petStorePhone;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pet_store_customer",
               joinColumns = @JoinColumn(name = "pet_store_id"),
               inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();
}
