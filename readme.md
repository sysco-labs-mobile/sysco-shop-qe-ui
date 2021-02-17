# Sysco Shop Auto Tests for iOS and Android

### Test Framework Description
- Appium
- TestNG 
- Parallel Device Execution
- Page Object Model 
- Ids and accessibility ids were used when available, xpath only if necessary
- Produces HTML report in `Extent.html`
- Records videos for each test and saves in `videos/device_name`
- Saves screenshots of page that failed test in `Screenshots`
- Saves Appium Server logs in `ServerLogs`

### Smoke Test Suite
`testng.xml`
`src/test/java/com.qe.tests`

Covers some basic uses cases and elements presence

- LoginTests
- DiscoverTests
- GuestTests
- ListsTests
- MultibuyerTests
- OrderCartTests
- SearchCatalogTests
- OrdersTests

Some tests became flaky already, have not pinpointed the issues yet

#### Out of Scope
- WebViews: Onboarding, MA login and Sysco Pay
- Not yet accessible elements or use cases that are long to automate
- Android keyboard RETURN or SEARCH can not be triggered - Search input field needs to have key Listener Event in app code 

### Execute
- Right click run `testng.xml` or `iOS.xml` or `Android.xml`

### Framework Setup
- Install dependencies `mvn install` or `mvn clean install -U -X`
- Update Simulators and emulators references in `testng.xml` or `iOS.xml` or `Android.xml`
- Update Env setup properties in `src/main/java/com/qe/BaseTest.java` for method `com.qe.BaseTest.getAppiumService`
- Update app files if new available in `src/test/resources/app`
- Update app configs in `src/main/resources/config.properties`

### Env Setup
If you have smth installed already skip such step

- Install Node and NPM (Appium dependencies) `brew install node` or `node -v`
  `npm -v` 
- Install Java SDK `brew install java` or `java -version`, if issues refer https://devqa.io/brew-install-java/
- Install xcode and cmd tools `xcode-select --install`
- Install android studio https://developer.android.com/studio
- Install xcpretty `gem install xcpretty`
- Install appium `npm install -g Appium` or `appium -v`-
- Install carthage `brew install Carthage`
- Update .bash_profile or .zprofile and source it to reflect your setup for ex.:
- Verify your setup `npm install -g appium-doctor` and `appium-doctor`
- Sample of .bash_profile or .zprofile content that works on recent MacOS BigSur

```export JAVA_HOME=$(/usr/libexec/java_home)
export ANDROID_HOME=${HOME}/Library/Android/sdk
export PATH="${JAVA_HOME}/bin:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${PATH}"
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH="/usr/local/opt/ruby/bin:$PATH"
export PATH="/usr/local/opt/ruby/bin:$PATH"
export PATH="/usr/local/opt/ruby/bin:$PATH"
export PATH="/usr/local/opt/openjdk/bin:$PATH"
export PATH="/usr/local/opt/openjdk/bin:$PATH"
```