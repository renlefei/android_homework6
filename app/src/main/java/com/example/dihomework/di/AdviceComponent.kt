package com.example.dihomework.di

import com.example.dihomework.MainActivity
import dagger.Component

@Component(modules = [AdviceModule::class])
interface AdviceComponent {
    fun inject(activity: MainActivity)
}