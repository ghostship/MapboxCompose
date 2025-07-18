// swift-tools-version: 5.9
import PackageDescription

let package = Package(
  name: "exportedNativeBridge",
  platforms: [.iOS("16.0"), .macOS("10.13"), .tvOS("12.0"), .watchOS("4.0")],
  products: [
    .library(
      name: "exportedNativeBridge",
      type: .static,
      targets: ["exportedNativeBridge"])
  ],
  dependencies: [
    .package(path: "/Users/scott.keller/Repos/MapboxCompose/library/../")
  ],
  targets: [
    .target(
      name: "exportedNativeBridge",
      dependencies: [
        .product(name: "MapboxWrapper", package: "MapboxCompose")
      ],
      path: "Sources"

    )

  ]
)
