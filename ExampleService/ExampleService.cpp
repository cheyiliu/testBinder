// File: ExampleService.cpp
#include "ExampleService.h"
#include <binder/IServiceManager.h>
#include <binder/IPCThreadState.h>

namespace android {

    static struct sigaction oldact;
    static pthread_key_t sigbuskey;
    
    int ExampleService::instantiate()
    {
        LOGE("----------------------------------------------->ExampleService instantiate");
        // 调用ServiceManager的addService方法进行系统服务注册，这样客户端程序就可以通过ServiceManager获得此服务的代理对象，从而请求其提供的服务
        int r = defaultServiceManager()->addService(String16("byn.example"), new ExampleService());
        LOGE("ExampleService r = %d/n", r);
        return r;
    }

    ExampleService::ExampleService()
    { 
        LOGV("----------------------------------------------->ExampleService created");
        mNextConnId = 1;
        pthread_key_create(&sigbuskey, NULL);
    }

    ExampleService::~ExampleService()
    {
        pthread_key_delete(sigbuskey);
        LOGV("----------------------------------------------->ExampleService destroyed");
    }
    // 每个系统服务都继承自BBinder类，都应重写BBinder的onTransact虚函数。当用户发送请求到达Service时，系统框架会调用Service的onTransact函数
    status_t ExampleService::onTransact(uint32_t code, const Parcel& data, Parcel* reply, uint32_t flags)
    {
        LOGV("----------------------------------------------->ExampleService onTransact");
        switch(code)
        {
            case 0: {
                pid_t pid = data.readInt32();
                LOGE("ExampleService onTransact pid           = %d", pid);
                int num   = data.readInt32();
                LOGE("ExampleService onTransact num orig      = %d", num);
                num = num + 100;
                LOGE("ExampleService onTransact num added 100 = %d", num);
                reply->writeInt32(num);
                return NO_ERROR;
                }
                break;
            default:
                return BBinder::onTransact(code, data, reply, flags);
        }
    }
}; //namespace
