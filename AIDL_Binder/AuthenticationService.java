package com.ccdt.itvision.service.authentication;

//import io.vov.vitamio.utils.Log;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.ccdt.itvision.base.RequestService;
import com.ccdt.itvision.data.config.SharedPrefsConfig;
import com.ccdt.itvision.data.model.AuthResult;
import com.ccdt.itvision.data.requestmanager.ITvRequestFactory;
import com.ccdt.itvision.util.Utility;
import com.foxykeep.datadroid.requestmanager.Request;

public class AuthenticationService extends RequestService {
	public static final int AUTH_STATUS_ONGOING = 10;
	public static final int AUTH_STATUS_SUCESS = 20;
	public static final int AUTH_STATUS_FAIL = 30;

	public static final int REGISTER_STATUS_ONGOING = 100;
	public static final int REGISTER_STATUS_SUCESS = 200;
	public static final int REGISTER_STATUS_FAIL = 300;

	private int mAuthStatus = -1;
	private int mRegisterStatus = -1;
	private ArrayList<IAuthListener> mAuthListeners;
	private ArrayList<IRegisterListener> mRegisterListeners;
	private IAuthenticationService.Stub mAuthServiceStub = new IAuthenticationService.Stub() {

		@Override
		public void doAuth(String mac, String businessType, String sn) throws RemoteException {
			if (mAuthStatus == AUTH_STATUS_ONGOING) {
				return;
			}
			mAuthStatus = AUTH_STATUS_ONGOING;
			launchRequest(ITvRequestFactory.getAuthTerminalRequest(mac, businessType, sn));
		}

		@Override
		public void addAuthListener(IAuthListener l) throws RemoteException {
			if (!mAuthListeners.contains(l)) {
				mAuthListeners.add(l);
			}
		}

		@Override
		public void removeAuthListener(IAuthListener l) throws RemoteException {
			mAuthListeners.remove(l);
		}

		@Override
		public int checkAuthStatus() throws RemoteException {
			return mAuthStatus;
		}

		@Override
		public void doRegister(String userName, String password) throws RemoteException {
			// TODO
		}

		@Override
		public void addRegisterListener(IRegisterListener l) throws RemoteException {
			if (!mRegisterListeners.contains(l)) {
				mRegisterListeners.add(l);
			}
		}

		@Override
		public void removeRegisterListener(IRegisterListener l) throws RemoteException {
			mRegisterListeners.remove(l);
		}

		@Override
		public int checkRegisterStatus() throws RemoteException {
			return mRegisterStatus;
		}
	};

	@Override
	public IBinder onBind(Intent arg0) {
	    Log.e("test", "onBind, " + mAuthServiceStub);
		return mAuthServiceStub;
	}

	@Override
	public void initAllMembers(Bundle savedInstanceState) {
		super.initAllMembers(savedInstanceState);
		mAuthListeners = new ArrayList<IAuthListener>();
		mRegisterListeners = new ArrayList<IRegisterListener>();
	}

	@Override
	public void onDestroy() {
		mAuthListeners.clear();
		mRegisterListeners.clear();
		super.onDestroy();
	}

	@Override
	public void onRequestSucess(Request request, Bundle bundle) {
		if (mAuthStatus == AUTH_STATUS_ONGOING) {
			AuthResult result = null;
			if (bundle != null) {
				result = (AuthResult) bundle.getParcelable(ITvRequestFactory.BUNDLE_EXTRA_AUTH_RESULT);
			}
			if (result != null && result.mSucess) {
				mAuthStatus = AUTH_STATUS_SUCESS;
				Utility.saveUniqueID(this, result.mUniqueID);
				Utility.setUrl(this, SharedPrefsConfig.SHARED_PREFS_HOST, result.mHost);
				NotifyAuthListener(EXCEPTION_NONE);
			}
			if (result != null && !result.mSucess) {
				handleException(EXCEPTION_TYPE_AUTH);
			}
		}

		if (mRegisterStatus == REGISTER_STATUS_ONGOING) {
			mRegisterStatus = REGISTER_STATUS_SUCESS;
			NotifyRegisterListener(EXCEPTION_NONE);
		}
	}

	@Override
	public void onRequestError(int exceptionType) {
		if (mAuthStatus == AUTH_STATUS_ONGOING) {
			mAuthStatus = AUTH_STATUS_FAIL;
			NotifyAuthListener(exceptionType);
		}

		if (mRegisterStatus == REGISTER_STATUS_ONGOING) {
			mRegisterStatus = REGISTER_STATUS_FAIL;
			NotifyRegisterListener(exceptionType);
		}
	}

	private void NotifyAuthListener(int exceptionType) {
		try {
			for (int i = mAuthListeners.size() - 1; i >= 0; i--) {
				if (EXCEPTION_NONE == exceptionType) {
					mAuthListeners.get(i).onAuthSucess();
				} else {
					mAuthListeners.get(i).onAuthFail(exceptionType);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void NotifyRegisterListener(int exceptionType) {
		try {
			for (int i = mRegisterListeners.size() - 1; i >= 0; i--) {
				if (EXCEPTION_NONE == exceptionType) {
					mRegisterListeners.get(i).onRegisterSucess();
				} else {
					mRegisterListeners.get(i).onRegisterFail(exceptionType);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

