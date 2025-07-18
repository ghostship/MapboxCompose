#
# Be sure to run `pod lib lint MapboxWrapper.podspec' to ensure this is a
# valid spec before submitting.
#
# Any lines starting with a # are optional, but their use is encouraged
# To learn more about a Podspec see https://guides.cocoapods.org/syntax/podspec.html
#

Pod::Spec.new do |s|
  s.name             = 'MapboxWrapper'
  s.version          = '0.1.0'
  s.summary          = 'A short description of MapboxWrapper.'
  s.description      = 'Add long description of the pod here.'
  s.homepage         = 'https://github.com/ScottKeller/MapboxWrapper'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'Scott Keller' => 'scott.keller@inspiringapps.com' }
  s.source           = { :git => 'https://github.com/ScottKeller/MapboxWrapper.git', :tag => s.version.to_s }

  s.swift_version = '5.0'
  s.ios.deployment_target = '16.0'
  s.source_files = 'Sources/MapboxWrapper/**/*'
  
  s.dependency 'MapboxMaps', '~> 11.13.3'
end
