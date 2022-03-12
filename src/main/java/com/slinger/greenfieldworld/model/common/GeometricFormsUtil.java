package com.slinger.greenfieldworld.model.common;

import com.slinger.greenfieldworld.model.world.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class GeometricFormsUtil {

    private GeometricFormsUtil() {
        /* Util */
    }

    public static List<Coordinate> midPointAlgorithmDrawCircle(int xCentre, int yCentre, int r) {

        List<Coordinate> coordinateList = new ArrayList<>();

        int x = r, y = 0;

        /* Adding the initial coordinate on the axes after translation. */
        coordinateList.add(Coordinate.of(x + xCentre, y + yCentre));

        /* When radius is zero, only a single coordinate will be added. */
        if (r > 0) {

            coordinateList.add(Coordinate.of(-x + xCentre, -y + yCentre));
            coordinateList.add(Coordinate.of(y + xCentre, x + yCentre));
            coordinateList.add(Coordinate.of(-y + xCentre, -x + yCentre));
        }

        /* Initialising the value p. */
        int p = 1 - r;

        while (x > y) {

            y++;

            /* Mid-point is inside or on the perimeter. */
            if (p <= 0)
                p = p + 2 * y + 1;

                /* Mid-point is outside the perimeter. */
            else {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }

            /* All the perimeter points have already been added. */
            if (x < y)
                break;

            /* Adding the generated point and its reflections on the other eights after translation. */
            coordinateList.add(Coordinate.of(x + xCentre, y + yCentre));

            coordinateList.add(Coordinate.of(-x + xCentre, y + yCentre));
            coordinateList.add(Coordinate.of(x + xCentre, -y + yCentre));
            coordinateList.add(Coordinate.of(-x + xCentre, -y + yCentre));

            /* If the generated point is on the line x = y then perimeter points have already been added. */
            if (x != y) {

                coordinateList.add(Coordinate.of(y + xCentre, x + yCentre));

                coordinateList.add(Coordinate.of(-y + xCentre, x + yCentre));
                coordinateList.add(Coordinate.of(y + xCentre, -x + yCentre));
                coordinateList.add(Coordinate.of(-y + xCentre, -x + yCentre));
            }
        }

        return coordinateList;
    }

    public static List<Coordinate> midPointAlgorithmDrawCircleFilled(int xCentre, int yCentre, int r) {

        List<Coordinate> coordinateList = new ArrayList<>();

        int x = r, y = 0;

        /* Adding the initial coordinate on the axes after translation. */
        Coordinate end = Coordinate.of(x + xCentre, y + yCentre);

        /* When radius is zero, only a single coordinate will be added. */
        if (r > 0) {

            Coordinate start = Coordinate.of(-x + xCentre, -y + yCentre);

            coordinateList.addAll(GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));
        } else
            coordinateList.add(end);

        /* Initialising the value p. */
        int p = 1 - r;

        while (x > y) {

            y++;

            /* Mid-point is inside or on the perimeter. */
            if (p <= 0)
                p = p + 2 * y + 1;

                /* Mid-point is outside the perimeter. */
            else {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }

            /* All the perimeter points have already been added. */
            if (x < y)
                break;

            /* Adding the generated point and its reflections on the other eights after translation. */
            end = Coordinate.of(x + xCentre, y + yCentre);
            Coordinate start = Coordinate.of(-x + xCentre, y + yCentre);

            coordinateList.addAll(GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));

            end = Coordinate.of(x + xCentre, -y + yCentre);
            start = Coordinate.of(-x + xCentre, -y + yCentre);

            coordinateList.addAll(GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));

            /* If the generated point is on the line x = y then perimeter points have already been added. */
            if (x != y) {

                end = Coordinate.of(y + xCentre, x + yCentre);
                start = Coordinate.of(-y + xCentre, x + yCentre);

                coordinateList.addAll(GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));

                end = Coordinate.of(y + xCentre, -x + yCentre);
                start = Coordinate.of(-y + xCentre, -x + yCentre);

                coordinateList.addAll(GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));
            }
        }

        return coordinateList;
    }

    public static List<Coordinate> getCoordinatesOfHorizontalLine(Coordinate start, Coordinate end) {

        if (start.getY() != end.getY())
            throw new IllegalStateException(MessageUtil.format("Can't get coordinates of horizontal line." +
                    " Start coordinate {0} and end coordinate {1} do not have the same y-value.", start, end));

        if (start.getX() > end.getX())
            throw new IllegalStateException(MessageUtil.format("Can't get coordinates of horizontal line." +
                    " The x-value of the end coordinate must be bigger then the x-value of the start coordinate."));

        List<Coordinate> coordinateList = new ArrayList<>();

        int numberOfCoordinates = end.getX() - start.getX() + 1;

        for (int i = 0; i < numberOfCoordinates; i++) {
            coordinateList.add(Coordinate.of(start.getX() + i, start.getY()));
        }

        return coordinateList;
    }
}