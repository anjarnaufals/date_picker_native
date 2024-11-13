#include "include/date_picker_native/date_picker_native_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "date_picker_native_plugin.h"

void DatePickerNativePluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  date_picker_native::DatePickerNativePlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
