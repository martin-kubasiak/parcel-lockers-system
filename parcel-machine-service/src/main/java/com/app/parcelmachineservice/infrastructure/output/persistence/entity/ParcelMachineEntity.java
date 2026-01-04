package com.app.parcelmachineservice.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parcel_machines")
public class ParcelMachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "osm_id", unique = true)
    private Long osmId;

    @Column(name = "overpass_ref", unique = true)
    private String overpassRef;

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

    @Builder
    public ParcelMachineEntity(Long osmId, String overpassRef, String name,
                               String addressStreet, String addressCity, Point location) {
        this.osmId = osmId;
        this.overpassRef = overpassRef;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParcelMachineEntity that = (ParcelMachineEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
