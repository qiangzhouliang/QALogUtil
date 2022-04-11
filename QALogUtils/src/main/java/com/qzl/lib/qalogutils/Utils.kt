package com.qzl.lib.qalogutils

import java.lang.Exception
import java.lang.StringBuilder
import java.util.ArrayList

/**
 * Utils-很好用的Log打印类，自动输出方法和行数
 */
class Utils {
    companion object {
        const val PREFIX = "QALogUtil->"
        private var mClassname: String? = null
        private var mMethods: ArrayList<String>? = null
        fun getMsgWithLineNumber(msg: String): String {
            try {
                for (st in Throwable().stackTrace) {
                    return if (mClassname == st.className || mMethods!!.contains(st.methodName)) {
                        continue
                    } else {
                        val b = st.className.lastIndexOf(".") + 1
                        StringBuilder(st.className.substring(b)).append("->")
                            .append("[").append(st.methodName)
                            .append("():").append(st.lineNumber)
                            .append("]").append(msg).toString()
                    }
                }
            } catch (e: Exception) {
            }
            return msg
        }

        fun getMsgAndTagWithLineNumber(msg: String): Array<String> {
            try {
                for (st in Throwable().stackTrace) {
                    return if (mClassname == st.className || mMethods!!.contains(st.methodName)) {
                        continue
                    } else {
                        val b = st.className.lastIndexOf(".") + 1
                        val TAG =
                            PREFIX + st.className.substring(b)
                        //String TAG = "fota";
                        val message =
                            st.methodName + "():" + st.lineNumber + "->" + msg
                        arrayOf(TAG, message)
                    }
                }
            } catch (e: Exception) {
            }
            return arrayOf("universal tag", msg)
        }

        init {
            mClassname = Utils::class.java.name
            mMethods = ArrayList()
            val ms = Utils::class.java.declaredMethods
            for (m in ms) {
                mMethods!!.add(m.name)
            }
        }
    }
}