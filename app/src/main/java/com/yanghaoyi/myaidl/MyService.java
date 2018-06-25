package com.yanghaoyi.myaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * @author : YangHaoYi on 2018/6/25.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/6/25.
 *         Version : V 1.0
 */
public class MyService extends Service{

    IBookInterface.Stub mStub = new IBookInterface.Stub() {
        @Override
        public Book getBook() throws RemoteException {
            Book book = new Book();
            book.setName("图吧导航");
            return book;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mStub;
    }
}
