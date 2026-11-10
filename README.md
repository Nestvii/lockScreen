# UNO Lock Screen — Kotlin + XML

A minimal Android sample app with a manually opened, full-screen PIN screen.

## Behavior
- PIN demo: `1234`
- No sound or vibration implementation.
- Pressing **Aktifkan lockscreen** opens the lock screen.
- Correct PIN closes the lock screen.
- A `BOOT_COMPLETED` receiver clears the enabled flag after reboot.
- It does not auto-launch after reboot.
- It does not use Device Owner, Kiosk Mode, Accessibility Service, or overlays.
- It does not lock other apps or replace Android's system lock screen.

## Build
1. Open this folder in Android Studio.
2. Use JDK 17.
3. Allow Gradle sync.
4. Build > Build Bundle(s) / APK(s) > Build APK(s).

SDK: compileSdk 35, minSdk 23, targetSdk 35.

## Important scope
This is an in-app full-screen lock demonstration, not a system-wide App Lock. Android does not let an ordinary app replace the system lock screen or reliably cover other apps without additional privileged/device-management mechanisms.
