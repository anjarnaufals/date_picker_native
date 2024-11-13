import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'date_picker_native_platform_interface.dart';

/// An implementation of [DatePickerNativePlatform] that uses method channels.
class MethodChannelDatePickerNative extends DatePickerNativePlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('date_picker_native');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
