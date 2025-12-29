package com.app.parcelmachineservice.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "parcel_machines")
public class ParcelMachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "osm_id", unique = true)
    private Long osmId;

    @Column(name = "overpass_ref")
    private Long overpassRef;

    @Column(nullable = false)
    private String name;

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_city")
    private String addressCity;

    @Column(columnDefinition = "POINT SRID 4326", nullable = false)
    private Point location;

    @UpdateTimestamp
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;
}
