package com.qzl.lib.qalogutils

import android.util.Log

/**
 * @author 强周亮
 * @desc 日志输出控件封装
 * @email 2538096489@qq.com
 * @time 2021/7/13 4:43 下午
 */
object QALogUtil {

    private const val mTag = "QALogUtil"
    enum class QALogLevel(val level: Int) {
        /**
         * 不输出任何日志
         */
        LEVEL_NONE(0),

        /**
         * 只输出错误信息
         */
        LEVEL_ERROR (1),

        /**
         * 输出最低级别为警告信息
         */
        LEVEL_WARN (2),

        /**
         * 输出最低级别为 info信息
         */
        LEVEL_INFO (3),

        /**
         * 输出最低级别为 debug信息
         */
        LEVEL_DEBUG (4),

        /**
         * 输出任何日志信息
         */
        LEVEL_VERBOSE (5),
    }
    /**
     * 显示日志控制:初始化显示所有信息
     */
    private var mDebuggable: QALogLevel = QALogLevel.LEVEL_VERBOSE

    @JvmStatic
    fun initLogLevel(logLevel: QALogLevel){
        mDebuggable = logLevel
    }

    @JvmStatic
    fun v(msg: String) {
        if (mDebuggable.level >= 5) {
            Log.v(mTag, msg)
        }
    }
    @JvmStatic
    fun d(msg: String) {
        if (mDebuggable.level >= 4) {
            Log.d(mTag, msg)
        }
    }
    @JvmStatic
    fun i(msg: String) {
        if (mDebuggable.level >= 3) {
            Log.i(mTag, msg)
        }
    }
    @JvmStatic
    fun w(msg: String) {
        if (mDebuggable.level >= 2) {
            Log.w(mTag, msg)
        }
    }
    @JvmStatic
    fun w(tr: Throwable) {
        if (mDebuggable.level >= 2) {
            Log.w(mTag, "", tr)
        }
    }
    @JvmStatic
    fun w(msg: String, tr: Throwable?) {
        if (mDebuggable.level >= 2) {
            Log.w(mTag, msg, tr)
        }
    }
    @JvmStatic
    fun e(msg: String) {
        if (mDebuggable.level >= 1) {
            Log.e(mTag, msg)
        }
    }
    @JvmStatic
    fun e(tr: Throwable?) {
        if (mDebuggable.level >= 1) {
            Log.e(mTag, "", tr)
        }
    }
    @JvmStatic
    fun e(msg: String?, tr: Throwable?) {
        if (mDebuggable.level >= 1 && msg != null) {
            Log.e(mTag, msg, tr)
        }
    }

    @JvmStatic
    fun logErrAll(msg: String){
        if (mDebuggable.level >= 1) {
            val segmentSize = 3 * 1024
            val length: Int = msg.length
            if (length <= segmentSize) { // 长度小于等于限制直接打印
                Log.e(mTag, msg)
            } else {
                var tempMsg = msg
                while (tempMsg.length > segmentSize) { // 循环分段打印日志
                    val logContent = tempMsg.substring(0, segmentSize)
                    tempMsg = tempMsg.replace(logContent, "")
                    Log.e(mTag, logContent)
                }
                Log.e(mTag, tempMsg)
            }
        }
    }
}