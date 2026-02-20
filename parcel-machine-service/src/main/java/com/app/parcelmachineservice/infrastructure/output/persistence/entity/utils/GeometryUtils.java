package com.app.parcelmachineservice.infrastructure.output.persistence.entity.utils;

import org.locationtech.jts.geom.*;

public class GeometryUtils {
    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);

    public static Point createPoint(double longitude, double latitude) {
        return GEOMETRY_FACTORY.createPoint(new Coordinate(longitude, latitude));
    }

    /**
     * Calculates an approximate geographic bounding box for a given point and radius.
     *
     * The method assumes a spherical Earth and converts the radius (in kilometers)
     * into latitude and longitude degree offsets.
     *
     * Latitude offset is constant because one degree of latitude is ~111 km everywhere on Earth.
     * Longitude offset varies depending on latitude and is adjusted using the cosine
     * of the latitude to account for the shrinking distance between meridians
     * as we move toward the poles.
     *
     * This is a fast, practical approximation suitable for pre-filtering spatial queries
     * (e.g. in database searches) before applying more precise distance calculations.
     *
     * @param lat center latitude in decimal degrees
     * @param lon center longitude in decimal degrees
     * @param radiusKm search radius in kilometers
     * @return bounding box that fully contains the circle with the given radius
     */
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
