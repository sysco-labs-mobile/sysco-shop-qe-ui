git clone https://github.com/sysco-labs-mobile/sysco-shop-android.git
cd sysco-shop-android
gradle wrapper # --gradle-version v.xy
./gradlew assembleDebug
cd ..
cd ..
cp scripts/sysco-shop-android/app/build/outputs/apk/dev/debug/app-dev-debug.apk src/test/resources/app/
mvn clean install