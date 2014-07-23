package com.ccdt.itvision.service.authentication;

import com.ccdt.itvision.service.authentication.IAuthListener;
import com.ccdt.itvision.service.authentication.IRegisterListener;

interface IAuthenticationService{
    void doAuth(String mac, String businessType, String sn);
    void addAuthListener(IAuthListener l);
    void removeAuthListener(IAuthListener l);
    int  checkAuthStatus();
    
    void doRegister(String userName, String password);
    void addRegisterListener(IRegisterListener l);
    void removeRegisterListener(IRegisterListener l);
    int  checkRegisterStatus();
}