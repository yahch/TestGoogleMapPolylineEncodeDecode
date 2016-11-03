# TestGoogleMapPolylineEncodeDecode

[Get JAR](https://github.com/yahch/TestGoogleMapPolylineEncodeDecode/blob/master/GmapPolylineEncoder.jar)

## sample

encode:

```java
List<LatLng> latLngs = new ArrayList<>();
...
String result = PolylineEncoder.encode(latLngs);
```

decode:

```java
List<LatLng> lss = PolylineDecoder.decode(result);
```


## References

Encoded Polyline Algorithm Format

https://developers.google.com/maps/documentation/utilities/polylinealgorithm

android-maps-utils

https://github.com/googlemaps/android-maps-utils/blob/master/library/src/com/google/maps/android/PolyUtil.java
