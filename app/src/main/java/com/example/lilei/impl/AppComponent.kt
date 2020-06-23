package com.example.lilei.impl

import android.app.Application
import com.example.lilei.RxErrorHandler

/**
 * 作者 : LiLei
 * 时间 : 2020/06/23.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
interface AppComponent {
    /**
     * application对象
     * @return [Application]
     */
    open fun application(): Application?

    /**
     * 用于管理所有activity
     * @return [AppManager]
     */
    open fun appManager(): AppManager?

    /**
     * 用于管理网络请求层, 以及数据缓存层
     *
     * @return [IRepositoryManager]
     */
    open fun repositoryManager(): IRepositoryManager?


    /**
     * RxJava 错误处理管理类
     *
     * @return [RxErrorHandler]
     */
    open fun rxErrorHandler(): RxErrorHandler?

    /**
     * 图片加载管理器, 用于加载图片的管理类, 使用策略者模式, 可在运行时动态替换任何图片加载框架
     * arms-imageloader-glide 提供 Glide 的策略实现类, 也可以自行实现
     * 需要在 [ConfigModule.applyOptions] 中
     * 手动注册 [BaseImageLoaderStrategy], [ImageLoader] 才能正常使用
     *
     * @return
     */
    open fun imageLoader(): ImageLoader?

    /**
     * 网络请求框架
     *
     * @return [OkHttpClient]
     */
    open fun okHttpClient(): OkHttpClient?

    /**
     * Json 序列化库
     *
     * @return [Gson]
     */
    open fun gson(): Gson?

    /**
     * 缓存文件根目录 (RxCache 和 Glide 的缓存都已经作为子文件夹放在这个根目录下), 应该将所有缓存都统一放到这个根目录下
     * 便于管理和清理, 可在 [ConfigModule.applyOptions] 种配置
     *
     * @return [File]
     */
    open fun cacheFile(): java.io.File?

    /**
     * 用来存取一些整个 App 公用的数据, 切勿大量存放大容量数据, 这里的存放的数据和 [Application] 的生命周期一致
     *
     * @return [Cache]
     */
    open fun extras(): Cache?

    /**
     * 用于创建框架所需缓存对象的工厂
     *
     * @return [Cache.Factory]
     */
    open fun cacheFactory(): Cache.Factory?


    /**
     * 返回一个全局公用的线程池,适用于大多数异步需求。
     * 避免多个线程池创建带来的资源消耗。
     *
     * @return [ExecutorService]
     */
    open fun executorService(): java.util.concurrent.ExecutorService?


    open fun inject(delegate: AppDelegate?)

//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        open fun application(application: Application?): Builder?
//        open fun globalConfigModule(globalConfigModule: GlobalConfigModule?): Builder?
//        open fun build(): com.jess.arms.di.component.AppComponent?
//    }
}