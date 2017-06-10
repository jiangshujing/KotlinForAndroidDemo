package com.jsj.kotlindemo.net

import android.os.Parcel
import android.os.Parcelable

/**
 *
 * @author jsj
 * @since 17/6/10
 */
data class ForecastBean(var name: String, var image: String) : Parcelable{

    constructor(source: Parcel): this(source.readString(), source.readString())

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}