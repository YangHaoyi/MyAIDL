package com.yanghaoyi.myaidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author : YangHaoYi on 2018/6/25.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/6/25.
 *         Version : V 1.0
 */
public class Book implements Parcelable{
    private String name;
    private String author;

    public Book(){

    }

    protected Book(Parcel in) {
        name = in.readString();
        author = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(author);
    }
}
