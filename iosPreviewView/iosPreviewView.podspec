Pod::Spec.new do |s|
  s.name             = 'iosPreviewView'
  s.version          = '0.1.0'
  s.summary          = 'Preview View'
  s.description      = "Preview View library for Compose Multiplatform"

  s.homepage         = 'https://github.com/akexorcist/ios-preview-view'
  s.license          = { :type => 'Apache License, Version 2.0', :file => 'LICENSE' }
  s.author           = { 'Akexorcist' => 'akexorcist@gmail.com' }
  s.source           = { :git => 'https://github.com/akexorcist/ios-preview-view.git', :tag => s.version.to_s }

  s.ios.deployment_target = '17.0'

  s.source_files = 'src/*'
  s.public_header_files = 'src/*.h'
  s.swift_version = '5.10'
end
