package com.hx.qimao

import android.R.attr.classLoader
import android.content.Context
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage


class AppHook: IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName == "com.kmxs.reader") {
            XposedBridge.log("start hook...")
            XposedHelpers.findAndHookMethod("rh", lpparam.classLoader, "isVipUser",
                Context::class.java, object : XC_MethodHook() {

                    @Throws(Throwable::class)
                    override fun afterHookedMethod(param: MethodHookParam) {
                        super.afterHookedMethod(param)
                        param.result = true
                    }
                })
            XposedHelpers.findAndHookMethod("fx3", lpparam.classLoader, "Y",
                Context::class.java, object : XC_MethodHook() {
                    @Throws(Throwable::class)
                    override fun afterHookedMethod(param: MethodHookParam) {
                        super.afterHookedMethod(param)
                        param.result = "1"
                    }
                })
            XposedHelpers.findAndHookMethod("fx3", lpparam.classLoader, "A0",
                Context::class.java, object : XC_MethodHook() {
                    @Throws(Throwable::class)
                    override fun afterHookedMethod(param: MethodHookParam) {
                        super.afterHookedMethod(param)
                        param.result = true
                    }
                })
            XposedHelpers.findAndHookMethod(
                "com.qimao.qmservice.reader.entity.CommonBook",
                lpparam.classLoader,
                "isBookVip",
                object : XC_MethodHook() {

                    @Throws(Throwable::class)
                    override fun afterHookedMethod(param: MethodHookParam) {
                        super.afterHookedMethod(param)
                        param.result = true
                    }
                })

        }
    }
}