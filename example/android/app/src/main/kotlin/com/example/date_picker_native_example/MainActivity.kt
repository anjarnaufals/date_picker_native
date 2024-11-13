package com.example.date_picker_native_example

import android.os.Bundle
import com.example.date_picker_native.DatePickerFactory
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister

class MainActivity: FlutterFragmentActivity(){

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        flutterEngine
                .platformViewsController
                .registry
                .registerViewFactory("<platform-view-type>",
                                      DatePickerFactory())
    }
}
