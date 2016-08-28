package com.example.ceval.beastexample1.entites;

import android.os.Parcel;
import android.os.Parcelable;

public class Brother implements Parcelable {
    private int brotherId;
    private String brotherName;
    private String whyJoin;
    private String brotherPicture;
    private String brotherMajor;
    private String brotherCrossSemester;
    private String brotherFunFact;


    public Brother(int brotherId, String brotherName, String whyJoin, String brotherPicture, String brotherMajor, String brotherCrossSemester, String brotherFunFact) {
        this.brotherId = brotherId;
        this.brotherName = brotherName;
        this.whyJoin = whyJoin;
        this.brotherPicture = brotherPicture;
        this.brotherMajor = brotherMajor;
        this.brotherCrossSemester = brotherCrossSemester;
        this.brotherFunFact = brotherFunFact;
    }

    protected Brother(Parcel in) {
        brotherId = in.readInt();
        brotherName = in.readString();
        whyJoin = in.readString();
        brotherPicture = in.readString();
        brotherMajor = in.readString();
        brotherCrossSemester = in.readString();
        brotherFunFact = in.readString();

    }



    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(brotherId);
        dest.writeString(brotherName);
        dest.writeString(whyJoin);
        dest.writeString(brotherPicture);
        dest.writeString(brotherMajor);
        dest.writeString(brotherCrossSemester);
        dest.writeString(brotherFunFact);
    }

    public int getBrotherId() {
        return brotherId;
    }

    public String getBrotherName() {
        return brotherName;
    }

    public String getWhyJoin() {
        return whyJoin;
    }

    public String getBrotherPicture() {
        return brotherPicture;
    }

    public String getBrotherMajor() {
        return brotherMajor;
    }

    public String getBrotherCrossSemester() {
        return brotherCrossSemester;
    }

    public String getBrotherFunFact() {
        return brotherFunFact;
    }

    public static final Creator<Brother> CREATOR = new Creator<Brother>() {
        @Override
        public Brother createFromParcel(Parcel in) {
            return new Brother(in);
        }

        @Override
        public Brother[] newArray(int size) {
            return new Brother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
