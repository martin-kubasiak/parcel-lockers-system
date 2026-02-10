package com.app.parcelmachineservice.infrastructure.output.persistence.entity.utils;

import org.locationtech.jts.geom.*;

public class GeometryUtils {
    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);

    public static Point createPoint(double longitude, double latitude) {
        return GEOMETRY_FACTORY.createPoint(new Coordinate(longitude, latitude));
    }

    public static BoundingBox calculateBoundingBox(double lat, double lon, double radiusKm) {
        double latOffset = radiusKm / 111.0;
        double lonOffset = radiusKm / (111.0 * Math.cos(Math.toRadians(lat)));

        return new BoundingBox(
                lat - latOffset, lon - lonOffset,
                lat + latOffset, lon + lonOffset
        );
    }

    public record BoundingBox(double minLat, double minLon, double maxLat, double maxLon) {
    }
}
