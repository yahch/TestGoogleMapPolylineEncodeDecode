package com.igpsport.gmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzhi on 2016/11/2.
 */
public class PolylineEncoder {

    private static void encode(long v, StringBuffer result) {

        v = v < 0 ? ~(v << 1) : v << 1;
        while (v >= 0x20) {
            result.append(Character.toChars((int) ((0x20 | (v & 0x1f)) + 63)));
            v >>= 5;
        }
        result.append(Character.toChars((int) (v + 63)));

    }

    public static String encode(double point) {
        final StringBuffer result = new StringBuffer();
        long iv = Math.round(point * 1e5);
        encode(iv, result);
        return result.toString();
    }

    public static String encode(final List<LatLng> path) {
        long lastLat = 0;
        long lastLng = 0;

        final StringBuffer result = new StringBuffer();

        for (final LatLng point : path) {
            long lat = Math.round(point.getLat() * 1e5);
            long lng = Math.round(point.getLon() * 1e5);

            long dLat = lat - lastLat;
            long dLng = lng - lastLng;

            encode(dLat, result);
            encode(dLng, result);

            lastLat = lat;
            lastLng = lng;
        }
        return result.toString();
    }

}
