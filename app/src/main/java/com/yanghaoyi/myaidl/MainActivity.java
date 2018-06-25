package com.yanghaoyi.myaidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private IBookInterface mStub;
    private TextView tvNote;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mStub = IBookInterface.Stub.asInterface(service);
            try {
                Book book = mStub.getBook();
                tvNote.setText(book.getName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNote = findViewById(R.id.tvNote);
        Intent intent = new Intent();
        intent.setAction("com.yanghaoyi.MyService");
        intent.setPackage("com.yanghaoyi.myaidl"); //packageName 需要和服务端的一致.
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
