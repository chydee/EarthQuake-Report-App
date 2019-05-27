Quake Report App
===================================

This app displays a list of recent earthquakes in the world
from the U.S. Geological Survey (USGS) organization.


More info on the USGS Earthquake API available at:
https://earthquake.usgs.gov/fdsnws/event/1/

Pre-requisites
--------------

- Android SDK v23
- Android Build Tools v23.0.2
- Android Support Repository v23.3.0

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.


Quake app magnitude circle color explanation

The colors range from blue (low magnitude value) to red (high magnitude value). Anything above a magnitude 10 earthquake uses the darkest red color (#C03823). Anything between a magnitude 9 and 10 earthquake uses a slightly lighter red color (#D93218), anything between a magnitude 8 and 9 earthquake uses an even lighter red color (#E13A20), and so on. Each level has a different color. Anything below a 2.0 earthquake uses a blue color (#4A7BA7). 
