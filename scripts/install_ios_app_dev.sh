git clone https://github.com/sysco-labs-mobile/sysco-shop-ios.git
cd sysco-shop-ios
##archive command from bitrise log with slight edits
## where to get export_options.plist
xcodebuild "-workspace" "SyscoShopApp/SyscoShopApp.xcworkspace" "-scheme" "SyscoShopApp-dev" "-configuration" "Debug" "COMPILER_INDEX_STORE_ENABLE=NO" "archive" "-archivePath" "SyscoShopApp-dev.xcarchive" "-sdk" "iphonesimulator" "-destination" "generic/platform=iOS Simulator"| xcpretty
xcodebuild "-exportArchive" "-archivePath" "SyscoShopApp-dev.xcarchive" "-exportPath" "SyscoShopApp-dev_ipa" "-exportOptionsPlist" "export_options.plist" "-destination" "platform=iOS Simulator,id=48C09AF0-ECA1-473A-AA6A-57FDDDAA6F4C,OS=14.4"| xcpretty