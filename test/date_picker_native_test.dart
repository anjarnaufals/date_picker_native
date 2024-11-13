import 'package:flutter_test/flutter_test.dart';
import 'package:date_picker_native/date_picker_native.dart';
import 'package:date_picker_native/date_picker_native_platform_interface.dart';
import 'package:date_picker_native/date_picker_native_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockDatePickerNativePlatform
    with MockPlatformInterfaceMixin
    implements DatePickerNativePlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final DatePickerNativePlatform initialPlatform = DatePickerNativePlatform.instance;

  test('$MethodChannelDatePickerNative is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelDatePickerNative>());
  });

  test('getPlatformVersion', () async {
    DatePickerNative datePickerNativePlugin = DatePickerNative();
    MockDatePickerNativePlatform fakePlatform = MockDatePickerNativePlatform();
    DatePickerNativePlatform.instance = fakePlatform;

    expect(await datePickerNativePlugin.getPlatformVersion(), '42');
  });
}
