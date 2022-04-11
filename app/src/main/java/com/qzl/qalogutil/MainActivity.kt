package com.qzl.qalogutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qzl.lib.qalogutils.Utils
import com.qzl.lib.qalogutils.QALogUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        QALogUtil.initLogLevel(QALogUtil.QALogLevel.LEVEL_DEBUG)
        QALogUtil.i("我是 info")
        QALogUtil.v("我是 v")
        QALogUtil.w("我是 warring")
        QALogUtil.e("我是错误信息")
        QALogUtil.logErrAll("ninininininini")
        Utils.e("jfisdjfisjfidfjisdjiji")
    }
}