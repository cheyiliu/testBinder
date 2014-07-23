testBinder
==========

test proj

==========
from http://blog.csdn.net/baiyanning/article/details/6191682
and tested on android 4.0

==========
the output
    /system/lib/libExample.so
    /system/bin/ExampleServer
    /system/bin/Example

usage
    ./ExampleServer &
    ./Example

adb logcat output
    I/(  724): ---------------> ServiceManager: 0xa680
    E/(  724): --------------->ExampleService instantiate
    E/(  727): --------------->Example::getExampleService 0xa690/n
    E/(  727): BpExampleService::create remote()->transact()/n
    E/(  724): ExampleService onTransact pid   = 727
    E/(  724): ExampleService onTransact num orig      = 1
    E/(  724): ExampleService onTransact num added 100 = 101
    E/(  727): ---------------> answer = r = 101    
    E/(  727): -cool   -------> answer = r = 101
    E/(  727): ---------------> answer = r = 101

One chart: client <----> proxy <==ipc==> stub <----> service

in C: 
    client <----> proxy (binder = sm->getService, binder->transact(0, data, &reply))
    stub <----> service(onTransact switch(code) case doxx)

in Java:
    client <----> proxy (bindService, onServiceConnected, asInterface(service), xxService.doxx, mRemote.transact)
    stub <----> service(IAuthenticationService.Stub.onTransact  switch(code) case doxx)
