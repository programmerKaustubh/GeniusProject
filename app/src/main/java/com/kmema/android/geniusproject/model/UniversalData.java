package com.kmema.android.geniusproject.model;


import android.os.Parcel;
import android.os.Parcelable;

public class UniversalData implements Parcelable {


    protected UniversalData(Parcel in) {
    }

    public static final Creator<UniversalData> CREATOR = new Creator<UniversalData>() {
        @Override
        public UniversalData createFromParcel(Parcel in) {
            return new UniversalData(in);
        }

        @Override
        public UniversalData[] newArray(int size) {
            return new UniversalData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
