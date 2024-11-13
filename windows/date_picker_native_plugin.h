#ifndef FLUTTER_PLUGIN_DATE_PICKER_NATIVE_PLUGIN_H_
#define FLUTTER_PLUGIN_DATE_PICKER_NATIVE_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace date_picker_native {

class DatePickerNativePlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  DatePickerNativePlugin();

  virtual ~DatePickerNativePlugin();

  // Disallow copy and assign.
  DatePickerNativePlugin(const DatePickerNativePlugin&) = delete;
  DatePickerNativePlugin& operator=(const DatePickerNativePlugin&) = delete;

  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace date_picker_native

#endif  // FLUTTER_PLUGIN_DATE_PICKER_NATIVE_PLUGIN_H_
