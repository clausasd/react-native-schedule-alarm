
# react-native-schedule-alarm

## Getting started

`$ npm install react-native-schedule-alarm --save`

### Mostly automatic installation

`$ react-native link react-native-schedule-alarm`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-schedule-alarm` and add `RNScheduleAlarm.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNScheduleAlarm.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNScheduleAlarmPackage;` to the imports at the top of the file
  - Add `new RNScheduleAlarmPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-schedule-alarm'
  	project(':react-native-schedule-alarm').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-schedule-alarm/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-schedule-alarm')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNScheduleAlarm.sln` in `node_modules/react-native-schedule-alarm/windows/RNScheduleAlarm.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Schedule.Alarm.RNScheduleAlarm;` to the usings at the top of the file
  - Add `new RNScheduleAlarmPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNScheduleAlarm from 'react-native-schedule-alarm';

// TODO: What to do with the module?
RNScheduleAlarm;
```
  