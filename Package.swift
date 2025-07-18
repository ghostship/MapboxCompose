// swift-tools-version:5.7
import PackageDescription

let package = Package(
    name: "MapboxWrapper",
    platforms: [
        .iOS(.v16)
    ],
    products: [
        .library(
            name: "MapboxWrapper",
            targets: ["MapboxWrapper"]
        )
    ],
    dependencies: [
        .package(url: "https://github.com/mapbox/mapbox-maps-ios.git", from: "11.13.3")
    ],
    targets: [
        .target(
            name: "MapboxWrapper",
            path: "MapboxWrapper/Sources/MapboxWrapper",
            dependencies: [
                .product(name: "MapboxMaps", package: "mapbox-maps-ios")
            ]
        ),
    ]
)