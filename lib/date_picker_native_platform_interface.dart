import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'date_picker_native_method_channel.dart';

abstract class DatePickerNativePlatform extends PlatformInterface {
  /// Constructs a DatePickerNativePlatform.
  DatePickerNativePlatform() : super(token: _token);

  static final Object _token = Object();

  static DatePickerNativePlatform _instance = MethodChannelDatePickerNative();

  /// The default instance of [DatePickerNativePlatform] to use.
  ///
  /// Defaults to [MethodChannelDatePickerNative].
  static DatePickerNativePlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [DatePickerNativePlatform] when
  /// they register themselves.
  static set instance(DatePickerNativePlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
