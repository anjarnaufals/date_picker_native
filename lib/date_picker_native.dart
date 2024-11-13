
import 'date_picker_native_platform_interface.dart';

class DatePickerNative {
  Future<String?> getPlatformVersion() {
    return DatePickerNativePlatform.instance.getPlatformVersion();
  }
}
