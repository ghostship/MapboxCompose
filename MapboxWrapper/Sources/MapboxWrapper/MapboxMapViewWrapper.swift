import UIKit
import MapboxMaps

@objcMembers public class MyDummyView: UIView {}

@objcMembers
public class MapboxMapViewWrapper: NSObject {

    public func createMapView(bounds: CGRect, token: String) -> UIView {
        MapboxOptions.accessToken = token

        let view = MapView(frame: bounds, mapInitOptions: MapInitOptions.init())

        let cameraOptions = CameraOptions(center:
            CLLocationCoordinate2D(latitude: 39.5, longitude: -98.0),
            zoom: 2, bearing: 0, pitch: 0)

        view.mapboxMap.setCamera(to: cameraOptions)
        view.autoresizingMask = [.flexibleWidth, .flexibleHeight]

        return view
    }
}