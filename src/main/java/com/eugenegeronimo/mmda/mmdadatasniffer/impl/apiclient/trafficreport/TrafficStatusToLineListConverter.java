package com.eugenegeronimo.mmda.mmdadatasniffer.impl.apiclient.trafficreport;

import com.eugenegeronimo.mmda.mmdadatasniffer.impl.apiclient.LineMap;
import com.eugenegeronimo.mmda.mmdadatasniffer.impl.apiclient.TrafficPointMap;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.Line;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficPoint;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TrafficStatusToLineListConverter {

    private static final Logger log = LoggerFactory.getLogger(TrafficStatusToLineListConverter.class);

    private static final int INDEX_TRAFFIC_POINT_DETAILS = 0;
    private static final int INDEX_TRAFFIC_POINT_DETAILS_LINE_ID = 0;
    private static final int INDEX_TRAFFIC_POINT_DETAILS_TRAFFIC_POINT_ID = 1;

    private static final int INDEX_TRAFFIC_POINT_ROUTE_NORTH_BOUND = 1;
    private static final int INDEX_TRAFFIC_POINT_ROUTE_SOUTH_BOUND = 2;
    private static final int INDEX_TRAFFIC_POINT_ROUTE_X_BOUND_TRAFFIC_LEVEL = 0;
    private static final int INDEX_TRAFFIC_POINT_ROUTE_X_BOUND_TIMESTAMP = 1;


    private static final String MESSAGE_KEY_TRAFFICPOINT_ROUTE_NAME_NORTHBOUND = "trafficPoint.route.name.northBound";
    private static final String MESSAGE_KEY_TRAFFICPOINT_ROUTE_NAME_SOUTHBOUND = "trafficPoint.route.name.southBound";

    @Autowired
    private TrafficPointMap trafficPointMap;

    @Autowired
    private LineMap lineMap;

    @Autowired
    private MessageSource messageSource;

    /**
     * Convert server provided JSON resource to list of {@link Line}
     *
     * @param json
     * @return
     */
    public List<Line> parse(String json) {
        Map<String, List<TrafficPoint>> trafficPointMap = new HashMap<>();
        JSONArray trafficPointListArray = new JSONArray(json);
        Iterator<Object> trafficPointListIterator = trafficPointListArray.iterator();
        while (trafficPointListIterator.hasNext()) {
            JSONArray trafficPointArray = (JSONArray) trafficPointListIterator.next();

            TrafficPoint trafficPoint;
            try {
                trafficPoint = createTrafficPoint(trafficPointArray);
            } catch (IllegalArgumentException e) {
                log.error(String.format("Cannot generate TrafficPoint object from given JSON Array: %s", trafficPointArray.toString(), e));
                continue;
            }

            String lineId = trafficPoint.getLineId();
            if (trafficPointMap.containsKey(lineId)) {
                List<TrafficPoint> trafficPoints = trafficPointMap.get(lineId);
                trafficPoints.add(trafficPoint);
                trafficPointMap.put(lineId, trafficPoints);
            } else {
                trafficPointMap.put(lineId, new ArrayList<>(Arrays.asList(trafficPoint)));
            }
        }

        List<Line> lines = new ArrayList<>();
        for (String lineId: trafficPointMap.keySet()) {
            String lineName = lineMap.getLineName(lineId);
            Line line = new Line(
                    lineId,
                    lineName,
                    trafficPointMap.get(lineId)
            );
            lines.add(line);
        }

        return lines;
    }

    /**
     * Generate {@link TrafficPoint} from traffic point JSON array
     *
     * @param trafficPointArray
     * @return
     */
    private TrafficPoint createTrafficPoint(JSONArray trafficPointArray) {
        // Instantiate North-Bound Route
        JSONArray northBoundDetails = (JSONArray) trafficPointArray.get(INDEX_TRAFFIC_POINT_ROUTE_NORTH_BOUND);
        TrafficPoint.Route northBoundRoute = createRoute(northBoundDetails, MESSAGE_KEY_TRAFFICPOINT_ROUTE_NAME_NORTHBOUND);

        // Instantiate South-Bound Route
        JSONArray southBoundDetails = (JSONArray) trafficPointArray.get(INDEX_TRAFFIC_POINT_ROUTE_SOUTH_BOUND);
        TrafficPoint.Route southBoundRoute = createRoute(southBoundDetails, MESSAGE_KEY_TRAFFICPOINT_ROUTE_NAME_SOUTHBOUND);

        JSONArray trafficPointDetails = (JSONArray) trafficPointArray.get(INDEX_TRAFFIC_POINT_DETAILS);

        String lineId = String.valueOf(trafficPointDetails.getInt(INDEX_TRAFFIC_POINT_DETAILS_LINE_ID));

        String lineName = lineMap.getLineName(lineId);
        String trafficPointId = String.valueOf(trafficPointDetails.getInt(INDEX_TRAFFIC_POINT_DETAILS_TRAFFIC_POINT_ID));
        String trafficPointName = trafficPointMap.getTrafficPointName(lineId, trafficPointId);

        return new TrafficPoint(
                trafficPointId,
                lineId,
                lineName,
                trafficPointName,
                Arrays.asList(northBoundRoute, southBoundRoute)
        );
    }

    /**
     * Generate {@link TrafficPoint.Route} from route details JSON array and set route name from given message resource key
     *
     * @param routeDetails
     * @param routeNameKey
     * @return
     * @throws IllegalArgumentException
     */
    private TrafficPoint.Route createRoute(JSONArray routeDetails, String routeNameKey) throws IllegalArgumentException {
        String routeName = messageSource.getMessage(
                routeNameKey,
                null,
                Locale.getDefault()
        );
        Integer trafficLevel = routeDetails.getInt(INDEX_TRAFFIC_POINT_ROUTE_X_BOUND_TRAFFIC_LEVEL);
        Long timestamp = routeDetails.getLong(INDEX_TRAFFIC_POINT_ROUTE_X_BOUND_TIMESTAMP);

        return new TrafficPoint.Route(routeName, trafficLevel, timestamp);
    }
}
