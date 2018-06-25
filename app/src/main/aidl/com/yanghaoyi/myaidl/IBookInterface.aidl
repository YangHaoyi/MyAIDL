// IBookInterface.aidl
package com.yanghaoyi.myaidl;
//import进序列化文件的路径
// Declare any non-default types here with import statements
import com.yanghaoyi.myaidl.Book;

interface IBookInterface {
       Book getBook();
}
