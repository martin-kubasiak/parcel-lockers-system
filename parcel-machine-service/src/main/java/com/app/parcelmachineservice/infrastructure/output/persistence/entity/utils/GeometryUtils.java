package com.app.parcelmachineservice.infrastructure.output.persistence.entity.utils;

import org.locationtech.jts.geom.*;

public class GeometryUtils {
    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);

    public static Point createPoint(double longitude, double latitude) {
        return GEOMETRY_FACTORY.createPoint(new Coordinate(longitude, latitude));
    }
}
