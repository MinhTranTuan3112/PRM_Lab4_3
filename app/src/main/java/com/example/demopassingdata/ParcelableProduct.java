package com.example.demopassingdata;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ParcelableProduct implements Parcelable {
    public int id;
    public String name;
    public double price;

    public ParcelableProduct() {

    }

    public ParcelableProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    // Parcelable constructor (to create object from a Parcel)
    protected ParcelableProduct(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readDouble();
    }

    // Writing data to the Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(price);
    }

    @Override
    public int describeContents() {
        return 0; // Always return 0 unless using special file descriptors
    }

    // CREATOR field for generating instances of the Parcelable class
    public static final Parcelable.Creator<ParcelableProduct> CREATOR = new Parcelable.Creator<ParcelableProduct>() {
        @Override
        public ParcelableProduct createFromParcel(Parcel in) {
            return new ParcelableProduct(in);
        }

        @Override
        public ParcelableProduct[] newArray(int size) {
            return new ParcelableProduct[size];
        }
    };

    // Getters for demonstration purposes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
