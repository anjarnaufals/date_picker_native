package com.example.date_picker_native;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

interface LifecycleProvider {

    @Nullable
    Lifecycle getLifecycle();
}