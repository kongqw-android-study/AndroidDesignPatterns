## 单例模式

### 定义

确保某一个类只有一个实例，并且自行实例化并向整个系统提供这个实例。

### 使用场景

确保某个类有且只有一个，避免产生过多对象消耗过多的资源，比如，太阳只有一个，地球只有一个……

### 关键点

- 构造函数不对外开放，一般为private
- 通过一个静态方法或者枚举返回单例类对象
- 对象有且只有一个，尤其是在多线程下
- 确保在反序列的时候不会重复构建对象

### 实现

#### 饿汉单例模式
``` java
public class HungerSingleton {

    private static final String TAG = "HungerSingleton";

    private static final HungerSingleton mHungerSingleton = new HungerSingleton();

    private HungerSingleton() {
        Log.i(TAG, "HungerSingleton: ");
    }

    public static HungerSingleton getInstance() {
        return mHungerSingleton;
    }

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
```

#### 懒汉单例模式

- 优点：使用的时候才进行初始化，节约了资源
- 缺点：第一次初始化较慢，每次都同步造成不必要的开销
- 结论：不推荐使用

``` java
public class LazySingleton {
    
    private static final String TAG = "LazySingleton";

    private static LazySingleton mLazySingleton;

    private LazySingleton() {
        Log.i(TAG, "LazySingleton: ");
    }

    /**
     * 获取单例
     * synchronized 确保在多线程下对象唯一行
     *
     * @return 单例
     */
    public static synchronized LazySingleton getInstance() {
        if (null == mLazySingleton) {
            mLazySingleton = new LazySingleton();
        }
        return mLazySingleton;
    }

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
```

#### Double Check Lock（DCL）单例模式

- 优点：在懒汉单例的基础上，不会多次执行同步操作，资源利用率高，效率高。
- 缺点：第一次加载较慢
- 结论：使用最多的单例实现方式

``` java
public class DCLSingleton {
    private static final String TAG = "DCLSingleton";

    private volatile static DCLSingleton mDCLSingleton = null;

    private DCLSingleton() {
        Log.i(TAG, "DCLSingleton: ");
    }

    public static DCLSingleton getInstance() {
        if (null == mDCLSingleton) { // 避免重复不必要的同步
            synchronized (DCLSingleton.class) { // 确保多线程下对象唯一
                if (null == mDCLSingleton) { // 非空的情况下创建实例
                    mDCLSingleton = new DCLSingleton();
                }
            }
        }
        return mDCLSingleton;
    }
    
    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
```

#### 静态内部类单例模式

- 优点：线程安全，保证对象唯一，延迟了实例化，
- 结论：推荐使用

``` java
public class StaticInnerClassSingleton {
    private static final String TAG = "StaticInnerClassSinglet";

    private StaticInnerClassSingleton() {
        Log.i(TAG, "StaticInnerClassSingleton: ");
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.staticInnerClassSingleton;
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    @Override
    public String toString() {
        return "I am " + TAG + "!";
    }
}
```


### 结论

1. 构造方法私有化
2. 通过静态方法获取一个唯一的实例
3. 保证线程安全
