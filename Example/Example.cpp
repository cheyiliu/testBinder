// File: Example.cpp
#include <binder/IServiceManager.h>
#include <binder/IPCThreadState.h>
#include "Example.h"

namespace android
{
    sp<IBinder> binder;
    void Example::add100(int n)
    {
        getExampleService();
        Parcel data, reply;
        int answer;
        
        data.writeInt32(getpid());
        data.writeInt32(n);
        LOGE("BpExampleService::create remote()->transact()/n");
        binder->transact(0, data, &reply);
        answer = reply.readInt32();
        printf("answner=%d", answer);
        LOGE("-----------------------------------------------> answer = r = %d", answer);
        LOGE("-----------------cool   -----------------------> answer = r = %d", answer);
        LOGE("-----------------------------------------------> answer = r = %d", answer);
        return;
    }

    const void Example::getExampleService()
    {
        sp<IServiceManager> sm = defaultServiceManager();
        binder = sm->getService(String16("byn.example"));
        LOGE("----------------------------------------------->Example::getExampleService %p/n",sm.get());
        if (binder == 0) {
            LOGW("----------------------------------------------->ExampleService not published, waiting...");
        return;
        }
    }
}; //namespace

using namespace android;

int main(int argc, char** argv)
{
    Example* p = new Example();
    p->add100(1);
    return 0;
}
