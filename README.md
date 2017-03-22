# 设计模式


---------------

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

单例对象如果持有Context，很容易造成内存泄漏，最好传递ApplicationContext

------------------

## Builder模式

### 定义

将一个复杂对象的构建过程分离，使得同样的构建过程可以创建不同的结果。

### 使用场景

- 相同的方法，不同的执行顺序，产生不同的结果
- 多个零件或者部件，可以组装到一个对象中，产生不同的结果
- 初始化过程比较复杂，参数较多

举一个例子，Android对话框，就是Builder模式，像这样：
``` java
new AlertDialog.Builder(this)
        .setTitle("xxx")
        .setMessage("xxx")
        .create()
        .show();
```

本是一个相对复杂的对话框，通过链式编程构建出来。

### 实现

我们假设组装一台宝马轿车，它有品牌、型号、颜色。

车
``` java
public abstract class Car {
    // 品牌
    protected String mBrand;
    // 型号
    protected String mModel;
    // 颜色
    protected String mColor;

    public abstract void setBrand();

    public void setColor(String mColor) {
        this.mColor = mColor;
    }

    public void setModel(String model) {
        this.mModel = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mBrand='" + mBrand + '\'' +
                ", mModel='" + mModel + '\'' +
                ", mColor='" + mColor + '\'' +
                '}';
    }
}
```

宝马车

``` java
public class BMWCar extends Car {

    @Override
    public void setBrand() {
        mBrand = "BMW";
    }
}
```

下面是Builder类，用来描述构建一台车需要哪些方法

``` java
public abstract class CarBuilder {

    public abstract CarBuilder buildBrand();

    public abstract CarBuilder buildModel(String model);

    public abstract CarBuilder buildColor(String color);

    public abstract Car create();
}
```

接下来来实现构建一台宝马车的Builder

``` java
public class BMWBuilder extends CarBuilder {

    Car car = new BMWCar();

    @Override
    public BMWBuilder buildBrand() {
        car.setBrand();
        return this;
    }

    @Override
    public BMWBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    @Override
    public BMWBuilder buildColor(String color) {
        car.setColor(color);
        return this;
    }

    @Override
    public Car create() {
        return car;
    }
}
```

这里的build方法都返回自身，用来链式调用。

### 调用

下面来构建一台红色的3系宝马轿车

``` java
new BMWBuilder()
        .buildBrand()
        .buildModel("3 Li")
        .buildColor("红色")
        .create();
```

如果你还想给车子添加个HUD、换个真皮座椅，只需要在Builder里添加对用的方法，构建的时候设置属性就可以了。

### 结论

Builder设计模式具有良好的封装性，构建者独立，方便扩展。
不足就是需要创建多个Builder。
